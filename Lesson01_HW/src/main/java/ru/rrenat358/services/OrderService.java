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



    public void addCartToOrder(Cart cart) {
        orderDto.getOrderItemList().addAll(cartService.getCurrentCart(cart).getItemList());
        List<OrderItemDto> orderItemDtos = orderDto.getOrderItemList();
        orderRepository.saveAll(orderDto.getOrderItemList());
    }

    public Optional<OrderItemDto> addCartToOrder2(Cart cart) {
        orderDto.getOrderItemList().addAll(cartService.getCurrentCart(cart).getItemList());
        List<OrderItemDto> orderItemDtos = orderDto.getOrderItemList();
//        orderRepository.saveAll(Collections.singletonList(orderDto.getOrderItemList()));
        return orderRepository.saveAllAndFlush(orderDto.getOrderItemList());

//        List<OrderItemDto> response = (List<OrderItemDto>) orderRepository.saveAll(orderItemDtos).orElse(null);
//        orderRepository.saveAll(orderItemDtos);
    }


    public void addCartToOrder3(Cart cart) {
        orderDto.getOrderItemList().addAll(cartService.getCurrentCart(cart).getItemList());
        List<OrderItemDto> orderItemDtos = orderDto.getOrderItemList();
        orderRepository.saveAll(orderDto.getOrderItemList().stream().map(orderItemDto -> orderDto.getOrderItemList())));
    }


    public void addCartToOrder4() {
        Cart cart = cartService.getCurrentCart();
        List<OrderItemDto> orderItemList =  cart.getItemList();

//        orderDto.getOrderItemList().addAll(cart.getItemList());

        orderDto.getOrderItemList().addAll(cart.getItemList());

//        orderRepository.saveAll(orderItemList);
        orderRepository.saveAll(orderItemList.listIterator().hasNext());

        orderItemList.forEach(o -> orderRepository.save(o));

        ListIterator<OrderItemDto> listIterator = orderItemList.listIterator();

        while(listIterator.hasNext()) {
            orderRepository.save(listIterator.next());
        }


    }

    public void addCartToOrder5() {
        orderDto.getOrderItemList().addAll(cartService.getCurrentCart(cart).getItemList());
        List<OrderItemDto> orderItemDtos = orderDto.getOrderItemList();
        List<OrderItemDto> orderItemDtos2 = orderItemsRepository.saveAll(orderItemDtos);
    }


    public void newOreder(User userId, String address, String phone) {
//        Order order = new Order();
        Cart cart = cartService.getCurrentCart();
        List<OrderItemDto> itemList = cart.getItemList();

//        order.setUserId();
        order.setTotalPrice(cart.getTotalPrice());
        order.setAddress(address);
        order.setAddress(phone);



        orderDto.getOrderItemList().addAll(cartService.getCurrentCart(cart).getItemList());
        List<OrderItemDto> orderItemDtos = orderDto.getOrderItemList();
        List<OrderItemDto> orderItemDtos2 = orderItemsRepository.saveAll(orderItemDtos);
    }





}
