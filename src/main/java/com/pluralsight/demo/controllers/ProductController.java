package com.pluralsight.demo.controllers;

import com.pluralsight.demo.daos.ProductDao;
import com.pluralsight.demo.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private ProductDao productDao;

    public ProductController(ProductDao productDao){
        this.productDao = productDao;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productDao.getAllProducts();
    }

    @GetMapping("{name}")
    public Product getProductByName(@PathVariable String name){
        return productDao.getProductsByName(name).getFirst();
    }
}
