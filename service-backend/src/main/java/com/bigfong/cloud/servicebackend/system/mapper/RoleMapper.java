package com.bigfong.cloud.servicebackend.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bigfong.cloud.servicebackend.system.entity.Role;
import com.bigfong.cloud.servicebackend.system.entity.RoleWithMenu;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {

    List<Role> findUserRole(String username);

    List<RoleWithMenu> findById(Long id);
}
