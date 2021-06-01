package com.jin.schedule;

import com.jin.entity.domain.UserInfoDo;
import com.jin.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author shuai.jin
 * @date 2021/4/8 13:59
 */
//@Component
public class UserInfoIncrementTask {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Scheduled(cron = "0/1 * * * * *")
    public void insert() {
        long startTime = System.currentTimeMillis();
        List<UserInfoDo> userInfoDoList = new ArrayList<>();
        for(int i = 0; i < 5000; i++) {

            UserInfoDo infoDo = UserInfoDo.builder()
                    .age(new Random().nextInt(100))
                    .phone(UUID.randomUUID().toString())
                    .name(UUID.randomUUID().toString())
                    .build();
            userInfoDoList.add(infoDo);

        }
        userInfoMapper.addBatch(userInfoDoList);

        long endTime = System.currentTimeMillis();
        System.out.println("耗时" + (endTime - startTime) + "毫秒");
    }
}
