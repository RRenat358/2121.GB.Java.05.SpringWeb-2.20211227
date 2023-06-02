package ru.rrenat358.controllers;

import ru.rrenat358.dto.Cart;
import ru.rrenat358.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartsController {
    private final CartService cartService;

    @GetMapping
    public Cart getCurrentCart() {
        return cartService.getCurrentCart();
    }

    @GetMapping("/add/{id}")
    public void addProductToCart(@PathVariable Long id) {
        cartService.addProductByIdToCart(id);
    }

    @GetMapping("/clear")
    public void clearCart() {
        cartService.getCurrentCart().clear();
    }
}
