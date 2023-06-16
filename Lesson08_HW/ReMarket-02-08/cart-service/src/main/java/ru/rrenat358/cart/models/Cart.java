package ru.rrenat358.cart.models;

import lombok.Data;
import ru.rrenat358.api.core.ProductDto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
public class Cart {

    private List<CartItem> itemList;
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
        for (CartItem cartItem : itemList) {
            if (cartItem.getProductId().equals(id)) {
                cartItem.changeQuantity(+1);
                recalculate();
                return true;
            }
        }
        return false;
    }


    public void decrementProduct(Long id) {
        Iterator<CartItem> iter = itemList.iterator();
        while (iter.hasNext()) {
            CartItem cartItem = iter.next();
            if (cartItem.getProductId().equals(id)) {
                cartItem.changeQuantity(-1);
                if (cartItem.getQuantity() <= 0) {
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
        for (CartItem anotherItem : another.itemList) {
            boolean merged = false;
            for (CartItem myItem : itemList) {
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
        for (CartItem cartItem : itemList) {
            totalPrice += cartItem.getPrice();
        }
    }


    public void clear() {
        itemList.clear();
        totalPrice = 0;
    }


}
