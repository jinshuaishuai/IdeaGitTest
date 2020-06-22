package com.jin.mapper;

import com.jin.entity.domain.PointDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shuai.jin
 * @date 2020/6/21 19:47
 */
@Mapper
@Repository
public interface UserPointMapper {

    /**
     * 添加用户的积分记录
     * @param pointDo
     */
    void addPoint(PointDO pointDo);

    /**
     * 获取用户积分列表
     * @param userId
     * @return
     */
    List<PointDO> getUserPointList(int userId);
}
