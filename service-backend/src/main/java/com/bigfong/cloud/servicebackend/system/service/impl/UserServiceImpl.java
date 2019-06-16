package com.bigfong.cloud.servicebackend.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bigfong.cloud.servicebackend.common.dto.Tree;
import com.bigfong.cloud.servicebackend.common.utils.PasswordHelper;
import com.bigfong.cloud.servicebackend.common.utils.ShiroUtil;
import com.bigfong.cloud.servicebackend.common.utils.TreeUtils;
import com.bigfong.cloud.servicebackend.system.entity.Menu;
import com.bigfong.cloud.servicebackend.system.entity.User;
import com.bigfong.cloud.servicebackend.system.entity.UserRole;
import com.bigfong.cloud.servicebackend.system.entity.UserWithRole;
import com.bigfong.cloud.servicebackend.system.mapper.MenuMapper;
import com.bigfong.cloud.servicebackend.system.mapper.UserMapper;
import com.bigfong.cloud.servicebackend.system.mapper.UserRoleMapper;
import com.bigfong.cloud.servicebackend.system.service.UserRoleService;
import com.bigfong.cloud.servicebackend.system.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private PasswordHelper passwordHelper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public User findByName(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        List<User> list = userMapper.selectList(wrapper);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public UserWithRole findById(Long id) {
        List<UserWithRole> list = userMapper.findById(id);
        if (list.isEmpty()) {
            return null;
        }
        List<Integer> roleIds = list.stream().map(UserWithRole::getRoleId).collect(Collectors.toList());
        UserWithRole userWithRole = list.get(0);
        userWithRole.setRoleIds(roleIds);
        return userWithRole;
    }

    @Override
    public List<Tree<Menu>> getMenus(String username) {

        //获取用户资源列表和角色列表
        List<Menu> menus = menuMapper.findUserMenus(username);

        List<Tree<Menu>> treeList = new ArrayList<>();
        menus.forEach(menu -> {
            Tree<Menu> tree = new Tree<>();
            tree.setId(menu.getId());
            tree.setParentId(menu.getParentId());
            tree.setName(menu.getName());
            tree.setUrl(menu.getUrl());
            tree.setIcon(menu.getIcon());
            treeList.add(tree);
        });

        return TreeUtils.build(treeList);
    }

    @Override
    public List<User> queryList(User user) {
        try {
            return userMapper.queryList(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    @Transactional
    public void add(UserWithRole user) {
        user.setCreateTime(new Date());
        passwordHelper.encryptPassword(user);
        this.save(user);
        saveUserRole(user);
    }

    @Override
    public boolean checkName(String name, String id) {
        if (name.isEmpty()) {
            return false;
        }
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("lower(username)", name.toLowerCase());
        if (!id.isEmpty()) {
            wrapper.ne("id",id);
        }
        List<User> users = userMapper.selectList(wrapper);
        if (users.size() > 0) {
            return false;
        }
        return true;
    }

    @Transactional
    private void saveUserRole(UserWithRole user) {
        user.getRoleIds().forEach(roleId -> {
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getId());
            userRole.setRoleId(roleId);
            userRoleMapper.insert(userRole);
        });
    }

    @Override
    @Transactional
    public void update(UserWithRole user) {
        user.setPassword(null);
        user.setModifyTime(new Date());
        userMapper.updateById((User)user);

        QueryWrapper<UserRole> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", user.getId());
        userRoleMapper.delete(wrapper);
        saveUserRole(user);
    }

    @Override
    @Transactional
    public void delete(List<Long> keys) {
        userMapper.deleteBatchIds(keys);
        userRoleService.deleteUserRolesByUserId(keys);
    }

    @Override
    @Transactional
    public void updatePassword(String password) {
        //User user = (User) SecurityUtils.getSubject().getPrincipal();
        User user = ShiroUtil.getCurrentUser();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        user.setPassword(password);
        passwordHelper.encryptPassword(user);
        userMapper.update(user, wrapper);
    }


}
