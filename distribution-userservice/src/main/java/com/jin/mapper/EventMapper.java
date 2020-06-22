package com.jin.mapper;

import com.jin.entity.domain.EventDO;
import com.jin.entity.query.EventQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shuai.jin
 * @date 2020/6/20 18:15
 */
@Mapper
@Repository
public interface EventMapper {

    /**
     * 添加时间
     * @param eventDo
     */
    void addEvent(EventDO eventDo);

    /**
     * 条件查询事件列表
     * @param eventQuery
     * @return
     */
    List<EventDO> getEventListByParams(EventQuery eventQuery);

    /**
     * 更新记录
     * @param eventDo
     */
    void updateEvent(EventDO eventDo);
}
