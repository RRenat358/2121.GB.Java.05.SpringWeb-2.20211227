package ru.rrenat358.complex;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
//@Order(1000)
public class SimplifiedCloudAspect {
    @Before("execution(public * com.geekbrains.aop.UserDAO.*(..))")
    public void allMethodsCallsSendInfoToCloud() {
        System.out.println("В классе UserDAO вызывают метод (Cloud)");
    }
}
