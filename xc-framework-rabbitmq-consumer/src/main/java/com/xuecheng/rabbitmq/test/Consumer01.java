package com.xuecheng.rabbitmq.test;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer01 {

    private static final String QUEUE = "hello world";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE, true, false, false, null);
        DefaultConsumer consumer = new DefaultConsumer(channel){
            /**
                          * 消费者接收消息调用此方法
                          * @param consumerTag 消费者的标签，在channel.basicConsume()去指定
                          * @param envelope 消息包的内容，可从中获取消息id，消息routingkey，交换机，消息和重传标志
             (收到消息失败后是否需要重新发送)
                          * @param properties
                          * @param body
                          * @throws IOException
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String exchange = envelope.getExchange(); //交换机
                String routingKey = envelope.getRoutingKey(); //什么key
                long deliveryTag = envelope.getDeliveryTag(); // 传递标签
                String s = new String(body, "utf-8");
                System.out.println("交换机:" + exchange + " " + "routingKey：" + routingKey + " " + "deliveryTag: " + deliveryTag + " " + "消息： " + s);
            }
        };
        /**
                  * 监听队列String queue, boolean autoAck,Consumer callback
                  * 参数明细
                  * 1、队列名称
                  * 2、是否自动回复，设置为true为表示消息接收到自动向mq回复接收到了，mq接收到回复会删除消息，设置
         为false则需要手动回复
                  * 3、消费消息的方法，消费者接收到消息后调用此方法
                  */
        channel.basicConsume(QUEUE, true, consumer);
    }
}
