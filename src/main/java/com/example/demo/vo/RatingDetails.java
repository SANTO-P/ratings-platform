package com.example.demo.vo;

import java.util.Objects;

public class RatingDetails {

    private String userId;
    private String userName;
    private Integer rating;

    @SuppressWarnings("unused")
    public RatingDetails() {
    }

    public RatingDetails(String userId, String userName, Integer rating) {
        this.userId = userId;
        this.userName = userName;
        this.rating = rating;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingDetails that = (RatingDetails) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(rating, that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, rating);
    }
}
