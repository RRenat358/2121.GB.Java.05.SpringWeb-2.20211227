package ru.rrenat358.core.controllers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.rrenat358.api.core.OrderDetailsDto;
import ru.rrenat358.api.core.OrderDto;
import ru.rrenat358.core.converters.OrderConverter;
import ru.rrenat358.core.entities.Order;
import ru.rrenat358.core.services.OrderService;

//import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/orders")
//@Data
@RequiredArgsConstructor
public class OrdersController {

    private final OrderService orderService;
    private final OrderConverter orderConverter;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(
            @RequestHeader String username,
            @RequestBody OrderDetailsDto orderDetailsDto
    ) {
        orderService.createOrder(username, orderDetailsDto);
    }


    @GetMapping
    public List<OrderDto> getAllOrdersByCurrentUser(@RequestHeader String username) {
        List<Order> orderList = orderService.getAllOrdersByCurrentUser(username);
        //todo сделать конвертер листов для OrderDto
        List<OrderDto> orderDtoList = orderList.stream()
                .map(order -> orderConverter.entityToDto(order)).collect(Collectors.toList());
//        List<OrderDto> orderDtoList = orderService.getAllOrdersByCurrentUser(userName).stream()
//                .map(orderConverter::entityToDto).collect(Collectors.toList());
        return orderDtoList;
    }


}
