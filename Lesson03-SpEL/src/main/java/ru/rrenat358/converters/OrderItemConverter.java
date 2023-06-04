package ru.rrenat358.converters;

import ru.rrenat358.dto.OrderItemDto;
import ru.rrenat358.dto.ProductDto;
import ru.rrenat358.entities.OrderItem;
import ru.rrenat358.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class OrderItemConverter {
    public OrderItem dtoToEntity(OrderItemDto orderItemDto) {
        throw new UnsupportedOperationException();
    }

    public OrderItemDto entityToDto(OrderItem orderItem) {
        return new OrderItemDto(orderItem.getProduct().getId(), orderItem.getProduct().getTitle(), orderItem.getQuantity(), orderItem.getPricePerProduct(), orderItem.getPrice());
    }
}
