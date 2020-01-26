package com.example.demo.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RatingRangeValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RatingRange {
    String message() default "Rating should be in the range 1-5";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
