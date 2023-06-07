package ru.rrenat358.complex;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// @Aspect
// @Component
public class ComplexAspect {
    @Before("execution(public * com.geekbrains.aop.UserDAO.*(..))")
    public void allMethodsCallsLogging() {
        System.out.println("В классе UserDAO вызывают метод");
    }

    @Before("execution(public * com.geekbrains.aop.UserDAO.*(..))")
    public void allMethodsCallsAnalytics() {
        System.out.println("В классе UserDAO вызывают метод (Аналитика)");
    }

    @Before("execution(public * com.geekbrains.aop.UserDAO.*(..))")
    public void allMethodsCallsSendInfoToCloud() {
        System.out.println("В классе UserDAO вызывают метод (Cloud)");
    }
}
