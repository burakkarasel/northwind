package com.demo.northwind.business.concretes;

import com.demo.northwind.business.abstracts.ProductService;
import com.demo.northwind.core.utilities.results.Result;
import com.demo.northwind.core.utilities.results.SuccessDataResult;
import com.demo.northwind.core.utilities.results.SuccessResult;
import com.demo.northwind.dataAccess.abstracts.ProductDao;
import com.demo.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("New product created");
    }

    @Override
    public Result getOne(int id) {
        return new SuccessDataResult<>(this.productDao.findById(id), "Got product");
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}
