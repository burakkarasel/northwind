package com.demo.northwind.business.concretes;

import com.demo.northwind.business.abstracts.ProductService;
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
    public List<Product> getAll(){

        return this.productDao.findAll();
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}
