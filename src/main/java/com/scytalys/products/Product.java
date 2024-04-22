package com.scytalys.products;

import lombok.Data;

@Data
public abstract class Product {

    private int id;
    private String name;
    private double price;
    private ProductCategory category;

}
