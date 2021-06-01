package com.example;


import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * @author shuai.jin
 * @date 2020/9/7 9:23
 */
public class Main {

    private AtomicInteger i = new AtomicInteger();

    private AtomicLong l = new AtomicLong();

    public void aaa() {
        i.incrementAndGet();
    }


    public static void main(String[] args) {
       String str = " and id in('abc','bcd')";
        System.out.println(str.substring(4));
    }

    private static void method3() {

        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> stu1 = new HashMap<String, Object>();
        stu1.put("name", "卫庄");
        stu1.put("score", new BigDecimal(80));
        list.add(stu1);
        Map<String,Object> stu2 = new HashMap<String, Object>();
        stu2.put("name", "盖聂");
        stu2.put("score", new BigDecimal(90));
        list.add(stu2);
        Map<String,Object> stu3 = new HashMap<String, Object>();
        stu3.put("name", "天明");
        stu3.put("score", new BigDecimal(60));
        list.add(stu3);
        Map<String,Object> stu4 = new HashMap<String, Object>();
        stu4.put("name", "卫庄");
        stu4.put("score", new BigDecimal(30));
        list.add(stu4);
        list = list.stream().collect(Collectors.groupingBy(d -> d.get("name")))
                .values().stream().map(d -> {
            Map<String, Object> sampleData = d.get(0);
            sampleData.put("score", d.stream().map(s -> new BigDecimal(s.get("score").toString())).reduce(BigDecimal.ZERO, BigDecimal::add));
            return sampleData;
        }).collect(Collectors.toList());
        System.out.println(list);
    }

    private static void filter() {
        List<String> list = Arrays.asList("张三", "23");
        List<String> collect = list.stream()
                .filter(str -> str.equals("张三") && str.startsWith("张"))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void method2() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
// 获取对应的平方数
//        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());

        //计数
        long count1 = numbers.stream().count();
        System.out.println(count1);

        //去重计数
        long count = numbers.stream().distinct().count();

        System.out.println(count);
    }

    private static void method1() {
        List<Map<String, Object>> listMap = new ArrayList<>();

        Map<String, Object> map1 = new LinkedHashMap<>();
        map1.put("name", "张三");
        map1.put("age", 23);
        map1.put("phone", "789");

        Map<String, Object> map2 = new LinkedHashMap<>();
        map2.put("name", "李四");
        map2.put("age", 24);
        map2.put("phone", "456");

        Map<String, Object> map3 = new LinkedHashMap<>();
        map3.put("name", "张三");
        map3.put("age", 25);
        map3.put("phone", "123");

        listMap.add(map1);
        listMap.add(map2);
        listMap.add(map3);

        List<String> list1 = new ArrayList<>();
        list1.add("张三");

        List<String> list2 = new ArrayList<>();
        list2.add("李四");

        List<String> list = Arrays.asList("张三", "李四");

        List<Map<String, Object>> collect = listMap.stream().collect(Collectors.groupingBy(group -> fetchGroupBy(list))).values()
                .stream().map(d -> {
                    Map<String, Object> sampleData = d.get(0);
                    sampleData.put("age", d.stream().map(s -> new BigDecimal(s.get("age").toString())).reduce(BigDecimal.ZERO, BigDecimal::add));
                    return sampleData;
                }).collect(Collectors.toList());


        /*List<Map<String, Object>> collect = listMap.stream().collect(Collectors.groupingBy(name -> name.get("name")))
                .values()
                .stream().map(d -> {
                    Map<String, Object> sampleData = d.get(0);
                    sampleData.put("age", d.stream().map(s -> new BigDecimal(s.get("age").toString())).reduce(BigDecimal.ZERO, BigDecimal::add));
                    return sampleData;
                }).collect(Collectors.toList());*/
        System.out.println(collect);
    }

    private static Object fetchGroupBy(List<String> list) {
        return list.get(0) + list.get(1);
    }

}
