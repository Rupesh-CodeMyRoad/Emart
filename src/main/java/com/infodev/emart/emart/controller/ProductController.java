package com.infodev.emart.emart.controller;


import com.infodev.emart.emart.repo.SubcategoryRepo;
import com.infodev.emart.emart.model.Product;
import com.infodev.emart.emart.model.Subcategory;
import com.infodev.emart.emart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")

public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    SubcategoryRepo subcategoryRepo;


    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/getProduct/{id}")
    public Product getProductById(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }

    @PutMapping("/updateProduct")
    public String updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return "product updated";
    }

    @PostMapping("/addProduct/{subcategoryId}")
    public String addProduct(@RequestBody Product product, @PathVariable("subcategoryId") int subcategoryId) {
        Optional<Subcategory> subcategory = subcategoryRepo.findById(subcategoryId);
        if (subcategory.isPresent()) {
            product.setSubcategory(subcategory.get());
            productService.saveProduct(product);
            return "product added";
        } else
            return "No Subcategory Found,So Product Cannot be Added";
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.deleteProductByIDd(id);
        return "Product deleted";
    }
}
