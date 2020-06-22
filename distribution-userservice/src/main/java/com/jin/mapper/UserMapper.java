package com.jin.mapper;

import com.jin.entity.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author shuai.jin
 * @date 2020/6/20 7:59
 */
@Repository
@Mapper
public interface UserMapper {

    /**
     * 新增用户
     * @param userDo    用户实体
     */
    void addUser(UserDO userDo);

    /**
     * 根据用户id物理删除用户数据
     * @param userId
     */
    void deleteUserById(@Param("id") int userId);

    /**
     * 根据用户id获取用户详情
     * @param userId
     * @return
     */
    UserDO getUserById(int userId);
}
