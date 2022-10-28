package com.demo.northwind.business.abstracts;

import com.demo.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
}
