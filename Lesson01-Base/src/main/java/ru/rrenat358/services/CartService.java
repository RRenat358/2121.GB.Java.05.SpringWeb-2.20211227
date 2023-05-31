package ru.rrenat358.services;

import ru.rrenat358.dto.Cart;
import ru.rrenat358.entities.Product;
import ru.rrenat358.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductsService productsService;
    private Cart cart;

    @PostConstruct
    public void init() {
        cart = new Cart();
    }

    public Cart getCurrentCart() {
        return cart;
    }

    public void addProductByIdToCart(Long productId) {
        if (!getCurrentCart().addProduct(productId)) {
            Product product = productsService.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Невозможно добавить продукт в корзину. Продукт не найдет, id: " + productId));
            getCurrentCart().addProduct(product);
        }
    }

    public void clear() {
        getCurrentCart().clear();
    }
}
