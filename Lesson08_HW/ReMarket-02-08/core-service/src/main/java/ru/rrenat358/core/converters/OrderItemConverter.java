package ru.rrenat358.core.converters;

import org.springframework.stereotype.Component;
import ru.rrenat358.api.core.OrderItemDto;
import ru.rrenat358.core.entities.OrderItem;

@Component
public class OrderItemConverter {

    public OrderItem dtoToEntity(OrderItemDto orderItemDto) {
//        return new OrderItem(
//                orderItemDto.getProductId(),
//                orderItemDto.getProductName(),
//                orderItemDto.getQuantity(),
//                orderItemDto.getPricePerProduct(),
//                orderItemDto.getPrice()
//                );
        throw new UnsupportedOperationException();
    }

    public OrderItemDto entityToDto(OrderItem orderItem) {
        return new OrderItemDto(
                orderItem.getProduct().getId(),
                orderItem.getProduct().getTitle(),
                orderItem.getQuantity(),
                orderItem.getPricePerProduct(),
                orderItem.getPrice()
        );
    }


}
