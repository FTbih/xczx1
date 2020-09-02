package com.xuecheng.rabbitmq.test;

import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Consumer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void testSend(){
        for (int i = 0; i < 5; i++) {

        }
    }


}
