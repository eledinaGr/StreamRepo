package com.scytalys.products;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ProductRepository {

    private ConcurrentHashMap<Integer, Product> products = new ConcurrentHashMap<Integer, Product>();


    public void add(Product product, int id){
        products.put(id, product);
    }

    public List<Product> getProducts(){
        return new ArrayList<Product> (products.values());
}


    public Product create(int id, String name, ProductCategory category){

        Product product = null;
        switch (category){
            case DAIRY_PRODUCT:
                product = new DairyProduct();
                product.setId(id);
                product.setName(name);
                break;
            case FRAGILE_PRODUCT:
                product = new FragileProduct();
                break;
            default:
                System.out.println("Invalid category");


        }
        return product;
    }




}
