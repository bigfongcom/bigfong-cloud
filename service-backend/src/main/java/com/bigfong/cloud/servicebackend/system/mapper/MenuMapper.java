package com.bigfong.cloud.servicebackend.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bigfong.cloud.servicebackend.system.entity.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> findUserMenus(String username);

    List<Menu> findUserPermissions(String username);

    void changeTopNode(List<Long> ids);
}
