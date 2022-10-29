package com.demo.northwind.entities.concretes;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "unit_price")
    private double unitPrice;
    @Column(name = "units_in_stock")
    private short unitsInStock;
    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public Product(){}

    public Product(int _id, String _productName, double _unitPrice, short _unitsInStock, String _quantityPerUnit, Category _category){
        this.setId(_id);
        this.setCategory(_category);
        this.setProductName(_productName);
        this.setUnitPrice(_unitPrice);
        this.setUnitsInStock(_unitsInStock);
        this.setQuantityPerUnit(_quantityPerUnit);
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public short getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(short unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
