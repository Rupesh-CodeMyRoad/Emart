package com.infodev.emart.emart.service;

import com.infodev.emart.emart.model.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> saveProducts(List<Product> products);
    List<Product> getProducts();
    Product getProductById(Integer id);
    Product updateProduct(Product product);
    void deleteProductByIDd(Integer id);
}
