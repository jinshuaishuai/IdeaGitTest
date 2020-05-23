package com.jin.service.impl;

import com.jin.entity.domain.UserInfoDO;
import com.jin.mapper.UserInfoMapper;
import com.jin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return userInfoMapper.getUserInfoById(id);
    }
}
