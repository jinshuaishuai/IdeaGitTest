package com.jin.service;

import com.jin.entity.ao.SysOperatorLogAO;

/**
 * @author shuai.jin
 * @date 2020/6/28 18:11
 */
public interface SysOperatorLogService {

    /**
     * 添加操作系统操作日志
     * @param sysOperatorLogAo
     */
    void addSysOperatorLog(SysOperatorLogAO sysOperatorLogAo);
}
