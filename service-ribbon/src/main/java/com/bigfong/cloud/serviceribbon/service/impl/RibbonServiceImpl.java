package com.bigfong.cloud.serviceribbon.service.impl;

import com.bigfong.cloud.serviceribbon.service.IRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonServiceImpl implements IRibbonService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String hello(String name) {
        return restTemplate.getForObject("http://SERVICE-PRODUCER/hello?name="+name,String.class);
    }
}
