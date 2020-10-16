package com.jin.mapper;

import com.jin.entity.domain.UserInfoDO;
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

    UserInfoDO getUserInfoById(@Param("id") int id);

    List<Map<String, Object>> getDynamicQueryResult();
}
