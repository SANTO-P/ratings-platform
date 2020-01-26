package com.example.demo.web;

import com.example.demo.service.RatingService;
import com.example.demo.web.request.RatingDetailsRequest;
import com.example.demo.view.ProductRatingView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

    private RatingService ratingService;

    @Autowired
    public RatingsController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping(value = "/")
    public ResponseEntity storeProductRating(@Valid @RequestBody RatingDetailsRequest ratingDetailsRequest){
        ratingService.storeProductRatings(ratingDetailsRequest);
        return new ResponseEntity(OK);
    }

    @GetMapping(value = "/{productId}")
    public ResponseEntity<ProductRatingView> getProductRating(@PathVariable("productId") String productId){
        ProductRatingView  productRatingView = ratingService.getProductRatings(productId);
        ResponseEntity responseEntity = new ResponseEntity(productRatingView, OK);
        return responseEntity;
    }
}
