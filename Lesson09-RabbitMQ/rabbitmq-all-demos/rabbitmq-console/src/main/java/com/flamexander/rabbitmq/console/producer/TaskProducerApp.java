package com.flamexander.rabbitmq.console.producer;

import com.rabbitmq.client.*;

public class TaskProducerApp {
    private static final String TASK_EXCHANGER = "task_exchanger";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            String message = "Task.....";
            channel.exchangeDeclare(TASK_EXCHANGER, BuiltinExchangeType.FANOUT);
            for (int i = 0; i < 20; i++) {
                channel.basicPublish(TASK_EXCHANGER, "", MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
                System.out.println(" [x] Sent '" + message + "'");
            }
        }
    }
}
