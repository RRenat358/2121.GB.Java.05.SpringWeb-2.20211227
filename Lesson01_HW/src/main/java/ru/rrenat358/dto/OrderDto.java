package ru.rrenat358.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private List<OrderItemDto> orderItemList;

    private int user;

    private int totalPrice;

    private int address;

    private int phone;







}
