package com.infodev.emart.emart.controller;

import com.infodev.emart.emart.model.Order;
import com.infodev.emart.emart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/addOrder")
    public String addCart(@RequestBody Order orderProduct) {
       orderService.addOrder(orderProduct);
       return "Cart Added";
    }

    @GetMapping("/getOrderItem/{id}")
    public Order getCartItem(@PathVariable("id") int id) {
        return orderService.getOrderItem(id);
    }

    @GetMapping("/getOrderItems")
    public List<Order> getCart() {
        return orderService.getOrderItems();
    }


    @DeleteMapping("/deleteOrderItem/{id}")
    public String deleteCartItemById(@PathVariable("id") int id) {

        orderService.deleteOrderByIDd(id);
        return "Item deleted";
    }

    @DeleteMapping("/deleteOrder")
    public String emptyCart() {
       orderService.deleteOrder();
       return "Cart Deleted";
    }

}
