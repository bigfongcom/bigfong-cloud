package com.bigfong.cloud.serviceconsumerribbon.service;

import org.jboss.logging.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class FeignServiceHystrix implements IFeignExampleService {
    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "sorry "+name+"，service has fail!";
    }
}
