package com.bigfong.cloud.servicebackend.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bigfong.cloud.servicebackend.system.entity.User;
import com.bigfong.cloud.servicebackend.system.entity.UserWithRole;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<User> queryList(User user);

    List<UserWithRole> findById(Long id);
}
