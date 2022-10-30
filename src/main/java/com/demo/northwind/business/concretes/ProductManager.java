package com.demo.northwind.business.concretes;

import com.demo.northwind.business.abstracts.ProductService;
import com.demo.northwind.core.utilities.results.Result;
import com.demo.northwind.core.utilities.results.SuccessDataResult;
import com.demo.northwind.core.utilities.results.SuccessResult;
import com.demo.northwind.dataAccess.abstracts.ProductDao;
import com.demo.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {
    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao _productDao){
        super();
        this.setProductDao(_productDao);
    }

    @Override
    public Result getAll(){
        return new SuccessDataResult<>(this.productDao.findAll(), "Data listed");
    }

    @Override
    public Result getAllWithPages(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<>(this.productDao.findAll(pageable).getContent(), "Got related data");
    }

    @Override
    public Result getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "unitPrice");
        return new SuccessDataResult<>(this.productDao.findAll(sort), "Got related data");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("New product created");
    }

    @Override
    public Result getOne(int id) {
        return new SuccessDataResult<>(this.productDao.findById(id), "Got product");
    }

    @Override
    public Result getByProductName(String productName) {
        return new SuccessDataResult<>(this.productDao.getByProductName(productName), "Got related products");
    }

    @Override
    public Result getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>(this.productDao.getByProductNameAndCategoryId(productName, categoryId), "Got related products");
    }

    @Override
    public Result getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>(this.productDao.getByProductNameOrCategoryId(productName, categoryId), "Got related products");
    }

    @Override
    public Result getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<>(this.productDao.getByCategoryIdIn(categories), "Got related products");
    }

    @Override
    public Result getByProductNameContains(String productName) {
        return new SuccessDataResult<>(this.productDao.getByProductNameContains(productName), "Got related products");
    }

    @Override
    public Result getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<>(this.productDao.getByProductNameStartsWith(productName), "Got related products");
    }

    @Override
    public Result fetchByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<>(this.productDao.fetchByNameAndCategory(productName, categoryId), "Got related products");
    }

    @Override
    public Result getProductWithCategoryDetails(){
        return new SuccessDataResult<>(this.productDao.getProductWithCategoryDetails(), "Got related products");
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}
