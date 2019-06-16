package com.bigfong.cloud.serviceribbon.controller;

import com.bigfong.cloud.serviceribbon.service.IRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    IRibbonService iRibbonService;

    @GetMapping("/hello/{name}")
    public String index(@PathVariable("name") String name){
        return iRibbonService.hello(name);
    }
}
