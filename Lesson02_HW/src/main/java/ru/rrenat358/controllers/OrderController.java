package ru.rrenat358.controllers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.rrenat358.converters.OrderConverter;
import ru.rrenat358.dto.Cart;
import ru.rrenat358.dto.OrderDetailsDto;
import ru.rrenat358.dto.OrderDto;
import ru.rrenat358.entities.Order;
import ru.rrenat358.entities.User;
import ru.rrenat358.services.OrderService;
import ru.rrenat358.services.UserService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(name = "/api/v1/orders")
@Data
@RequiredArgsConstructor
public class OrderController {

    private final Cart cart;
    private final OrderService orderService;
    private final UserService userService;
    private final OrderConverter orderConverter;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(
            Principal principal,
            @RequestBody OrderDetailsDto orderDetailsDto
    ) {
        User user = userService.findByUsername(principal.getName())
                .orElseThrow(() -> new RuntimeException("noUser"));
        orderService.createOrder(user, orderDetailsDto);
    }


    @GetMapping
    public List<OrderDto> getAllOrdersByCurrentUser(Principal principal) {
        String userName = principal.getName();
        List<Order> orderList = orderService.getAllOrdersByCurrentUser(userName);
        //todo сделать конвертер листов для OrderDto
        List<OrderDto> orderDtoList = orderList.stream()
                .map(order -> orderConverter.entityToDto(order)).collect(Collectors.toList());
//        List<OrderDto> orderDtoList = orderService.getAllOrdersByCurrentUser(userName).stream()
//                .map(orderConverter::entityToDto).collect(Collectors.toList());
        return orderDtoList;
    }


}
