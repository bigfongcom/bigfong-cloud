package com.bigfong.cloud.servicerabbitmq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String msg){
        try {
            amqpTemplate.convertAndSend("fanoutExchange","",msg);//第二个参数忽略
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
