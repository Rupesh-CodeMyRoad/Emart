package com.infodev.emart.emart.service;

import com.infodev.emart.emart.model.Order;

import java.util.List;

public interface OrderService {
    Order addOrder(Order order);
    Order getOrderItem(Integer id);
    List<Order> getOrderItems();
    void deleteOrderByIDd(Integer id);
    void deleteOrder();
}
