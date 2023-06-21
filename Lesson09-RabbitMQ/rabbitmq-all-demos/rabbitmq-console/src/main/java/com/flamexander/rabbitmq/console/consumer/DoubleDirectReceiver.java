package com.flamexander.rabbitmq.console.consumer;

import com.rabbitmq.client.*;

public class DoubleDirectReceiver {
    private static final String EXCHANGE_NAME = "DoubleDirect";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        String queueName = channel.queueDeclare().getQueue();
        System.out.println("My queue name: " + queueName);

        channel.queueBind(queueName, EXCHANGE_NAME, "php");
        channel.queueBind(queueName, EXCHANGE_NAME, "java");

        System.out.println(" [*] Waiting for messages");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
            System.out.println(Thread.currentThread().getName());
        };

        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
    }
}
