package com.bigfong.cloud.servicebackend.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bigfong.cloud.servicebackend.system.entity.UserRole;

import java.util.List;

public interface UserRoleService extends IService<UserRole> {

    void deleteUserRolesByUserId(List<Long> keys);

    void deleteUserRolesByRoleId(List<Long> keys);
}
