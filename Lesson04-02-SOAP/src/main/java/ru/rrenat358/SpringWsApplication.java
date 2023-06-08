package ru.rrenat358;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWsApplication {
	// Домашнее задание:
	// 1. Добавить к магазину возможность выгрузки всех товаров,
	// и отдельных товаров по id через SOAP

	public static void main(String[] args) {
		SpringApplication.run(SpringWsApplication.class, args);
	}
}
