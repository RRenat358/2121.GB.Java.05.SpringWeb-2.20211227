package ru.rrenat358.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rrenat358.dto.Cart;
import ru.rrenat358.dto.OrderItemDto;
import ru.rrenat358.entities.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


//    @OneToOne
    @Column(name = "user_id")
    private int userId;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "address")
    private int address;

    @Column(name = "phone")
    private int phone;



}
