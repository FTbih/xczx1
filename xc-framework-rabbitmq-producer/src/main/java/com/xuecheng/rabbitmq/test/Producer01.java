package com.xuecheng.rabbitmq.test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer01 {
    //队列名称
    private static final String QUEUE = "hello world";

    public static void main(String[] args) {

        Connection connection = null;
        Channel channel = null;

        ConnectionFactory factory = new ConnectionFactory();//新建连接工厂
        factory.setHost("localhost");//设置主机ip
        factory.setPort(5672);//设置端口
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");//设置连接虚拟机
        try {
            ////创建与RabbitMQ服务的TCP连接
            connection = factory.newConnection();
            //
            channel = connection.createChannel();
            /**
              * 声明队列，如果Rabbit中没有此队列将自动创建
              * param1:队列名称
              * param2:是否持久化
              * param3:队列是否独占此连接
              * param4:队列不再使用时是否自动删除此队列
              * param5:队列参数
              */
            channel.queueDeclare(QUEUE, true, false, false, null);
            String message = "姑苏慕容雪";
            /**
              * 消息发布方法
              * param1：Exchange的名称，如果没有指定，则使用Default Exchange
              * param2:routingKey,消息的路由Key，是用于Exchange（交换机）将消息转发到指定的消息队列
              * param3:消息包含的属性
              * param4：消息体
              * 这里没有指定交换机，消息将发送给默认交换机，每个队列也会绑定那个默认的交换机，但是不能显
             示绑定或解除绑定
              * 默认的交换机，routingKey等于队列名称
                */
            channel.basicPublish("",QUEUE, null, message.getBytes());
            System.out.println("消息已发送：" + message);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                channel.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
