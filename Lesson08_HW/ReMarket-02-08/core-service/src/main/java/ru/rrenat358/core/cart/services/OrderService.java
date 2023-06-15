package ru.rrenat358.core.cart.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rrenat358.core.dto.Cart;
import ru.rrenat358.core.OrderDetailsDto;
import ru.rrenat358.core.entities.Order;
import ru.rrenat358.core.entities.OrderItem;
import ru.rrenat358.core.entities.User;
import ru.rrenat358.core.repositories.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductsService productsService;
    private final CartService cartService;
    private final OrderRepository orderRepository;



    @Transactional
    public void createOrder(User user, OrderDetailsDto orderDetailsDto) {
        Order order = new Order();
        String cartKey = cartService.getCartUuidFromSuffix(user.getUsername());
        Cart currentCart = cartService.getCurrentCart(cartKey);

        order.setUser(user);
        order.setTotalPrice(currentCart.getTotalPrice());
        order.setAddress(orderDetailsDto.getAddress());
        order.setPhone(orderDetailsDto.getPhone());

//        List<OrderItemDto> itemList = currentCart.getItemList()
//                        .stream().toList();

        List<OrderItem> itemList = currentCart.getItemList().stream()
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
        cartService.clearCart(cartKey);
    }

    public List<Order> getAllOrdersByCurrentUser(String userName) {
        return orderRepository.findAllOrdersByUsername(userName);
    }



}
