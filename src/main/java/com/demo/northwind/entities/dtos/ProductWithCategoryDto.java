package com.demo.northwind.entities.dtos;


public class ProductWithCategoryDto {
    private int id;
    private String productName;
    private String categoryName;

    public ProductWithCategoryDto(){

    }

    public ProductWithCategoryDto(int _id, String _productName, String _categoryName){
        this.setId(_id);
        this.setCategoryName(_categoryName);
        this.setProductName(_productName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
