package com.jin.service;

import com.jin.entity.ao.UserAO;
import com.jin.entity.domain.UserDO;
import org.apache.ibatis.annotations.Param;

import java.security.NoSuchAlgorithmException;

/**
 * @author shuai.jin
 * @date 2020/6/20 7:57
 */
public interface UserService {

    /**
     * 新增用户
     * @param userAo    用户对象
     */
    public void addUser(UserAO userAo) throws NoSuchAlgorithmException;

    /**
     * 根据用户id获取用户详情
     * @param userId
     * @return
     */
    UserDO getUserById(@Param("id") int userId);

    /**
     *
     * @param userAo
     */
    void addUserByRemoteCall(UserAO userAo);
}
