package com.bigfong.cloud.servicedata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
//启用feign进行远程调用
@EnableFeignClients
@MapperScan(basePackages = "com.bigfong.cloud.servicedata.mapper")
public class ServiceDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDataApplication.class, args);
    }

}
