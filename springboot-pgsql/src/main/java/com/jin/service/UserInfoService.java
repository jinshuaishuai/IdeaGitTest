package com.jin.service;

import com.jin.entity.domain.UserInfoDO;

import java.util.List;
import java.util.Map;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/15 14:19
 */
public interface UserInfoService {

    /**
     * 根据id创建一条记录
     * @param id
     * @return
     */
    UserInfoDO getUserInfoById(int id);

    List<Map<String, Object>> getDynamicQueryResult();
}
