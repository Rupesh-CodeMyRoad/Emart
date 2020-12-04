package com.infodev.emart.emart.serviceimpl;

import com.google.common.collect.Lists;
import com.infodev.emart.emart.model.Order;
import com.infodev.emart.emart.model.Product;
import com.infodev.emart.emart.repo.OrderRepo;
import com.infodev.emart.emart.repo.ProductRepo;
import com.infodev.emart.emart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImp implements OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ProductRepo productRepo;

    @Override
    public Order addOrder(Order orderProduct) {

        Iterable<Product> products;
        products = productRepo.saveAll(orderProduct.getProductList());
        List<Product> productList = Lists.newArrayList(products);
        orderProduct.setProductList(productList);
        return orderRepo.save(orderProduct);
    }

    @Override
    public Order getOrderItem(Integer id) {
        return orderRepo.getOne(id);
    }

    @Override
    public List<Order> getOrderItems() {
        return orderRepo.findAll();
    }


    @Override
    public void deleteOrderByIDd(Integer id) {
        orderRepo.deleteById(id);
    }

    @Override
    public void deleteOrder() {
        orderRepo.deleteAll();
    }


}
