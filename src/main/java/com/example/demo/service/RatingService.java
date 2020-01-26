package com.example.demo.service;

import com.example.demo.view.ProductRatingView;
import com.example.demo.web.request.RatingDetailsRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    public boolean storeProductRatings(RatingDetailsRequest ratingDetailsRequest) {
        //Logic to store ratings
        return true;
    }


    public ProductRatingView getProductRatings(String productId) {
        // Logic to retrieve ratings with its average and total
        return null;
    }



}
