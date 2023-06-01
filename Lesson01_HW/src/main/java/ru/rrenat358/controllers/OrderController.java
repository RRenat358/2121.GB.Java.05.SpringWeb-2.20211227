package ru.rrenat358.controllers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rrenat358.dto.Cart;
import ru.rrenat358.dto.OrderDto;
import ru.rrenat358.entities.Order;
import ru.rrenat358.services.OrderService;

@RestController
@RequestMapping(name = "/api/v1/orders")
@Data
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final Cart cart;


    @GetMapping("/save")
    public void addCartToOrder(Cart cart) {
        orderService.addCartToOrder(cart);
    }


}
