package com.demo.northwind.dataAccess.abstracts;

import com.demo.northwind.entities.concretes.Product;
import com.demo.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer>{
    Product getByProductName(String productName);

    Product getByProductNameAndCategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategoryId(String productName, int categoryId);

    List<Product> getByCategoryIdIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    @Query("from Product where productName=:productName and category.id=:categoryId")
    List<Product> fetchByNameAndCategory(String productName, int categoryId);

    @Query("select new com.demo.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) from Category c inner join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
 }
