package com.example.demo.validator;

import com.example.demo.validator.RatingRange;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RatingRangeValidator implements ConstraintValidator<RatingRange, Integer> {

    @Override
    public void initialize(RatingRange constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer rating, ConstraintValidatorContext constraintValidatorContext) {
        if(rating < 1 || rating > 5){
            return false;
        }
        return true;
    }
}
