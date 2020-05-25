package com.jin.cache;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author shuai.jin
 * @Description TODO
 * @Date 2020/4/11 12:44
 */
@Component
public class MyHashMapCache<K,V> {
    private Map<K, V> cache = new HashMap<>();

    public void set(K k, V v) {
        cache.put(k,v);
    }

    public V get(K k) {
        return cache.get(k);
    }
}
