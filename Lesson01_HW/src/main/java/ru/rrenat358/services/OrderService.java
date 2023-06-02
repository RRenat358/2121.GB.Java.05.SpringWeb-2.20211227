package ru.rrenat358.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rrenat358.dto.Cart;
import ru.rrenat358.dto.OrderDto;
import ru.rrenat358.dto.OrderItemDto;
import ru.rrenat358.entities.Order;
import ru.rrenat358.entities.User;
import ru.rrenat358.repositories.OrderItemsRepository;
import ru.rrenat358.repositories.OrderRepository;
import ru.rrenat358.repositories.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final Order order;
    private final OrderDto orderDto;
    private final OrderRepository orderRepository;
    private final OrderItemsRepository orderItemsRepository;
    private final CartService cartService;
    private final UserRepository userRepository;



    public void createOrder(User user, String address, String phone) {
        Order order = new Order();
        Cart cart = cartService.getCurrentCart();
//        List<OrderItemDto> itemList = cart.getItemList();

        order.setUserId(user);
        order.setTotalPrice(cart.getTotalPrice());
        order.setAddress(address);
        order.setAddress(phone);

        orderRepository.save(order);
        cart.clear();
    }


//    public List<Order> orderListByUsername() {
//        orderRepository.findAllByUsername();
//        return ;
//    }



}
