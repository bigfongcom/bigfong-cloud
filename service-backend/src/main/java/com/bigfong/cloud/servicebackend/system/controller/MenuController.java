package com.bigfong.cloud.servicebackend.system.controller;

import com.bigfong.cloud.cloudcommon.base.Code;
import com.bigfong.cloud.cloudcommon.base.ResponseMsg;
import com.bigfong.cloud.servicebackend.common.annotation.Log;
import com.bigfong.cloud.servicebackend.common.controller.BaseController;
import com.bigfong.cloud.servicebackend.common.dto.QueryPage;
import com.bigfong.cloud.servicebackend.common.exception.GlobalException;
import com.bigfong.cloud.servicebackend.system.entity.Menu;
import com.bigfong.cloud.servicebackend.system.service.MenuService;
//import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/menu")
//@Api(value = "MenuController", tags = {"菜单管理模块接口"})
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/list")
    public ResponseMsg queryList(QueryPage queryPage, Menu menu) {
        return ResponseMsg.success(super.selectByPageNumSize(queryPage, () -> menuService.queryList(menu)));
    }

    @GetMapping("/urlList")
    public ResponseMsg getAllUrl() {
        return ResponseMsg.success(menuService.queryList(new Menu()));
    }

    @GetMapping("/menuButtonTree")
    public ResponseMsg getMenuButtonTree() {
        try {
            return ResponseMsg.success(menuService.getMenuButtonTree());
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @GetMapping("/menuTree")
    public ResponseMsg getMenuTree() {
        try {
            return ResponseMsg.success(menuService.getMenuTree());
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @GetMapping("/findById")
    public ResponseMsg findById(Long id) {
        try {
            return ResponseMsg.success(menuService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @Log("添加菜单")
    @PostMapping("/add")
    @RequiresPermissions("menu:add")
    public ResponseMsg add(@RequestBody Menu menu) {
        try {
            menuService.add(menu);
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
        if (!menuService.checkName(name, id)) {
            return new ResponseMsg(Code.PARAM_REPEAT);
        }
        return ResponseMsg.success();
    }

    @Log("更新菜单")
    @PostMapping("/update")
    @RequiresPermissions("menu:update")
    public ResponseMsg update(@RequestBody Menu menu) {
        try {
            menuService.update(menu);
            return ResponseMsg.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @Log("删除菜单")
    @PostMapping("/delete")
    @RequiresPermissions("menu:delete")
    public ResponseMsg delete(@RequestBody List<Long> ids) {
        try {
            menuService.delete(ids);
            return ResponseMsg.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }
}
