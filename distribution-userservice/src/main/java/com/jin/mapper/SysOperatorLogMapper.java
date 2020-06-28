package com.jin.mapper;

import com.jin.entity.domain.SysOperatorLogDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author shuai.jin
 * @date 2020/6/28 18:35
 */
@Repository
@Mapper
public interface SysOperatorLogMapper {

    void addSysOperatorLog(SysOperatorLogDO sysOperatorLogDo);
}
