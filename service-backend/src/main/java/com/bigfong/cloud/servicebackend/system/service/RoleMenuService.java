package com.bigfong.cloud.servicebackend.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bigfong.cloud.servicebackend.system.entity.RoleMenu;

import java.util.List;

public interface RoleMenuService extends IService<RoleMenu> {

    void deleteRoleMenusByRoleId(List<Long> keys);

    void deleteRoleMenusByMenuId(List<Long> ids);
}
