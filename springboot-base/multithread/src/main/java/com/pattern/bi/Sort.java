package com.pattern.bi;

import javax.naming.spi.ObjectFactory;

/**
 * @author shuai.jin
 * @date 2020/9/11 14:01
 */
public class Sort extends BaseAggregation{
    public Sort(Object object) {
        super(object);
    }

    private Object ascSort(Object object) {
        //进行升序排
        System.out.println("升序排序");
        System.out.println("将排序结果返回");
        return null;
    }

    private Object descSort(Object object) {

        System.out.println("降序排序");
        System.out.println("将排序结果返回");
        System.out.println("不见了远处的青山");
        System.out.println("今天主要的任务是静下心来，整理HashMap的源码");

        System.out.println("hello,world");

        return null;
    }

    private Object customiseSord(Object object) {
        //Object里包含有多类查询条件，每次对查询条件进行过滤。进行分类处理
        System.out.println("自定义排序");
        System.out.println("将自定义排序结果返回");
        return null;
    }
}
