### Развертывание Standalone Eureka Server:

server:
  port: 8761
eureka:
  instance:
    hostname: localhost
  client:
    registerWithEureka: false
    fetchRegistry: false
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/

eureka:
  client:
    serviceUrl:
      defaultZone: http://peer1/eureka/,http://peer2/eureka/,http://peer3/eureka/

### Развертывание реплик Eureka Server:

---
spring:
  profiles: peer1
eureka:
  instance:
    hostname: peer1

---
spring:
  profiles: peer2
eureka:
  instance:
    hostname: peer2

---
spring:
  profiles: peer3
eureka:
  instance:
    hostname: peer3

### Конфигурирование Spring приложения при запуске:


### Запуск команды для модуля:
- mvn test -pl discovery-service
- mvn spring-boot:run -pl discovery-service
- mvn spring-boot:run -pl discovery-service -P dev (+ выбор профиля)

#### Указание параметра при запуске
- java -jar your-app.jar --server.port=8081
- mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8081" -pl discovery-service

### Gateway Cloud Service
Построен на Netty, внутри не используются сервлеты как и вроде бы Спринг

### Zipkin in Docker
- docker run -d -p 9411:9411 openzipkin/zipkin
- manual from cmd (for copy-paste): java -jar zipkin-server-2.23.2-exec.jar

### Docker
- docker-compose up
- -p 8080:80	Map TCP port 80 in the container to port 8080 on the Docker host.