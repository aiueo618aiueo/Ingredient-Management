package com.example.Ingredient_Management.service;

import com.example.Ingredient_Management.exception.BusinessException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.lang.annotation.Annotation;
import java.util.Set;

public class ValidationCheck {

    public static <T> void validate(T dto) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<T>> validationErrors = validator.validate(dto);
        for (ConstraintViolation<T> validationError : validationErrors) {
            String fieldName = validationError.getPropertyPath().toString();
            String errorMessage = validationError.getMessage();
            Class<? extends Annotation> annotaionType = validationError.getConstraintDescriptor().getAnnotation().annotationType();

            // アノテーションに応じた処理
            if (annotaionType.equals(NotEmpty.class)) {
                throw new BusinessException(fieldName + " に値が指定されていません。");
            } else if (annotaionType.equals(Size.class)) {
                throw new BusinessException(fieldName + " の長さが不正です。");
            } else if (annotaionType.equals(Pattern.class)) {
                throw new BusinessException(fieldName + " の形式が不正です。");
            } else {
                throw new BusinessException(fieldName + " - " + errorMessage);
            }
        }
    }
}
