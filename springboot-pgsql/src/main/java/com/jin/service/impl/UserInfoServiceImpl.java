package com.jin.service.impl;

import com.jin.entity.ao.UserAo;
import com.jin.entity.domain.UserInfoDo;
import com.jin.mapper.UserInfoMapper;
import com.jin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.*;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/15 14:20
 */

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfoDo getUserInfoById(int id) {
        UserInfoDo infoDo = userInfoMapper.getUserInfoById(id);

        return infoDo;
    }

    @Override
    public List<Map<String, Object>> getDynamicQueryResult() {

        List<Map<String, Object>> result = userInfoMapper.getDynamicQueryResult();
        System.out.println(result);
        return result;
    }

    @Override
    public void save(UserAo userAo) {
        UserInfoDo infoDO = UserInfoDo.builder()
                .name(userAo.getName())
                .phone(userAo.getPhone())
                .age(userAo.getAge())
                .build();
        userInfoMapper.save(infoDO);

    }

    @Override
    public void update(UserAo userAo) {
        UserInfoDo infoDO = UserInfoDo.builder()
                .name(userAo.getName())
                .phone(userAo.getPhone())
                .age(userAo.getAge())
                .build();
        userInfoMapper.update(infoDO);
    }

    @Override
    public void delete(UserAo userAo) {
        UserInfoDo infoDO = UserInfoDo.builder()
                .name(userAo.getName())
                .phone(userAo.getPhone())
                .age(userAo.getAge())
                .build();
        userInfoMapper.delete(infoDO);
    }

    @Override
    public void addBatch(List<UserAo> userAoList) {
        List<UserInfoDo> targetUserInfoList = new ArrayList<>();
        if(userAoList != null && userAoList.size() > 0) {
            userAoList.forEach(
                    userAo -> {
                        UserInfoDo infoDO = UserInfoDo.builder()
                                .name(userAo.getName())
                                .phone(userAo.getPhone())
                                .age(userAo.getAge())
                                .build();
                        targetUserInfoList.add(infoDO);
                    }
            );

        }
        userInfoMapper.addBatch(targetUserInfoList);
    }
}
