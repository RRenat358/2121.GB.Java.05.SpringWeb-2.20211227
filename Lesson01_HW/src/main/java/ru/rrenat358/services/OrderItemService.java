package ru.rrenat358.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rrenat358.dto.Cart;
import ru.rrenat358.dto.OrderItemDto;
import ru.rrenat358.entities.OrderItem;
import ru.rrenat358.repositories.OrderItemsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final Cart cart;
    private final CartService cartService;
    private final OrderItem orderItem;
    private final OrderItemsRepository orderItemsRepository;



    @Transactional
    public void save() {
        List<OrderItemDto> orderItems = cartService.getCurrentCart().getItemList();
        orderItemsRepository.save(orderItem);

    }












}
