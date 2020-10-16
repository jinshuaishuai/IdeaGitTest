package com;

import ch.qos.logback.core.boolex.EvaluationException;
import com.beust.jcommander.IValueValidator;
import com.entity.domain.Person;
import com.google.gson.Gson;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.joda.time.DateTime;

import java.util.*;

/**
 * @author shuai.jin
 * @date 2020/9/22 10:31
 */
public class DataStructTest {

    public static void main(String[] args) {
        ddd();


    }

    private static void ddd() {
        double zhaoshang = 29484;

        double mingsheng = 17589;

        double zhifubao = 245.54;

        double qianfei = 282;
    }

    private static void bcd() {
        List<Map<String, Object>> maps = new ArrayList<>();
        //有多少行呢？有maps.size()行。
        //有多少列呢？maps.get(0).size()列


        Map<String, Object> map1 = new LinkedHashMap<>();
        map1.put("name", "张三");
        map1.put("age", 23);
        map1.put("id", 1);
        map1.put("phone", "15560220638");

        Map<String, Object> map2 = new LinkedHashMap<>();
        map2.put("name", "李四");
        map2.put("age", 24);
        map2.put("id", 2);
        map2.put("phone", "15560220639");

        maps.add(map1);
        maps.add(map2);

        //先取第一列的值
        List<List<Object>> colData = new ArrayList<>();

        List<String> fields = new ArrayList<>();
        fields.add("name");
        fields.add("age");
        fields.add("id");
        fields.add("phone");


        fields.forEach(field -> {
            List<Object> list = new ArrayList<>();
            maps.forEach((map) -> {
                map.forEach((key, value) -> {
                    if(field.equals(key)) {
                        list.add(value);
                    }
                });

            });
            colData.add(list);
        });


        Gson gson = new Gson();


        System.out.println(gson.toJson(colData));
    }

    private static void abcd() {
        List<Map<String, Object>> listMap = new ArrayList<>();

        //第一行数据：有三列数据
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", "1");
        map.put("name", "zhangsan");
        map.put("age", 23);

        //第二行数据：有三列数据
        Map<String, Object> map2 = new LinkedHashMap<>();
        map2.put("id", "2");
        map2.put("name", "李四");
        map2.put("age", 24);

        listMap.add(map);
        listMap.add(map2);

        List<List<String>> listList = new ArrayList<>();

        if(listMap != null && listMap.size() > 0) {
            //将key为id，name，age的分别放到不同的List中
            List<String> ids = new ArrayList<>();
            List<String> names = new ArrayList<>();
            List<String> ages = new ArrayList<>();
            for(Map<String, Object> mapp : listMap) {

                mapp.forEach((key, value) -> {
                    if("id".equals(key)) {
                        ids.add(value.toString());
                    } else if("name".equals(key)) {
                        names.add(value.toString());
                    } else if("age".equals(key)) {
                        ages.add(value.toString());
                    }
                });


            }
            listList.add(ids);
            listList.add(names);
            listList.add(ages);

        }
        System.out.println(listList);
    }

    private static void ListMap() {
        Map<String, List<Map<String,String>>> map = new HashMap<>();
        List<Map<String, String>> list = new ArrayList<>();
        Map map1 = new HashMap();
        map1.put("name", "fengqi");
        map1.put("id", "1");

        Map map2 = new HashMap();
        map2.put("name", "fengqi");
        map2.put("age", 2);

        Map<String, String> map3 = new HashMap<>();
        map3.put("name", "fengqi");
        map3.put("is_delete", "0");

        list.add(map3);
        list.add(map1);
        list.add(map2);
        map.put("fengqi", list);
        System.out.println(map);
    }

    private static void abc() {
        DateTime object = new DateTime("2020-9-25 15:54:20");
        String to = object.toString();
        System.out.println(to);
    }


    private static void listList() {
        List<List<String>> result = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("张三");
        list1.add("张四");

        List<String> list2 = new ArrayList<>();
        list2.add("李三");
        list2.add("李四");
        result.add(list1);
        result.add(list2);

        System.out.println(result);

        Gson gson = new Gson();
        String json = gson.toJson(result);
        System.out.println(json);
    }

    public static void listMap() {
        List<Map<String, Object>> listMap = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("aaa", "张三");

        map1.put("bbb", "李四");

        Map<String, Object> map2 = new HashMap<>();
        map2.put("aaa", "王五");
        map2.put("bbb", "赵六");
        listMap.add(map1);
        listMap.add(map2);

        Gson gson = new Gson();
        String json = gson.toJson(listMap);
        System.out.println(json);
    }


}
