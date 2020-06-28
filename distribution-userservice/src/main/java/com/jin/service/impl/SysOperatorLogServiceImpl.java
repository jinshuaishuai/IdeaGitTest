package com.jin.service.impl;

import com.jin.entity.ao.SysOperatorLogAO;
import com.jin.entity.domain.SysOperatorLogDO;
import com.jin.mapper.SysOperatorLogMapper;
import com.jin.service.SysOperatorLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author shuai.jin
 * @date 2020/6/28 18:11
 */
@Service
@Slf4j
public class SysOperatorLogServiceImpl implements SysOperatorLogService {

    @Autowired
    private SysOperatorLogMapper sysOperatorLogMapper;

    @Override
    public void addSysOperatorLog(SysOperatorLogAO sysOperatorLogAo) {
        log.info("接口请求入参为：------>{}", sysOperatorLogAo);
        SysOperatorLogDO sysOperatorLogDo = new SysOperatorLogDO();
        BeanUtils.copyProperties(sysOperatorLogAo,sysOperatorLogDo);
        sysOperatorLogMapper.addSysOperatorLog(sysOperatorLogDo);
    }

}
