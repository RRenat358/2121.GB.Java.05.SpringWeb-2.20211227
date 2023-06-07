package ru.rrenat358;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserDAO userDAO = context.getBean(UserDAO.class);

        System.out.println(userDAO.getAllUsers());

        context.close();
    }
}
