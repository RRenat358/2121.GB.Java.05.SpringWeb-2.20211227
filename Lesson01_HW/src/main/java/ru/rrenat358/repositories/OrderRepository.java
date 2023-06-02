package ru.rrenat358.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rrenat358.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
