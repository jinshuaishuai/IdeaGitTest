package com.jin.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author      shuai.jin
 * @date        2020-06-28 17:32
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogRecord {

    /**
     * 操作类型：添加 修改 删除 查询
     * @return
     */
    String operatorType();

    /**
     * 操作的模块
     * @return
     */
    String operatorModule();

}
