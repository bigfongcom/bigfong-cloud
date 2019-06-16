package com.bigfong.cloud.servicebackend.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bigfong.cloud.servicebackend.system.entity.UserRole;
import com.bigfong.cloud.servicebackend.system.mapper.UserRoleMapper;
import com.bigfong.cloud.servicebackend.system.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper,UserRole> implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    @Transactional
    public void deleteUserRolesByUserId(List<Long> keys) {
        QueryWrapper<UserRole> wrapper = new QueryWrapper<>();
        wrapper.in("user_id",keys);
        userRoleMapper.delete(wrapper);
    }

    @Override
    @Transactional
    public void deleteUserRolesByRoleId(List<Long> keys) {
        QueryWrapper<UserRole> wrapper = new QueryWrapper<>();
        wrapper.in("role_id",keys);
        userRoleMapper.delete(wrapper);
    }
}
