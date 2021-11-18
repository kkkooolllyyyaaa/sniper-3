package com.tsypk.sniper3.utils;

import com.tsypk.sniper3.model.Point;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author tsypk on 16.11.2021 20:43
 * @project sniper-3
 */
public class PointValidator {
    private static final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = validatorFactory.getValidator();

    public static void validate(Point point) {
        Set<ConstraintViolation<Point>> violations = validator.validate(point);
        for (ConstraintViolation<Point> cv : violations) {
            System.out.println(cv.getMessage());
        }
    }
}