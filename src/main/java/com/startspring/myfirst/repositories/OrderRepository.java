package com.startspring.myfirst.repositories;

import com.startspring.myfirst.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Order, Long> {

}
