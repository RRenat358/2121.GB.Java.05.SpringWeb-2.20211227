package ru.rrenat358.proxy_demo;

public class MainApp {
    public static void main(String[] args) {
        Service service = new ServiceProxy(new Service());
        service.executeA();
        service.executeB();
        service.executeC();
    }
}
