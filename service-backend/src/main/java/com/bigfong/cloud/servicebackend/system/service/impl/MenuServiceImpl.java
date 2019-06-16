package com.bigfong.cloud.servicebackend.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bigfong.cloud.servicebackend.common.dto.Tree;
import com.bigfong.cloud.servicebackend.common.utils.TreeUtils;
import com.bigfong.cloud.servicebackend.system.entity.Menu;
import com.bigfong.cloud.servicebackend.system.mapper.MenuMapper;
import com.bigfong.cloud.servicebackend.system.service.MenuService;
import com.bigfong.cloud.servicebackend.system.service.RoleMenuService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper,Menu> implements MenuService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    public List<Menu> findUserPerms(String username) {
        return menuMapper.findUserMenus(username);
    }

    @Override
    public List<Menu> findUserPermissions(String username) {
        return menuMapper.findUserPermissions(username);
    }

    @Override
    public List<Menu> findUserResources(String username) {
        return menuMapper.findUserMenus(username);
    }

    @Override
    public List<Menu> findAllResources(Menu menu) {
        try {
            QueryWrapper<Menu> wrapper = new QueryWrapper();
            if (StringUtils.isNotBlank(menu.getName())) {
                wrapper.eq("name", menu.getName());
            }
            wrapper.orderByDesc("id");
            return menuMapper.selectList(wrapper);
        } catch (Exception e) {
            logger.error("error", e);
            return new ArrayList<>();
        }
    }

    @Override
    public List<Menu> queryList(Menu menu) {
        try {
            QueryWrapper<Menu> wrapper = new QueryWrapper();
            if (StringUtils.isNotBlank(menu.getName())) {
                wrapper.eq("name", menu.getName());
            }
            if (StringUtils.isNotBlank(menu.getType())) {
                wrapper.eq("type", menu.getType());
            }
            wrapper.orderByDesc("id");
            return menuMapper.selectList(wrapper);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Tree<Menu>> getMenuButtonTree() {
        List<Tree<Menu>> trees = new ArrayList<>();
        List<Menu> menus = queryList(new Menu());
        buildMenuTree(trees, menus);
        return TreeUtils.build(trees);
    }

    private void buildMenuTree(List<Tree<Menu>> trees, List<Menu> menus) {
        menus.forEach(menu -> {
            Tree<Menu> tree = new Tree<>();
            tree.setId(menu.getId());
            tree.setParentId(menu.getParentId());
            tree.setName(menu.getName());
            trees.add(tree);
        });
    }

    @Override
    public List<Tree<Menu>> getMenuTree() {
        List<Tree<Menu>> trees = new ArrayList<>();
        Menu menu = new Menu();
        menu.setType("menu");
        List<Menu> menus = queryList(menu);
        buildMenuTree(trees, menus);
        return TreeUtils.build(trees);
    }

    @Override
    public Menu findById(Long id) {
        return menuMapper.selectById(id);
    }

    @Override
    @Transactional
    public void add(Menu menu) {
        menu.setCreateTime(new Date());
        if (menu.getParentId() == null) {
            menu.setParentId(0);
        }
        if (Menu.TYPE_BUTTON.equals(menu.getType())) {
            menu.setIcon(null);
            menu.setUrl(null);
        }
        menuMapper.insert(menu);
    }

    @Override
    public boolean checkName(String name, String id) {
        if (name.isEmpty()) {
            return false;
        }
        QueryWrapper<Menu> wrapper = new QueryWrapper();
        wrapper.eq("lower(name)",name.toLowerCase());
        if (!id.isEmpty()) {
            wrapper.ne("id",id);
        }
        List<Menu> menus = menuMapper.selectList(wrapper);
        if (menus.size() > 0) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public void update(Menu menu) {
        if (menu.getParentId() == null) {
            menu.setParentId(0);
        }
        if (Menu.TYPE_BUTTON.equals(menu.getType())) {
            menu.setIcon(null);
            menu.setUrl(null);
        }
        //this.updateNotNull(menu);

        menuMapper.updateById(menu);

    }

    @Override
    @Transactional
    public void delete(List<Long> ids) {
        menuMapper.deleteBatchIds(ids);
        roleMenuService.deleteRoleMenusByMenuId(ids);
        //改变父节点
        menuMapper.changeTopNode(ids);
    }


}
