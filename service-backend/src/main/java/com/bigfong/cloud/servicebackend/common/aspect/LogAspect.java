package com.bigfong.cloud.servicebackend.common.aspect;

import com.alibaba.fastjson.JSON;
import com.bigfong.cloud.servicebackend.common.exception.GlobalException;
import com.bigfong.cloud.servicebackend.common.utils.HttpContextUtil;
import com.bigfong.cloud.servicebackend.common.utils.IPUtil;
import com.bigfong.cloud.servicebackend.common.utils.ShiroUtil;
import com.bigfong.cloud.servicebackend.monitor.entity.SysLog;
import com.bigfong.cloud.servicebackend.system.entity.User;
import com.bigfong.cloud.servicebackend.monitor.service.LogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LogService logService;

    @Pointcut("@annotation(com.bigfong.cloud.servicebackend.common.annotation.Log)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws JsonProcessingException {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new GlobalException(throwable.getMessage());
        }
        //获取Request请求
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        //设置IP地址
        String ip = IPUtil.getIpAddr(request);
        //记录时间（毫秒）
        int time = (int)(System.currentTimeMillis() - beginTime);
        //保存日志
        //User user = (User) SecurityUtils.getSubject().getPrincipal();
        User user = ShiroUtil.getCurrentUser();

        SysLog log = new SysLog();
        log.setUsername(user.getUsername());
        log.setIp(ip);
        log.setTime(time);
        logService.saveLog(proceedingJoinPoint, log);
        return result;
    }
}
