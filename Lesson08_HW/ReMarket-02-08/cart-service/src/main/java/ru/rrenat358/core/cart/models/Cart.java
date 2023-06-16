package ru.rrenat358.core.cart.models;

import lombok.Data;
import ru.rrenat358.api.core.OrderItemDto;
import ru.rrenat358.api.core.ProductDto;
//import ru.rrenat358.core.entities.Product;

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


    public void addProduct(ProductDto productDto) {
        if (addProduct(productDto.getId())) {
            return;
        }
        itemList.add(new CartItem(productDto));
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


    public void decrementProduct(Long id) {
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


    public void merge(Cart another) {
        for (OrderItemDto anotherItem : another.itemList) {
            boolean merged = false;
            for (OrderItemDto myItem : itemList) {
                if (myItem.getProductId().equals(anotherItem.getProductId())) {
                    myItem.changeQuantity(anotherItem.getQuantity());
                    merged = true;
                    break;
                }
            }
            if (!merged) {
                itemList.add(anotherItem);
            }
        }
        recalculate();
        another.clear();
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
