package com.bigfong.cloud.servicebackend.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bigfong.cloud.servicebackend.system.entity.RoleMenu;
import com.bigfong.cloud.servicebackend.system.mapper.RoleMenuMapper;
import com.bigfong.cloud.servicebackend.system.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    @Transactional
    public void deleteRoleMenusByRoleId(List<Long> keys) {
        QueryWrapper<RoleMenu> wrapper = new QueryWrapper<>();
        wrapper.in("role_id",keys);
        roleMenuMapper.delete(wrapper);
    }

    @Override
    public void deleteRoleMenusByMenuId(List<Long> ids) {
        QueryWrapper<RoleMenu> wrapper = new QueryWrapper<>();
        wrapper.in("menu_id",ids);
        roleMenuMapper.delete(wrapper);
    }
}
