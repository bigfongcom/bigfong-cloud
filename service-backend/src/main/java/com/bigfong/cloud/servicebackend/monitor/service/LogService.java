package com.bigfong.cloud.servicebackend.monitor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bigfong.cloud.servicebackend.monitor.entity.SysLog;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface LogService extends IService<SysLog> {

    List<SysLog> findByPage(SysLog log);

    void deleteLogs(List<Long> ids);

    @Async
    void saveLog(ProceedingJoinPoint proceedingJoinPoint, SysLog log) throws JsonProcessingException;
}
