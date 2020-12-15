package com.jin.mapper;

import com.jin.entity.domain.UserInfoDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/15 14:25
 */
@Repository
@Mapper
public interface UserInfoMapper {

    UserInfoDo getUserInfoById(@Param("id") int id);

    List<Map<String, Object>> getDynamicQueryResult();

    void save(UserInfoDo infoDO);

    void update(UserInfoDo infoDO);

    void delete(UserInfoDo infoDO);

    /**
     * 批量插入
     * @param targetUserInfoList
     */
    void addBatch(List<UserInfoDo> targetUserInfoList);
}
