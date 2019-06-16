package com.bigfong.cloud.servicebackend.system.controller;

import com.bigfong.cloud.cloudcommon.base.Code;
import com.bigfong.cloud.cloudcommon.base.ResponseMsg;
import com.bigfong.cloud.servicebackend.common.annotation.Log;
import com.bigfong.cloud.servicebackend.common.controller.BaseController;
import com.bigfong.cloud.servicebackend.common.dto.QueryPage;
import com.bigfong.cloud.servicebackend.common.exception.GlobalException;
import com.bigfong.cloud.servicebackend.system.entity.Dept;
import com.bigfong.cloud.servicebackend.system.service.DeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import io.swagger.annotations.Api;

@RestController
@RequestMapping("/system/dept")
//@Api(value = "DeptController", tags = {"部门管理模块接口"})
public class DeptController extends BaseController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/list")
    public ResponseMsg queryList(QueryPage queryPage, Dept dept) {
        return ResponseMsg.success(super.selectByPageNumSize(queryPage, () -> deptService.queryList(dept)));
    }

    @GetMapping("/tree")
    public ResponseMsg tree() {
        return ResponseMsg.success(deptService.tree());
    }

    @GetMapping("/findById")
    public ResponseMsg findById(Integer id) {
        return ResponseMsg.success(deptService.findById(id));
    }

    @Log("添加部门")
    @PostMapping("/add")
    @RequiresPermissions("dept:add")
    public ResponseMsg add(@RequestBody Dept dept) {
        try {
            deptService.add(dept);
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
        if (!deptService.checkName(name, id)) {
            return new ResponseMsg(Code.PARAM_REPEAT);
        }
        return ResponseMsg.success();
    }

    @Log("更新部门")
    @PostMapping("update")
    @RequiresPermissions("dept:update")
    public ResponseMsg update(@RequestBody Dept dept) {
        try {
            deptService.update(dept);
            return ResponseMsg.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @Log("删除部门")
    @PostMapping("/delete")
    @RequiresPermissions("dept:delete")
    public ResponseMsg delete(@RequestBody List<Integer> ids) {
        try {
            deptService.delete(ids);
            return ResponseMsg.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }
}
