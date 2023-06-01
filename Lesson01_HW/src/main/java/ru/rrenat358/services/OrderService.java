package ru.rrenat358.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rrenat358.dto.Cart;
import ru.rrenat358.dto.OrderDto;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderDto orderDto;
    private final CartService cartService;

    public void addCartToOrder(Cart cart) {

        orderDto.getOrderItemList().addAll(cartService.getCurrentCart().getItemList());

    }




}
