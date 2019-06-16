package com.bigfong.cloud.servicebackend.monitor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bigfong.cloud.servicebackend.monitor.entity.LoginLog;

import java.util.List;

public interface LoginLogService extends IService<LoginLog> {

    List<LoginLog> findByPage(LoginLog log);

    void delete(List<Long> ids);

    void saveLog(LoginLog log);
}
