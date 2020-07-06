package com.jin.config.aspect;

import com.google.gson.Gson;
import com.jin.common.config.RestResponse;
import com.jin.config.annotation.AvoidRepeatableCommit;
import com.jin.config.redis.JedisCacheUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * @author shuai.jin
 * @date 2020/7/2 15:35
 */

@Component
@Slf4j
@Aspect
public class AvoidRepeatableCommitAspect {

    @Autowired
    private JedisCacheUtil jedisCacheUtil;

    @Pointcut(value = "@annotation(com.jin.config.annotation.AvoidRepeatableCommit)")
    public void pointcut() {

    }

    @Before(value = "pointcut()")
    public void before(JoinPoint joinPoint) {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String remoteHost = request.getRemoteHost();

        HttpServletResponse response = servletRequestAttributes.getResponse();

        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        //调用的方法名称
        String name = method.getName();
        String redisKey = String.format("%s#%s", remoteHost, name);

        String redisValue = jedisCacheUtil.get(redisKey, 6);
        if(StringUtils.isEmpty(redisValue)) {
            //如果缓存中不存在
            //将该key设置到缓存中，设置缓存时间为30s，
            jedisCacheUtil.set(redisKey,String.valueOf(System.currentTimeMillis()), "ex", 30, 6);
        } else {
            //缓存中存在，封装不能重复提交异常信息，返回给前端，还要重新HttpServletResponse接口类

            RestResponse<String> restResponse = new RestResponse<>();
            restResponse.setCode("500");
            restResponse.setMessage("15 seconds can't commit again!");
            returnResult(response, restResponse);
        }

    }

    private void returnResult(HttpServletResponse response, RestResponse restResponse) {

        Gson gson = new Gson();
        String jsonResult = gson.toJson(restResponse);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        try (PrintWriter writer = response.getWriter()) {
            writer.print(jsonResult);
        } catch (IOException e) {
            log.error("response error", e);
        }
    }
}
