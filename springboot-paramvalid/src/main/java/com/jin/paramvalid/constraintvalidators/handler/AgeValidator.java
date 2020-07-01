package com.jin.paramvalid.constraintvalidators.handler;

import com.jin.paramvalid.config.annotation.Age;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author shuai.jin
 * @date 2020/7/1 17:37
 */
public class AgeValidator implements ConstraintValidator<Age, Integer> {


    @Override
    public void initialize(Age constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("年龄不能为空").addConstraintViolation();
            return false;
        }

        return value >= 0 && value <= 160;
    }
}
