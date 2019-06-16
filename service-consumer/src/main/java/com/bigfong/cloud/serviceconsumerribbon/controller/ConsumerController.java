package com.bigfong.cloud.serviceconsumerribbon.controller;

import com.bigfong.cloud.serviceconsumerribbon.service.IFeignExampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Resource
    private IFeignExampleService iFeignExampleService;

    @GetMapping("/hello/{name}")
    public String index(@PathVariable("name") String name){
        return iFeignExampleService.hello(name);
    }
}
