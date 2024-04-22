package com.scytalys.model;


import lombok.Data;

import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ProductSupplier {

    private int id;
    private String name;
    private String description;
    private Product product;



}
