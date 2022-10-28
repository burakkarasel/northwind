package com.demo.northwind.api.controllers;

import com.demo.northwind.business.abstracts.ProductService;
import com.demo.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService _productService){
        super();
        this.setProductService(_productService);
    }

    @GetMapping("/getall")
    public List<Product> getAll(){

        return this.productService.getAll();
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
