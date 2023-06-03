package ru.rrenat358.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rrenat358.dto.Cart;
import ru.rrenat358.dto.OrderDetailsDto;
import ru.rrenat358.dto.OrderDto;
import ru.rrenat358.dto.OrderItemDto;
import ru.rrenat358.entities.Order;
import ru.rrenat358.entities.OrderItem;
import ru.rrenat358.entities.User;
import ru.rrenat358.repositories.OrderRepository;
import ru.rrenat358.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final Order order;
    private final OrderDto orderDto;
    private final OrderRepository orderRepository;
    private final ProductsService productsService;
    private final CartService cartService;
    private final UserRepository userRepository;



    @Transactional
    public void createOrder(User user, OrderDetailsDto orderDetailsDto) {
        Order order = new Order();
        Cart cart = cartService.getCurrentCart();

        order.setUser(user);
        order.setTotalPrice(cart.getTotalPrice());
        order.setAddress(orderDetailsDto.getAddress());
        order.setPhone(orderDetailsDto.getPhone());

//        List<OrderItemDto> itemList = cart.getItemList()
//                        .stream().toList();

        List<OrderItem> itemList = cart.getItemList().stream()
                .map(orderItemDto -> {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setOrder(order);
                    orderItem.setQuantity(orderItemDto.getQuantity());
                    orderItem.setPrice(orderItemDto.getPrice());
                    orderItem.setPricePerProduct(orderItemDto.getPricePerProduct());
                    orderItem.setProduct(productsService.findById(orderItemDto.getProductId())
                            .orElseThrow(() -> new RuntimeException("Продукт не найден")));
                    return orderItem;
                }).collect(Collectors.toList());

        order.setItems(itemList);
        orderRepository.save(order);
        cart.clear();
    }



}
