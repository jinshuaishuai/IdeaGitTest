package com.jin.service;

import com.jin.entity.domain.PointDO;

import java.util.List;

/**
 * @author shuai.jin
 * @date 2020/6/22 11:49
 */
public interface UserPointService {

    /**
     * 根据用户id获取用户的积分数据列表
     * @param userId
     * @return
     */
    List<PointDO> getUserPointList(int userId);


}
