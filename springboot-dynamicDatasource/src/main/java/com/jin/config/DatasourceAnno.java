package com.jin.config;

import java.lang.annotation.*;

/**
 * @author shuai.jin
 */
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DatasourceAnno {
    String value() default "first";
}
