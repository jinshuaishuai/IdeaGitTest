package com.jin.mapper;

import com.jin.entity.domain.PointDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
}
