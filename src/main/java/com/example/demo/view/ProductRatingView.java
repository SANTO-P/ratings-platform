package com.example.demo.view;

import com.example.demo.vo.RatingDetails;

import java.util.List;
import java.util.Objects;

public class ProductRatingView {

    private String productId;
    private List<RatingDetails>ratingDetails;
    private Long ratingsCount;
    private Double averageRating;

    @SuppressWarnings("unused")
    public ProductRatingView() {
    }

    public ProductRatingView(String productId, List<RatingDetails> ratingDetails, Long ratingsCount, Double averageRating) {
        this.productId = productId;
        this.ratingDetails = ratingDetails;
        this.ratingsCount = ratingsCount;
        this.averageRating = averageRating;
    }

    public String getProductId() {
        return productId;
    }

    public List<RatingDetails> getRatingDetails() {
        return ratingDetails;
    }

    public Long getRatingsCount() {
        return ratingsCount;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRatingView that = (ProductRatingView) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(ratingDetails, that.ratingDetails) &&
                Objects.equals(ratingsCount, that.ratingsCount) &&
                Objects.equals(averageRating, that.averageRating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, ratingDetails, ratingsCount, averageRating);
    }
}
