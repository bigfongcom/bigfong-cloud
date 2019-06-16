package com.bigfong.cloud.servicebackend.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bigfong.cloud.servicebackend.system.entity.Role;
import com.bigfong.cloud.servicebackend.system.entity.RoleWithMenu;

import java.util.List;

public interface RoleService extends IService<Role> {

    List<Role> findUserRole(String username);

    List<Role> findAllRole(Role role);

    List<Role> queryList(Role role);

    RoleWithMenu findById(Long id);

    void add(RoleWithMenu role);

    boolean checkName(String name, String id);

    void update(RoleWithMenu role);

    void delete(List<Long> keys);
}
