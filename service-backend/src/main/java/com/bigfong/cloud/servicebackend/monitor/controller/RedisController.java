package com.bigfong.cloud.servicebackend.monitor.controller;

import com.bigfong.cloud.cloudcommon.base.ResponseMsg;
import com.bigfong.cloud.servicebackend.monitor.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitor/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/info")
    public ResponseMsg info() {
        return ResponseMsg.success(redisService.getRedisInfo());
    }

    @GetMapping("/dbsize")
    public ResponseMsg dbsize() {
        return ResponseMsg.success(redisService.getRedisDbSize());
    }

    @GetMapping("/memory")
    public ResponseMsg memory() {
        return ResponseMsg.success(redisService.getRedisMemory());
    }
}
