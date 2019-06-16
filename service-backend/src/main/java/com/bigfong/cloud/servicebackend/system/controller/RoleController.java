package com.bigfong.cloud.servicebackend.system.controller;

import com.bigfong.cloud.cloudcommon.base.Code;
import com.bigfong.cloud.cloudcommon.base.ResponseMsg;
import com.bigfong.cloud.servicebackend.common.annotation.Log;
import com.bigfong.cloud.servicebackend.common.controller.BaseController;
import com.bigfong.cloud.servicebackend.common.dto.QueryPage;
import com.bigfong.cloud.servicebackend.common.exception.GlobalException;
import com.bigfong.cloud.servicebackend.system.entity.Role;
import com.bigfong.cloud.servicebackend.system.entity.RoleWithMenu;
import com.bigfong.cloud.servicebackend.system.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import io.swagger.annotations.Api;

@RestController
@RequestMapping("/system/role")
//@Api(value = "RoleController", tags = {"角色管理模块接口"})
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/list")
    public ResponseMsg queryList(QueryPage queryPage, Role role) {
        return ResponseMsg.success(super.selectByPageNumSize(queryPage, () -> roleService.queryList(role)));
    }

    @GetMapping("/findById")
    public ResponseMsg findById(Long id) {
        return ResponseMsg.success(roleService.findById(id));
    }

    @Log("添加角色")
    @PostMapping("/add")
    @RequiresPermissions("role:add")
    public ResponseMsg add(@RequestBody RoleWithMenu role) {
        try {
            roleService.add(role);
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
        if (!roleService.checkName(name, id)) {
            return new ResponseMsg(Code.PARAM_REPEAT);
        }
        return ResponseMsg.success();
    }

    @Log("更新角色")
    @PostMapping("update")
    @RequiresPermissions("role:update")
    public ResponseMsg update(@RequestBody RoleWithMenu role) {
        try {
            roleService.update(role);
            return ResponseMsg.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @Log("删除角色")
    @PostMapping("/delete")
    @RequiresPermissions("role:delete")
    public ResponseMsg delete(@RequestBody List<Long> ids) {
        try {
            roleService.delete(ids);
            return ResponseMsg.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }
}
