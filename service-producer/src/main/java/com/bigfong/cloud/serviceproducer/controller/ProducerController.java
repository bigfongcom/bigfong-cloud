package com.bigfong.cloud.serviceproducer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @RequestMapping("/hello")
    public String hell(@RequestParam String name){
        return "hello "+name+",this is new world";
    }
}
