package ru.rrenat358.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "order_id")
    private Long orderId;


    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price_per_product")
    private int pricePerProduct;

    @Column(name = "price")
    private int price;




}
