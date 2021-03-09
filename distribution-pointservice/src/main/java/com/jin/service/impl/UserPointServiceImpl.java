package com.jin.service.impl;

import com.jin.entity.ao.UserPointAo;
import com.jin.entity.domain.PointDO;
import com.jin.mapper.UserPointMapper;
import com.jin.service.UserPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shuai.jin
 * @date 2020/6/22 11:49
 */
@Service
public class UserPointServiceImpl implements UserPointService {

    @Autowired
    private UserPointMapper userPointMapper;

    @Override
    public List<PointDO> getUserPointList(int userId) {

        return userPointMapper.getUserPointList(userId);
    }

    @Override
    public void addUserPoint(UserPointAo userPointAo) {
        PointDO pointDO = PointDO.builder()
                .point(userPointAo.getPoint())
                .userId(userPointAo.getUserId())
                .build();
        userPointMapper.addPoint(pointDO);
    }
}
