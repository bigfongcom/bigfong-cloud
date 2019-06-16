package com.bigfong.cloud.servicebackend.monitor.controller;

import com.bigfong.cloud.cloudcommon.base.ResponseMsg;
import com.bigfong.cloud.servicebackend.common.annotation.Log;
import com.bigfong.cloud.servicebackend.common.controller.BaseController;
import com.bigfong.cloud.servicebackend.common.dto.QueryPage;
import com.bigfong.cloud.servicebackend.common.exception.GlobalException;
import com.bigfong.cloud.servicebackend.monitor.entity.SysLog;
import com.bigfong.cloud.servicebackend.monitor.service.LogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/monitor/log")
public class LogController extends BaseController {

    @Autowired
    private LogService logService;

    @PostMapping("/list")
    public ResponseMsg findByPage(QueryPage page, SysLog log) {
        return ResponseMsg.success(super.selectByPageNumSize(page, () -> logService.findByPage(log)));
    }

    @Log("删除系统日志")
    @PostMapping("/delete")
    @RequiresPermissions("log:delete")
    public ResponseMsg delete(@RequestBody List<Long> ids) {
        try {
            logService.deleteLogs(ids);
            return ResponseMsg.success();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }
}
