package com.pattern.bi;

/**
 * @author shuai.jin
 * @date 2020/9/11 14:08
 */
public abstract class BaseAggregation {

    /**
     * 包含多种查询条件的类
     */
    public Object object;

    public BaseAggregation(Object object) {
        this.object = object;
    }
}
