package com.infodev.emart.emart.serviceimpl;

import com.infodev.emart.emart.model.Product;
import com.infodev.emart.emart.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.infodev.emart.emart.service.ProductService;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> saveProducts(List<Product> products) {
        return productRepo.saveAll(products);
    }

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepo.getOne(id);
    }

    @Override
    public Product updateProduct(Product product) {
        Product oldProduct = productRepo.getOne(product.getProductId());
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setQuantity(product.getQuantity());
        return productRepo.save(oldProduct);
    }

    @Override
    public void deleteProductByIDd(Integer id) {
        productRepo.deleteById(id);
    }
}
