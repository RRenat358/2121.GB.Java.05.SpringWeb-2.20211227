package ru.rrenat358.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rrenat358.dto.Cart;
import ru.rrenat358.dto.OrderDetailsDto;
import ru.rrenat358.dto.OrderDto;
import ru.rrenat358.entities.Order;
import ru.rrenat358.entities.User;
import ru.rrenat358.repositories.OrderRepository;
import ru.rrenat358.repositories.UserRepository;



@Service
@RequiredArgsConstructor
public class OrderService {

    private final Order order;
    private final OrderDto orderDto;
    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final UserRepository userRepository;



    public void createOrder(User user, OrderDetailsDto orderDetailsDto) {
        Order order = new Order();
        Cart cart = cartService.getCurrentCart();
//        List<OrderItemDto> itemList = cart.getItemList();

        order.setUser(user);
        order.setTotalPrice(cart.getTotalPrice());
        order.setAddress(orderDetailsDto.getAddress());
        order.setPhone(orderDetailsDto.getPhone());

        orderRepository.save(order);
        cart.clear();
    }


//    public List<Order> orderListByUsername() {
//        orderRepository.findAllByUsername();
//        return ;
//    }



}
