package ru.rrenat358.core.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.rrenat358.api.core.OrderDto;
import ru.rrenat358.core.entities.Order;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderConverter {

    private final OrderItemConverter orderItemConverter;
    
    public Order dtoToEntity(OrderDto orderDto) {
//        return new Order(
//                orderDto.getProductId(),
//                orderDto.getProductName(),
//                orderDto.getQuantity(),
//                orderDto.getPricePerProduct(),
//                orderDto.getPrice()
//                  etc.
//                );
        throw new UnsupportedOperationException();
    }

    public OrderDto entityToDto(Order order) {
        OrderDto orderDto = new OrderDto(
                order.getId(),
                order.getUsername(),
                order.getTotalPrice(),
                order.getAddress(),
                order.getPhone(),
                order.getItems().stream()
                        .map(orderItemConverter::entityToDto)
                        .collect(Collectors.toList())
        );
        return orderDto;
    }


}
