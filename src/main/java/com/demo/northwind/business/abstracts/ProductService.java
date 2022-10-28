package com.demo.northwind.business.abstracts;

import com.demo.northwind.core.utilities.results.Result;
import com.demo.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    Result getAll();
    Result add(Product product);

    Result getOne(int id);
}
