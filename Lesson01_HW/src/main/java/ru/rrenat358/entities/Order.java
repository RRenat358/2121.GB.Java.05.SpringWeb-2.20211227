package ru.rrenat358.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rrenat358.dto.Cart;
import ru.rrenat358.dto.OrderItemDto;
import ru.rrenat358.entities.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "user_id")
    private int userId;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "address")
    private int address;

    @Column(name = "phone")
    private int phone;





    private List<OrderItemDto> itemList;
    private int totalPrice;

//    public Order() {
//        this.itemList = new ArrayList<>();
//    }


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
