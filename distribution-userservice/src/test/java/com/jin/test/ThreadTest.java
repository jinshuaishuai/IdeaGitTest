package com.jin.test;

import com.google.gson.Gson;
import com.jin.entity.ao.UserAO;
import com.jin.entity.domain.PointDO;
import com.jin.entity.domain.UserDO;
import com.jin.entity.dto.UserPointDTO;
import lombok.SneakyThrows;
import net.sf.json.JSONArray;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author shuai.jin
 * @date 2020/7/13 9:04
 */
public class ThreadTest {

    /*
        该程序演示了被volatile修饰的变量具有内存可见性的特性：
        我们知道，静态变量是线程共享的，在多线程并发时，多个线程共享该变量，每个线程有单独的内存空间，该内存空间只属于该线程本身，
        每个线程取到的共享变量只是这个变量的副本
     */
    private static volatile boolean initFlag = false;

    private static volatile int count = 0;

    @Test
    public void countTest() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 50; i++) {
                    count ++;
                    System.out.println(Thread.currentThread().getName() + " " + count);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 50; i++) {
                    count ++;
                    System.out.println(Thread.currentThread().getName() + " " + count);
                }
            }
        }).start();
    }

    @Test
    public void threadTest() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("程序正在加载中。。。");

                while (!initFlag) {
                }
                System.out.println("程序加载完成！！！");
            }
        }).start();

        Thread.sleep(1000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("数据准备中");
                initFlag = true;
                System.out.println("数据准备完成");
            }
        }).start();
    }

    @Test
    public void testListCopy() {
        List<String> list = new ArrayList<>(16);

        List<String> list1 = new ArrayList<>();
        list1.add("111");

        List<String> list2 = new ArrayList<>();
        list2.add("222");

        List<String> list3 = new ArrayList<>();

       list.addAll(list1);
       list.addAll(list2);
       list.addAll(list3);
        System.out.println(list);
    }

    @Test
    public void testIntegerEquals() {
        Long i1 = 86l;
        int i2 = 86;

        System.out.println(i1.equals((long)i2));
    }

    @Test
    public void testEnum() {
        int admin = SysUserAccountTypeEnum.ADMIN.getAccountType();
        System.out.println(admin);
    }

    @Test
    public void testListFilter() {
        List<String> list1 = new ArrayList<>();
        list1.add("111");
        list1.add("222");
        list1.add("333");
        list1.add("444");

        List<String> list2 = new ArrayList<>();
        list2.add("222");
        list2.add("444");
        list2.add("555");

        //比较list2存在于list1的元素
        list2.forEach(str2 ->{
            list1.forEach(str1 ->{
                if(str1.equals(str2)) {
                    System.out.println(str1 + "   " + true);
                } else {
                    System.out.println(str1);
                }
            });
        });
    }

    @Test
    public void testUser() {
        UserAO userAO = new UserAO();
        userAO.setAge(23);
        userAO.setName("张三");
        userAO.setPhone("15560220637");

        List<UserAO> list1 = new ArrayList<>();
        list1.add(userAO);
        boolean contains = list1.contains(userAO);

        UserAO user2 = new UserAO();

        boolean contains1 = list1.contains(user2);
        System.out.println(contains1);

        System.out.println(contains);
    }

    @Test
    public void testStringFormat() {
        System.out.println(String.format("%d %s", "test".length(), "test"));
    }

    @Test
    public void testGson() {
        Gson gson = new Gson();

        UserPointDTO userPointDTO = new UserPointDTO();
        UserDO userDO = new UserDO();
        userDO.setAge(23);
        userDO.setId(1);
        userDO.setName("张三");
        userDO.setPhone("15560220637");

        List<PointDO> list = new ArrayList<>();

        PointDO pointDO = new PointDO();
        pointDO.setPoint(new BigDecimal(99));
        pointDO.setUserId(12);
        list.add(pointDO);

        userPointDTO.setPointDoList(list);

        userPointDTO.setUserDo(userDO);

        System.out.println();
        String s = gson.toJson(userPointDTO);
        UserPointDTO userPointDTO1 = gson.fromJson(s, UserPointDTO.class);
        System.out.println(userPointDTO1);
    }


}

