package ru.rrenat358.controllers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.rrenat358.dto.Cart;
import ru.rrenat358.dto.OrderDetailsDto;
import ru.rrenat358.entities.User;
import ru.rrenat358.services.OrderService;
import ru.rrenat358.services.UserService;

import java.security.Principal;

@RestController
@RequestMapping(name = "/api/v1/orders")
@Data
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;
    private final Cart cart;


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





}
