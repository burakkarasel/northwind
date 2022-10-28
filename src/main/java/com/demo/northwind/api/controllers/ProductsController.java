package com.demo.northwind.api.controllers;

import com.demo.northwind.business.abstracts.ProductService;
import com.demo.northwind.core.utilities.results.Result;
import com.demo.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result getAll(){
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @GetMapping("/get")
    public Result getOne(@RequestParam int id){
        return this.productService.getOne(id);
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
