package com.jin.paramvalid.config.annotation;

import com.jin.paramvalid.constraintvalidators.handler.AgeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author      shuai.jin
 * @date        2020-07-01 17:25
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {

    int value() default 0;

    String message() default "年龄不能为空";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
