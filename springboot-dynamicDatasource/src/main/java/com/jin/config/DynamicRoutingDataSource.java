package com.jin.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/19 14:48
 */
@Slf4j
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    String dataSourceName = DynamicDataSourceContextHolder.getDataSourceRouterKey();

    @Override
    protected Object determineCurrentLookupKey() {
        log.info("当前数据源是：{}", dataSourceName);
        return DynamicDataSourceContextHolder.getDataSourceRouterKey();
    }
}