package com.jin.config.aspect;

import com.jin.config.annotation.LogRecord;
import com.jin.entity.ao.SysOperatorLogAO;
import com.jin.service.SysOperatorLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 定义一个切面
 * @author shuai.jin
 * @date 2020/6/28 17:36
 */
@Component
@Aspect
public class LogRecordAspect {

    @Autowired
    private SysOperatorLogService sysOperatorLogService;

    @Pointcut(value = "@annotation(com.jin.config.annotation.LogRecord)")
    private void pointcut() {

    }

    @AfterReturning(pointcut = "pointcut()")
    public void doAfter(JoinPoint joinPoint) {
        //用于获取HttpServletRequest对象，获取客户端请求中的token
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes)requestAttributes;
        HttpServletRequest request = sra.getRequest();
        String token = request.getHeader("token");
        //TODO 从token中获取用户的信息
        Signature signature = joinPoint.getSignature();

        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        LogRecord logRecord = method.getAnnotation(LogRecord.class);

        String operatorModule = logRecord.operatorModule();
        String operatorType = logRecord.operatorType();
        SysOperatorLogAO sysOperatorLogAo = new SysOperatorLogAO();
        sysOperatorLogAo.setOperatorIp(request.getRemoteAddr());
        sysOperatorLogAo.setOperatorModule(operatorModule);
        sysOperatorLogAo.setOperatorName("admin");
        sysOperatorLogAo.setOperatorTime(new Date());
        sysOperatorLogAo.setOperatorType(operatorType);
        sysOperatorLogAo.setOperatorUri(request.getRequestURI());
        sysOperatorLogService.addSysOperatorLog(sysOperatorLogAo);

    }
}
