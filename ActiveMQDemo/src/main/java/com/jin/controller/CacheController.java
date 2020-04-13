package com.jin.controller;

import com.jin.cache.MyHashMapCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author shuai.jin
 * @Description 自定义缓存验证
 * @Date 2020/4/11 12:47
 */
@RestController
public class CacheController {

    @Autowired
    private MyHashMapCache myHashMapCache;

    @GetMapping(value = "/getValue")
    public Object getValue(@RequestParam String args) {
        Object value = myHashMapCache.get(args);

        if(value == null) {
            //缓存中没有该数据
            value = "第一次访问从数据源中取";           //从数据源中取
            myHashMapCache.set(args, "靳帅");
        }
        return value;
    }
}
