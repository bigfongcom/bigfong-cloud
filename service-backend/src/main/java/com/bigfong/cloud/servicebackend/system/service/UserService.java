package com.bigfong.cloud.servicebackend.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bigfong.cloud.servicebackend.common.dto.Tree;
import com.bigfong.cloud.servicebackend.system.entity.Menu;
import com.bigfong.cloud.servicebackend.system.entity.User;
import com.bigfong.cloud.servicebackend.system.entity.UserWithRole;

import java.util.List;


public interface UserService extends IService<User> {

    User findByName(String username);

    UserWithRole findById(Long id);

    List<Tree<Menu>> getMenus(String username);

    List<User> queryList(User user);

    void add(UserWithRole user);

    boolean checkName(String name, String id);

    void update(UserWithRole user);

    void delete(List<Long> keys);

    void updatePassword(String password);
}
