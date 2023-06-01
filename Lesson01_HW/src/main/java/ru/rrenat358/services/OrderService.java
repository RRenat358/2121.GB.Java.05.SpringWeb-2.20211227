package ru.rrenat358.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rrenat358.dto.Cart;
import ru.rrenat358.dto.OrderDto;
import ru.rrenat358.dto.OrderItemDto;
import ru.rrenat358.entities.Order;
import ru.rrenat358.repositories.OrderRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderDto orderDto;
    private final OrderRepository orderRepository;
    private final CartService cartService;

    public void addCartToOrder(Cart cart) {
        orderDto.getOrderItemList().addAll(cartService.getCurrentCart(cart).getItemList());
        List<OrderItemDto> orderItemDtos = orderDto.getOrderItemList();
//        orderRepository.saveAll(orderDto.getOrderItemList());
    }


    @Transactional
    public List<Student> saveAllStudent(List<Student> studentList) {
        List<Student> response = (List<Student>) studentRepository.saveAll(studentList);
        return response;
    }

}
