package com.demo.northwind.api.controllers;

import com.demo.northwind.business.abstracts.ProductService;
import com.demo.northwind.core.utilities.results.Result;
import com.demo.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getAll")
    public Result getAll(){
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @GetMapping("/getOne")
    public Result getOne(@RequestParam int id){
        return this.productService.getOne(id);
    }

    @GetMapping("/getByProductName")
    public Result getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }

    @GetMapping("getByProductNameAndCategoryId")
    public Result getByProductNameAndCategoryId(@RequestParam String productName, @RequestParam int categoryId){
        return this.productService.getByProductNameAndCategoryId(productName, categoryId);
    }

    @GetMapping("/getByProductNameOrCategoryId")
    public Result getByProductNameOrCategoryId(@RequestParam String productName, @RequestParam int categoryId){
        return this.productService.getByProductNameOrCategoryId(productName, categoryId);
    }

    @GetMapping("/getByCategoryIdIn")
    public Result getByCategoryIdIn(@RequestParam List<Integer> categories){
        return this.productService.getByCategoryIdIn(categories);
    }

    @GetMapping("/getByProductNameContains")
    public Result getByProductNameContains(@RequestParam String productName){
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/getByProductNameStartsWith")
    public Result getByProductNameStartsWith(@RequestParam String productName) {
        return this.productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/fetchByNameAndCategory")
    public Result fetchByNameAndCategory(@RequestParam String productName, @RequestParam int categoryId){
        return this.productService.fetchByNameAndCategory(productName, categoryId);
    }

    @GetMapping("/getAllWithPages")
    public Result getAllWithPages(@RequestParam int pageNo, @RequestParam int pageSize){
        return this.productService.getAllWithPages(pageNo, pageSize);
    }

    @GetMapping("/getAllSorted")
    public Result getAllSorted(){
        return this.productService.getAllSorted();
    }

    @GetMapping("/getProductWithCategoryDetails")
    public Result getProductWithCategoryDetails(){return this.productService.getProductWithCategoryDetails();}
    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
