package ru.rrenat358.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rrenat358.core.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
