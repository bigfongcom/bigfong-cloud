package com.bigfong.cloud.servicebackend.monitor.service;

import com.bigfong.cloud.servicebackend.monitor.entity.OnlineUser;

import java.util.List;

public interface SessionService {

    List<OnlineUser> list();

    void forceLogout(String id);
}
