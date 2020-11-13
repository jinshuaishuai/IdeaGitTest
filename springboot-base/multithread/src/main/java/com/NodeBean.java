package com;

import lombok.Data;

import java.util.Objects;

/**
 * @author shuai.jin
 * @date 2020/11/10 11:11
 */
@Data
public class NodeBean<K,V> {

    final int hash;

    final K key;

    V value;

    NodeBean<K, V> next;

    NodeBean(int hash, K key, V value, NodeBean next) {
        this.hash = hash;
        this.key = key;

        this.value = value;
        this.next = next;
    }

    public static void main(String[] args) {
        Object o1 = new Object();
        System.out.println(o1.hashCode());

        Object o2 = new Object();
        System.out.println(o2.hashCode());

        NodeBean<String, String> lastNode = new NodeBean<>(14, "name", "wangwu", null);
        System.out.println(lastNode.hashCode());
    }

    private static void test1() {
        NodeBean<String, String> lastNode = new NodeBean<>(14, "name", "wangwu", null);

        NodeBean<String,String> middleNode = new NodeBean<>(12, "name", "lisi", lastNode);

        NodeBean<String, String> headerNode = new NodeBean<>(10, "name", "zs", middleNode);

        System.out.println(headerNode);
    }

}
