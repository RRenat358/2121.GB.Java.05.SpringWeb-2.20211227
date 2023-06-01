package ru.rrenat358.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rrenat358.entities.Product;

@Data
@NoArgsConstructor

public class OrderItemDto {

    private Long productId;
    private String productTitle;
    private int quantity;
    private int pricePerProduct;
    private int price;

    public OrderItemDto(Product product) {
        this.productId = product.getId();
        this.productTitle = product.getName();
        this.quantity = 1;
        this.pricePerProduct = product.getPrice();
        this.price = product.getPrice();
    }

    public void changeQuantity(int delta) {
        this.quantity += delta;
        this.price = this.quantity * this.pricePerProduct;
    }


}
