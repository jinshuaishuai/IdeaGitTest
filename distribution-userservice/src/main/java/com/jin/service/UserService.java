package com.jin.service;

import com.jin.entity.ao.UserAO;

/**
 * @author shuai.jin
 * @date 2020/6/20 7:57
 */
public interface UserService {

    /**
     * 新增用户
     * @param userAo    用户对象
     */
    public void addUser(UserAO userAo);
}
