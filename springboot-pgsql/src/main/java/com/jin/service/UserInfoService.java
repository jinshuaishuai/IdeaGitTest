package com.jin.service;

import com.jin.entity.ao.UserAo;
import com.jin.entity.domain.UserInfoDo;

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
    UserInfoDo getUserInfoById(int id);

    List<Map<String, Object>> getDynamicQueryResult();

    /**
     * 新增
     * @param userAo
     */
    void save(UserAo userAo);

    /**
     * 更新
     * @param userAo
     */
    void update(UserAo userAo);

    /**
     * 删除
     * @param userAo
     */
    void delete(UserAo userAo);

    void addBatch(List<UserAo> userAoList);

    /**
     * 条件查询用户列表
     * @param userInfoDo
     * @return
     */
    List<UserInfoDo> getUserListByParam(UserInfoDo userInfoDo);
}
