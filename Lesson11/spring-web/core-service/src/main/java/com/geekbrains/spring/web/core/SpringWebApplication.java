package com.geekbrains.spring.web.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebApplication {
	// Домашнее задание:
	// 1. Покрыть код кор-сервиса и карт-сервиса доками сваггера
	// 2. Замените оставшийся RestTemplate на WebClient
	// 3. В конфиге сделайте преобразование в:
	// integrations:
	//  cart-service:
	//    url: http://localhost:5555/cart
	//    connect-timeout: 2000
	//    read-timeout: 10000
	//    write-timeout: 2000
	// В:
	// integrations:
	//  cart-service:
	//    url: http://localhost:5555/cart
	//    timeouts:
	//      read: 2000
	//		write: 2000
	//		connection: 1000

	// Ближайшие доработки:
	// . Поговорить про докер и подготовить docker-compose
	// . Добавить PayPal
	// . Categories (до след занятия)
	// . Фронт кнопки назад вперед в пагинации (до след занятия)
	// . Безопасность на уровне Gateway
	// . Посмотреть на Wiremock
	// . WebClient

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}
}
