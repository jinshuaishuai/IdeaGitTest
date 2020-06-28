package com.jin.service.impl;

import com.jin.entity.domain.EventDO;
import com.jin.entity.query.EventQuery;
import com.jin.mapper.EventMapper;
import com.jin.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shuai.jin
 * @date 2020/6/21 19:21
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventMapper eventMapper;

    @Override
    public List<EventDO> getEventListByParams(EventQuery eventQuery) {
        return eventMapper.getEventListByParams(eventQuery);
    }
}
