package com.jin.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/19 15:40
 */
@Component
@Aspect
@Slf4j
public class DynamicDataSourceAspect {

    @Pointcut(value = "@annotation(com.jin.config.DatasourceAnno)")
    public void pointcut() {

    }

    //当环绕通知执行成功后，前置通知才会执行

    @Before(value = "pointcut()")
    public void changeDataSource(JoinPoint point) throws Throwable {
        String dsId = "first";
        if (DynamicDataSourceContextHolder.dataSourceIds.contains(dsId)) {
            log.debug("Use DataSource :{} >", dsId, point.getSignature());
        } else {
            log.info("数据源[{}]不存在，使用默认数据源 >{}", dsId, point.getSignature());
            DynamicDataSourceContextHolder.setDataSourceRouterKey(dsId);
        }
    }

}
