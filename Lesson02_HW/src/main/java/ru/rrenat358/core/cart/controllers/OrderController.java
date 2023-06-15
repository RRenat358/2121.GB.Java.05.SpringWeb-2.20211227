package ru.rrenat358.core.cart.controllers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.rrenat358.core.cart.converters.OrderConverter;
import ru.rrenat358.core.dto.OrderDetailsDto;
import ru.rrenat358.core.dto.OrderDto;
import ru.rrenat358.core.entities.Order;
import ru.rrenat358.core.entities.User;
import ru.rrenat358.core.cart.services.OrderService;
import ru.rrenat358.core.cart.services.UserService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@Data
@RequiredArgsConstructor
public class OrderController {

    //    private final Cart cart;
    private final UserService userService;
    private final OrderService orderService;
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
