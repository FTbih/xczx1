package com.xuecheng.rabbitmq.test;

import com.xuecheng.rabbitmq.config.RabbitMqConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.channels.Channel;

@Component
public class ReceiveHandler {
    @RabbitListener(queues = {RabbitMqConfig.QUEUE_INFORM_EMAIL})
    public void receiveEmail(String msg){
        System.out.println(msg);
    }
    @RabbitListener(queues = {RabbitMqConfig.QUEUE_INFORM_SMS})
    public void receiveSms(String msg){
        System.out.println(msg);
    }
}
