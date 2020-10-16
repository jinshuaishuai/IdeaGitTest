package com.jin.service.impl;

import com.jin.entity.domain.UserInfoDO;
import com.jin.mapper.UserInfoMapper;
import com.jin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
    public UserInfoDO getUserInfoById(int id) {
        UserInfoDO infoDo = userInfoMapper.getUserInfoById(id);

        return infoDo;
    }

    @Override
    public List<Map<String, Object>> getDynamicQueryResult() {

        List<Map<String, Object>> result = userInfoMapper.getDynamicQueryResult();
        System.out.println(result);
        return result;
    }
}
