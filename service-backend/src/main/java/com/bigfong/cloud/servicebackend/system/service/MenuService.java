package com.bigfong.cloud.servicebackend.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bigfong.cloud.servicebackend.common.dto.Tree;
import com.bigfong.cloud.servicebackend.system.entity.Menu;

import java.util.List;

public interface MenuService extends IService<Menu> {

    List<Menu> findUserPerms(String username);

    List<Menu> findUserPermissions(String username);

    List<Menu> findUserResources(String username);

    List<Menu> findAllResources(Menu menu);

    List<Menu> queryList(Menu menu);

    List<Tree<Menu>> getMenuButtonTree();

    List<Tree<Menu>> getMenuTree();

    Menu findById(Long id);

    void add(Menu menu);

    boolean checkName(String name, String id);

    void update(Menu menu);

    void delete(List<Long> ids);
}
