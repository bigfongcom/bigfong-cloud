package com.bigfong.cloud.servicebackend.system.controller;

import com.bigfong.cloud.cloudcommon.base.Code;
import com.bigfong.cloud.cloudcommon.base.ResponseMsg;
import com.bigfong.cloud.servicebackend.common.annotation.Log;
import com.bigfong.cloud.servicebackend.common.controller.BaseController;
import com.bigfong.cloud.servicebackend.common.dto.QueryPage;
import com.bigfong.cloud.servicebackend.common.exception.GlobalException;
import com.bigfong.cloud.servicebackend.system.entity.*;
import com.bigfong.cloud.servicebackend.system.service.DeptService;
import com.bigfong.cloud.servicebackend.system.service.MenuService;
import com.bigfong.cloud.servicebackend.system.service.RoleService;
import com.bigfong.cloud.servicebackend.system.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//import io.swagger.annotations.Api;

@RestController
@RequestMapping("/system/user")
//@Api(value = "UserController", tags = {"用户管理模块接口"})
public class UserController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private DeptService deptService;

    @GetMapping("/info")
    public ResponseMsg info() {
        User user = super.getCurrentUser();
        logger.info("user={}", user.toString());

        //获取用户角色
        List<Role> roleList = roleService.findUserRole(user.getUsername());
        Set<String> roleSet = roleList.stream().map(Role::getName).collect(Collectors.toSet());

        //获取用户权限
        List<Menu> menuList = menuService.findUserPerms(user.getUsername());
        Set<String> permSet = menuList.stream().map(Menu::getPerms).collect(Collectors.toSet());

        //获取用户部门
        Dept dept = deptService.findById(user.getDeptId());

        Map<String, Object> map = new HashMap<>();
        map.put("id", user.getId());
        map.put("username", user.getUsername());
        map.put("avatar", user.getAvatar());
        map.put("phone", user.getPhone());
        map.put("sex", user.getSex());
        map.put("roles", roleSet);
        map.put("perms", permSet);
        map.put("dept", dept.getName());
        map.put("description", user.getDescription());
        return ResponseMsg.success(map);
    }

    @GetMapping("/getMenus")
    public ResponseMsg getMenus(String username) {
        return ResponseMsg.success(userService.getMenus(username));
    }

    @PostMapping("/list")
    public ResponseMsg queryList(QueryPage queryPage, User user) {
        return ResponseMsg.success(super.selectByPageNumSize(queryPage, () -> userService.queryList(user)));
    }

    @GetMapping("findById")
    public ResponseMsg findById(Long id) {
        return ResponseMsg.success(userService.findById(id));
    }

    @Log("添加用户")
    @PostMapping("/add")
    @RequiresPermissions("user:add")
    public ResponseMsg add(@RequestBody UserWithRole user) {
        try {
            userService.add(user);
            return ResponseMsg.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @GetMapping("/checkName")
    public ResponseMsg checkName(String name, String id) {
        if (name.isEmpty()) {
            return new ResponseMsg(Code.PARAM_ERROR);
        }
        if (!userService.checkName(name, id)) {
            return new ResponseMsg(Code.PARAM_REPEAT);
        }
        return ResponseMsg.success();
    }

    @Log("更新用户")
    @PostMapping("/update")
    @RequiresPermissions("user:update")
    public ResponseMsg update(@RequestBody UserWithRole user) {
        try {
            userService.update(user);
            return ResponseMsg.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @Log("删除用户")
    @PostMapping("/delete")
    @RequiresPermissions("user:delete")
    public ResponseMsg delete(@RequestBody List<Long> ids) {
        try {
            userService.delete(ids);
            return ResponseMsg.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @GetMapping("/changeAvatar")
    public ResponseMsg changeAvatar(String url) {
        try {
            User user = getCurrentUser();
            user.setAvatar(url);
            userService.update((UserWithRole)user);
            return ResponseMsg.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @GetMapping("/updatePassword")
    public ResponseMsg updatePassword(String password) {
        try {
            userService.updatePassword(password);
            return ResponseMsg.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }
}
