package com.flamexander.rabbitmq.console.consumer;

import com.flamexander.rabbitmq.console.producer.MyMessage;
import com.rabbitmq.client.*;
import org.apache.commons.lang3.SerializationUtils;

public class SerializationReceiverApp {
    private static final String EXCHANGE_NAME = "example-ser";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT, false, true, null);
        String queueName = channel.queueDeclare().getQueue();
        System.out.println("My queue name: " + queueName);
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        System.out.println(" [*] Waiting for messages");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            MyMessage mm = SerializationUtils.deserialize(delivery.getBody());
            System.out.println(" [x] Received '" + mm.getMsg() + "'");
        };

        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }
}
