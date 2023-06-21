package com.flamexander.rabbitmq.spring.from_console_to_web;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringRabbitmqApp {
    public static final String EXCHANGE_FOR_PROCESSING_TASK = "processingExchanger";
    public static final String QUEUE_WITH_PROCESSING_TASK_RESULTS = "processingResultsQueue";

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

//    @Bean
//    public Queue resultsQueue() {
//        return new Queue(QUEUE_WITH_PROCESSING_TASK_RESULTS, true, false, false);
//    }

    @GetMapping("/{message}")
    public String sendMessage(@PathVariable String message) {
        rabbitTemplate.convertAndSend(SpringRabbitmqApp.EXCHANGE_FOR_PROCESSING_TASK, null, "Task from Server: " + message);
        return "OK";
    }

    @Bean
    public SimpleMessageListenerContainer containerForTopic(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_WITH_PROCESSING_TASK_RESULTS);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(SimpleMessageReceiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringRabbitmqApp.class, args);
    }

    // Домашнее задание:
    // 1. Сделайте два консольных приложения (не Спринг):
    //
    //   а. IT-блог, который публикует статьи по языкам программирования
    //   б. Подписчик, которого интересуют статьи по определенным языкам
    //
    //   Детали a. Если IT-блог в консоли пишет 'php some message', то 'some message'
    //   отправляется в RabbitMQ с темой 'php', и это сообщение получают подписчики
    //   этой темы
    //
    //   Детали b. Подписчик при запуске должен ввести команду 'set_topic php', после
    //   чего начнет получать сообщения из очереди с соответствующей темой 'php'
    //
    // 2. * Сделайте возможность клиентов подписываться и отписываться от статей по темам
    // в процессе работы приложения-подписчика
}