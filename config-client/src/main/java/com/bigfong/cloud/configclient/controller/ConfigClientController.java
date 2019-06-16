package com.bigfong.cloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    //@Value("${writer}")
    private String writer;

    @GetMapping("/writer")
    public String writer(){
        return writer;
    }
}
