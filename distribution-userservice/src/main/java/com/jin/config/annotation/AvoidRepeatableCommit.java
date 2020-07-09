package com.jin.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表单在特定时间内不能重复提交
 * @author      shuai.jin
 * @date        2020-07-02 15:32
 */

@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AvoidRepeatableCommit {

    /**
     * 表单默认十五秒之内不能重复提交
     * @return
     */
    long timeout() default 15000;
}
