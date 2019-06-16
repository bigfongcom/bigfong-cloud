package com.bigfong.cloud.serviceelasticsearch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@EnableEurekaClient
@MapperScan(basePackages = "com.bigfong.cloud.serviceelasticsearch.mapper.*")
public class ServiceElasticsearchApplication {

    public static void main(String[] args) {
        //System.setProperty("es.set.netty.runtime.available.processors","false");
        SpringApplication.run(ServiceElasticsearchApplication.class, args);
    }

}
