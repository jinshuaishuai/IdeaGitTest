package com.jin.quartz.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jin.quartz.entity.Person;
import com.jin.quartz.task.HelloTask;
import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.util.StringUtils;

import java.lang.reflect.Type;
import java.util.*;
import java.util.regex.Pattern;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

/**
 * @author shuai.jin
 * @date 2020/8/18 17:55
 */
public class QuartzTest1 {


    @Test
    public void testQuartz() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // and start it off
        scheduler.start();
        JobKey jobKey = new JobKey("test1", "group1");
        JobDetail jobDetail = newJob(HelloTask.class).withIdentity(jobKey).build();

        scheduler.shutdown();
    }

    @Test
    public void testLong() {

        /*String regex = "\\s+[w|W]{1}[h|H]{1}[e|E]{1}[r|R]{1}[e|E]{1}\\s+";
        boolean where = Pattern.matches(regex, "select * from user where id > 10");
        System.out.println(where);*/

        String sql = "select * from user \twhere id > 10";
        String upperCase = sql.toUpperCase();
        if (upperCase.contains("WHERE")) {
            int where = upperCase.indexOf("WHERE");
            System.out.println(where);
            System.out.println("哈哈" + upperCase.charAt(where - 1) + "呵呵");
            char c = upperCase.charAt(where - 1);
            if (c == 32 || c == 10 || c == 9) {
                System.out.println("是空格");
            }
        }
    }

    @Test
    public void testListMap() {
        List<Map<String, Object>> mapList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 23);
        mapList.add(map);

        for (Map<String, Object> val : mapList) {
            Set<String> keySet = val.keySet();
            for (String str : keySet) {
                Object o = val.get(str);
                System.out.println(o);
            }

        }

    }

    @Test
    public void testReturn() {
        for(int i = 0 ;i < 10; i++) {
            if(i == 3) {
                continue;
            }
            System.out.println(i);
        }
    }

    @Test
    public void testJsonMap() {
        Map<String, Person> map = new HashMap<>();
        Person p1 = Person.builder().name("张三").age(23).build();
        Person p2 = Person.builder().name("李四").age(24).build();

        map.put("zs", p1);
        map.put("ls", p2);

        Gson gson = new Gson();
        String json = gson.toJson(map);
        System.out.println(json);

        Type type = new TypeToken<Map<String, Person>>(){}.getType();

        Object o = gson.fromJson(json, type);
        System.out.println(o);

    }
}
