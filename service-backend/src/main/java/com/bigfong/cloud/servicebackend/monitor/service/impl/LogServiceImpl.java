package com.bigfong.cloud.servicebackend.monitor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bigfong.cloud.servicebackend.common.annotation.Log;
import com.bigfong.cloud.servicebackend.common.utils.AddressUtil;
import com.bigfong.cloud.servicebackend.monitor.entity.SysLog;
import com.bigfong.cloud.servicebackend.monitor.mapper.LogMapper;
import com.bigfong.cloud.servicebackend.monitor.service.LogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.*;

@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, SysLog> implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public List<SysLog> findByPage(SysLog log) {
        try {
            QueryWrapper<SysLog> wrapper = new QueryWrapper();

            if (StringUtils.isNotBlank(log.getUsername())) {
                wrapper.eq("username", log.getUsername().toLowerCase());
            }
            if (StringUtils.isNotBlank(log.getOperation())) {
                wrapper.like("operation",  log.getOperation());
            }
            if (StringUtils.isNotBlank(log.getLocation())) {
                wrapper.eq("location", log.getLocation());
            }
            if (StringUtils.isNotBlank(log.getTimeField())) {
                String[] split = log.getTimeField().split(",");
                wrapper.ge("date_format(CREATE_TIME, '%Y-%m-%d')", split[0]);
                wrapper.le("date_format(CREATE_TIME, '%Y-%m-%d')", split[1]);
            }
            wrapper.orderByDesc("create_time");
            return logMapper.selectList(wrapper);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void deleteLogs(List<Long> ids) {
        logMapper.deleteBatchIds(ids);
    }

    @Override
    public void saveLog(ProceedingJoinPoint proceedingJoinPoint, SysLog log) throws JsonProcessingException {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        Log annotation = method.getAnnotation(Log.class);
        if (annotation != null) {
            //注解上的描述
            log.setOperation(annotation.value());
        }
        //请求的类名
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        //请求方法名
        String methodName = signature.getName();
        log.setMethod(className + "." + methodName + "()");
        //请求的方法参数
        Object[] args = proceedingJoinPoint.getArgs();
        //请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer d = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = d.getParameterNames(method);
        if (args != null && parameterNames != null) {
            StringBuilder params = new StringBuilder();
            params = handleParams(params, args, Arrays.asList(parameterNames));
            log.setParams(params.toString());
        }
        log.setCreateTime(new Date());
        log.setLocation(AddressUtil.getAddress(log.getIp()));
        this.save(log);
    }

    private StringBuilder handleParams(StringBuilder params, Object[] args, List<String> paramNames) throws JsonProcessingException {
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Map) {
                Set set = ((Map) args[i]).keySet();
                List list = new ArrayList();
                List paramList = new ArrayList();
                for (Object key : set) {
                    list.add(((Map) args[i]).get(key));
                    paramList.add(key);
                }
                return handleParams(params, list.toArray(), paramList);
            } else {
                if (args[i] instanceof Serializable) {
                    Class<?> clazz = args[i].getClass();
                    try {
                        clazz.getDeclaredMethod("toString", new Class[]{null});
                        //如果不抛出NoSuchMethodException异常，则存在ToString方法
                        //params.append(" ").append(paramNames.get(i)).append(objectMapper.writeValueAsString(args[i]));
                    } catch (NoSuchMethodException e) {
                        //params.append(" ").append(paramNames.get(i)).append(objectMapper.writeValueAsString(args[i].toString()));
                    }
                } else if (args[i] instanceof MultipartFile) {
                    MultipartFile file = (MultipartFile) args[i];
                    params.append(" ").append(paramNames.get(i)).append(": ").append(file.getName());
                } else {
                    params.append(" ").append(paramNames.get(i)).append(": ").append(args[i]);
                }
            }
        }
        return params;
    }
}
