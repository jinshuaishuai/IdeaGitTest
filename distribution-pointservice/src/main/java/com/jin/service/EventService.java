package com.jin.service;

import com.jin.entity.domain.EventDO;
import com.jin.entity.query.EventQuery;

import java.util.List;

/**
 * @author shuai.jin
 * @date 2020/6/21 19:20
 */
public interface EventService {


    List<EventDO> getEventListByParams(EventQuery eventQuery);
}
