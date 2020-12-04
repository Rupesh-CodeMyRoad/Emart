package com.infodev.emart.emart.repo;

import com.infodev.emart.emart.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer> {
}
