package ru.rrenat358;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UserDAO {
    int x;

    void myDefaultMethod() {
        System.out.println("private call");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void addUser() {
        System.out.println("Новый пользователь добавлен");
    }

    public void deleteUser() {
        System.out.println("Пользователь удален");
    }

    public void updateUser() {
        System.out.println("Пользователь обновлен");
    }

    public void findAll() {
        System.out.println("Все пользователи найдены");
    }

    public void findOneById(Long id) {
        System.out.println("Найден пользователь с id = " + id);
    }

    public List<String> getAllUsers() {
        return new ArrayList<>(Arrays.asList("Bob", "Alex", "Jack"));
    }

    public void longOperation() {
        System.out.println("op start");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("op end");
    }
}
