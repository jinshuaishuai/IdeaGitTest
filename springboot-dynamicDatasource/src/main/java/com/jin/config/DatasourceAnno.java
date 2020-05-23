package com.jin.config;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DatasourceAnno {
    String value() default "first";
}
