package com.geekbrains.spring.web.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebApplication {
	// Домашнее задание:
	// 1. При добавлении товара в корзину, Вы можете столкнуться с двумя проблемами:
	//    - МС продуктов не отвечает, что делать? Корзина должна сообщить фронту что возникла ошибка интеграции с кор сервисом
	//	  - Выбранный продукт не найден в кор МС
	//    Попробуйте сообщить об этом фронту (т.е. фронт по наполнению JSON ответа должен понять что пошло не так
	//     и показать простенький алерт)

	// Ближайшие доработки:
	// 1. Добавить PayPal
	// 2. Безопасность на уровне Gateway
	// 3. Поговорить про докер и подготовить docker-compose
	// 4. Посмотреть на Wiremock
	// 5. Swagger
	// 6. WebClient
	// 7. Обработка цепочек ошибок в МСах

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}
}
