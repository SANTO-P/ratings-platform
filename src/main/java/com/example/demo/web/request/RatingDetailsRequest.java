package com.example.demo.web.request;


import com.example.demo.validator.RatingRange;
import com.example.demo.vo.UserInformation;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class RatingDetailsRequest {

    @NotNull
    private String productId;
    @NotNull
    private String userId;
    private UserInformation userInformation;
    @NotNull
    @RatingRange
    private Integer rating;
    private LocalDate timestamp;

    @SuppressWarnings("unused")
    public RatingDetailsRequest() {
    }

    public RatingDetailsRequest(String productId, String userId, UserInformation userInformation, Integer rating, LocalDate timestamp) {
        this.productId = productId;
        this.userId = userId;
        this.userInformation = userInformation;
        this.rating = rating;
        this.timestamp = timestamp;
    }

    public String getProductId() {
        return productId;
    }

    public String getUserId() {
        return userId;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public Integer getRating() {
        return rating;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }
}
