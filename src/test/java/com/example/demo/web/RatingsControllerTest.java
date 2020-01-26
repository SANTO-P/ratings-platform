package com.example.demo.web;

import com.example.demo.service.RatingService;
import com.example.demo.view.ProductRatingView;
import com.example.demo.vo.RatingDetails;
import com.example.demo.vo.UserInformation;
import com.example.demo.web.request.RatingDetailsRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.assertj.core.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.restdocs.RestDocsMockMvcConfigurationCustomizer;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.now;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class RatingsControllerTest {

    @Mock
    private RatingService ratingService;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Before
    public void setUp(){
        mockMvc = standaloneSetup(new RatingsController(ratingService)).build();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    public void shouldStoreRatingsForGivenProductId() throws Exception {
        RatingDetailsRequest request = new RatingDetailsRequest("product-id", "user-id",
                new UserInformation("user-name"),
                new Integer(3),
                now());

        String requestBody = objectMapper.writeValueAsString(request);

        when(ratingService.storeProductRatings(request)).thenReturn(true);
        mockMvc.perform(
                post("/ratings/")
                .content(requestBody)
                .contentType(APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

    }

    @Test
    public void shouldReturnRatingsForGivenProductId() throws Exception {
        String productId = "product-id";
        List<RatingDetails> ratingDetails = new ArrayList<RatingDetails>();
        ratingDetails.add(new RatingDetails("user-id", "user-name", 4));
        ProductRatingView ExpectedView = new ProductRatingView( productId, ratingDetails,
                        256L, 3.4);

        when(ratingService.getProductRatings("product-id")).thenReturn(ExpectedView);
        ResultActions resultActions = mockMvc.perform(
                get("/ratings/{productId}", productId)
                        .contentType(APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        resultActions.andExpect(new ResultMatcher() {
            @Override
            public void match(MvcResult mvcResult) throws Exception {
                ProductRatingView actualView = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), ProductRatingView.class);
                Assert.assertEquals(ExpectedView, actualView);
            }
        });
    }

    @Test
    public void shouldValidateRatingRange() throws Exception {
        RatingDetailsRequest request = new RatingDetailsRequest("product-id", "user-id",
                new UserInformation("user-name"),
                new Integer(8),
                now());

        String requestBody = objectMapper.writeValueAsString(request);

        when(ratingService.storeProductRatings(request)).thenReturn(true);
        mockMvc.perform(
                post("/ratings/")
                        .content(requestBody)
                        .contentType(APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest()).andReturn();

    }


}