package com.bigfong.cloud.servicebackend.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bigfong.cloud.servicebackend.system.entity.Role;
import com.bigfong.cloud.servicebackend.system.entity.RoleMenu;
import com.bigfong.cloud.servicebackend.system.entity.RoleWithMenu;
import com.bigfong.cloud.servicebackend.system.mapper.RoleMapper;
import com.bigfong.cloud.servicebackend.system.mapper.RoleMenuMapper;
import com.bigfong.cloud.servicebackend.system.service.RoleMenuService;
import com.bigfong.cloud.servicebackend.system.service.RoleService;
import com.bigfong.cloud.servicebackend.system.service.UserRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Autowired
    private RoleMenuService roleMenuService;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public List<Role> findUserRole(String username) {
        return roleMapper.findUserRole(username);
    }

    @Override
    public List<Role> findAllRole(Role role) {
        return null;
    }

    @Override
    public List<Role> queryList(Role role) {
        try {
            QueryWrapper<Role> wrapper = new QueryWrapper<>();
            if (StringUtils.isNotBlank(role.getName())) {
                wrapper.eq("name", role.getName());
            }
            wrapper.orderByDesc("create_time");
            return roleMapper.selectList(wrapper);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public RoleWithMenu findById(Long id) {
        List<RoleWithMenu> list = roleMapper.findById(id);
        List<Integer> menuIds = list.stream().map(RoleWithMenu::getMenuId).collect(Collectors.toList());
        if (list.isEmpty()) {
            return null;
        }
        RoleWithMenu roleWithMenu = list.get(0);
        roleWithMenu.setMenuIds(menuIds);
        return roleWithMenu;
    }

    @Override
    @Transactional
    public void add(RoleWithMenu role) {
        role.setCreateTime(new Date());
        this.save(role);
        saveRoleMenu(role);
    }

    @Override
    public boolean checkName(String name, String id) {
        if (name.isEmpty()) {
            return false;
        }
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.eq("lower(name)", name.toLowerCase());

        if (!id.isEmpty()) {
            wrapper.ne("id", id);
        }

        List<Role> roles = roleMapper.selectList(wrapper);
        if (roles.size() > 0) {
            return false;
        }
        return true;
    }

    private void saveRoleMenu(RoleWithMenu role) {
        role.getMenuIds().forEach(menuId -> {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setMenuId(menuId);
            roleMenu.setRoleId(role.getId());
            roleMenuMapper.insert(roleMenu);
        });
    }

    @Override
    @Transactional
    public void update(RoleWithMenu role) {
        roleMapper.updateById((Role)role);
        QueryWrapper<RoleMenu> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id", role.getId());
        roleMenuMapper.delete(wrapper);
        this.saveRoleMenu(role);
    }

    @Override
    public void delete(List<Long> keys) {
        roleMapper.deleteBatchIds(keys);
        roleMenuService.deleteRoleMenusByRoleId(keys);
        userRoleService.deleteUserRolesByRoleId(keys);
    }
}
