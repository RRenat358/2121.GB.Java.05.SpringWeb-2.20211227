package ru.rrenat358.core.cart.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rrenat358.core.dto.Cart;
import ru.rrenat358.core.dto.OrderDto;
import ru.rrenat358.core.entities.Order;
import ru.rrenat358.core.entities.User;
import ru.rrenat358.core.repositories.OrderRepository;
import ru.rrenat358.core.repositories.UserRepository;



@Service
@RequiredArgsConstructor
public class OrderService {

    private final Order order;
    private final OrderDto orderDto;
    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final UserRepository userRepository;



    public void createOrder(User user, String address, String phone) {
        Order order = new Order();
        Cart cart = cartService.getCurrentCart();
//        List<OrderItemDto> itemList = cart.getItemList();

        order.setUser(user);
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
