package com.bigfong.cloud.servicerabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConf {

    @Value("${ebuy.erp-products-insertproduct.mq.queue.name}")
    private String queue;

     @Bean(name="${ebuy.erp-products-insertproduct.mq.queue.name}")
     public Queue insertProduct() {
          return new Queue(queue);
     }
}