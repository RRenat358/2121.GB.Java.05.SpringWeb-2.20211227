package com.flamexander.rabbitmq.console.producer;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.commons.lang3.SerializationUtils;

public class SerializationSenderApp {
    private static final String EXCHANGE_NAME = "example-ser";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT, false, true, null);
            channel.basicPublish(EXCHANGE_NAME, "", null, SerializationUtils.serialize(new MyMessage("Hello!")));
            System.out.println(" [x] Sent");
        }
    }
}
