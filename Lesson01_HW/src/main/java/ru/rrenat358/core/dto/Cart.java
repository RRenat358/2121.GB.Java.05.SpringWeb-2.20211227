package ru.rrenat358.core.dto;

import lombok.Data;
import ru.rrenat358.core.entities.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
public class Cart {

    private List<OrderItemDto> itemList;
    private int totalPrice;

    public Cart() {
        this.itemList = new ArrayList<>();
    }


    public void addProduct(Product product) {
        if (addProduct(product.getId())) {
            return;
        }
        itemList.add(new OrderItemDto(product));
        recalculate();
    }


    public boolean addProduct(Long id) {
        for (OrderItemDto orderItemDto : itemList) {
            if (orderItemDto.getProductId().equals(id)) {
                orderItemDto.changeQuantity(+1);
                recalculate();
                return true;
            }
        }
        return false;
    }


    public void decreaseProduct(Long id) {
        Iterator<OrderItemDto> iter = itemList.iterator();
        while (iter.hasNext()) {
            OrderItemDto orderItemDto = iter.next();
            if (orderItemDto.getProductId().equals(id)) {
                orderItemDto.changeQuantity(-1);
                if (orderItemDto.getQuantity() <= 0) {
                    iter.remove();
                }
                recalculate();
                return;
            }
        }
    }


    public void removeProduct(Long id) {
        itemList.removeIf(orderItemDto -> orderItemDto.getProductId().equals(id));
        recalculate();
    }


    private void recalculate() {
        totalPrice = 0;
        for (OrderItemDto orderItemDto : itemList) {
            totalPrice += orderItemDto.getPrice();
        }
    }


    public void clear() {
        itemList.clear();
        totalPrice = 0;
    }


}
