package com.demo.northwind.business.abstracts;

import com.demo.northwind.core.utilities.results.Result;
import com.demo.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    Result getAll();
    Result getAllWithPages(int pageNo, int pageSize);

    Result getAllSorted();
    Result add(Product product);

    Result getOne(int id);

    Result getByProductName(String productName);

    Result getByProductNameAndCategoryId(String productName, int categoryId);

    Result getByProductNameOrCategoryId(String productName, int categoryId);

    Result getByCategoryIdIn(List<Integer> categories);

    Result getByProductNameContains(String productName);

    Result getByProductNameStartsWith(String productName);

    Result fetchByNameAndCategory(String productName, int categoryId);

    Result getProductWithCategoryDetails();
}
