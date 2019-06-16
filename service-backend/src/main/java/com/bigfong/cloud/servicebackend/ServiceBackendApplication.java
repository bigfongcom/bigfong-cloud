package com.bigfong.cloud.servicebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//启用feign进行远程调用
@EnableFeignClients
@SpringBootApplication
@MapperScan("com.bigfong.cloud.servicebackend.*.mapper")
public class ServiceBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceBackendApplication.class, args);
    }

}
