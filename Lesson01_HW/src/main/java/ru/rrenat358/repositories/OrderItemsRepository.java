package ru.rrenat358.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rrenat358.entities.Order;
import ru.rrenat358.entities.OrderItem;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItem, Long> {

}
