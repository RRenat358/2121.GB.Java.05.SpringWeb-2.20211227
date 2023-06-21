package com.flamexander.rabbitmq.console.producer;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class SimpleSenderApp {
    private final static String QUEUE_NAME = "hello";
    private final static String EXCHANGER_NAME = "hello_exchanger";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGER_NAME, BuiltinExchangeType.DIRECT);
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.queueBind(QUEUE_NAME, EXCHANGER_NAME, "java");

            String message = "Hello World!";
            channel.basicPublish(EXCHANGER_NAME, "java", null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}
























