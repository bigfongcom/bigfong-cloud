package com.bigfong.cloud.servicerabbitmq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DirectSender {
    @Autowired
    private AmqpTemplate template;

    @Value("${ebuy.erp-products-insertproduct.mq.queue.name}")
    private String queue;

    public void send(String msg) {
        template.convertAndSend(queue, msg);
    }
}