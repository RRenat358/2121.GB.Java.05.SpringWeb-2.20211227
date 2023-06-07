package ru.rrenat358.proxy_demo;

public class ServiceProxy extends Service {
    private Service service;

    public ServiceProxy(Service service) {
        this.service = service;
    }

    @Override
    public void executeA() {
        System.out.println("New logic");
        service.executeA();
    }

    @Override
    public void executeB() {
        System.out.println("New logic");
        service.executeB();
    }
}
