package com.jin.mapper;

import com.jin.entity.domain.UserInfoDO;
import org.springframework.stereotype.Repository;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/15 14:25
 */
@Repository
public interface UserInfoMapper {

    UserInfoDO getUserInfoById(int id);
}
