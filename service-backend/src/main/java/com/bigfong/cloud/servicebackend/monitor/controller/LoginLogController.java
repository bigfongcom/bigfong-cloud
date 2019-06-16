package com.bigfong.cloud.servicebackend.monitor.controller;

import com.bigfong.cloud.cloudcommon.base.ResponseMsg;
import com.bigfong.cloud.servicebackend.common.annotation.Log;
import com.bigfong.cloud.servicebackend.common.controller.BaseController;
import com.bigfong.cloud.servicebackend.common.dto.QueryPage;
import com.bigfong.cloud.servicebackend.common.exception.GlobalException;
import com.bigfong.cloud.servicebackend.monitor.entity.LoginLog;
import com.bigfong.cloud.servicebackend.monitor.service.LoginLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//import io.swagger.annotations.Api;


@RestController
@RequestMapping("/monitor/loginlog")
//@Api(value = "LoginLogController", tags = {"登录日志模块接口"})
public class LoginLogController extends BaseController {

    @Autowired
    private LoginLogService loginLogService;

    @PostMapping("/list")
    public ResponseMsg findByPage(QueryPage queryPage, LoginLog loginLog) {
        return ResponseMsg.success(super.selectByPageNumSize(queryPage, () -> loginLogService.findByPage(loginLog)));
    }

    @Log("删除登录日志")
    @PostMapping("/delete")
    @RequiresPermissions("loginlog:list")
    public ResponseMsg delete(@RequestBody List<Long> ids) {
        try {
            loginLogService.delete(ids);
            return ResponseMsg.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }
}
