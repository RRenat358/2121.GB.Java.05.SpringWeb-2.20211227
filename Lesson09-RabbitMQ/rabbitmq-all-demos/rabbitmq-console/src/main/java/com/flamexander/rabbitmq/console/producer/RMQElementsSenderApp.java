package com.flamexander.rabbitmq.console.producer;

import com.rabbitmq.client.*;

public class RMQElementsSenderApp {
    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            String message = "info: Hello World!";
            channel.basicPublish("ReadyExchanger", "", null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}
