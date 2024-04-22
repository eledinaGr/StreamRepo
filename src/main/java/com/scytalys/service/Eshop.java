package com.scytalys.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scytalys.model.Product;
import com.scytalys.model.ProductSupplier;

import java.util.Arrays;


public class Eshop {
    public static void main(String[] args) {
        ProductSupplier supplier = ProductSupplier
                .builder()
                .id(10)
                .name("Emporica")
                .build();
        Product product = Product
                .builder()
                .id(2)
                .price(12)
                .quantity(5)
                .name("chips")
                .build();

//        product.setProductSupplier(supplier);
        supplier.setProduct(product);
        System.out.println(product);


        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            // convert user object to json string and return it
            json = mapper.writeValueAsString(product);
        }
        catch (JsonProcessingException e) {
           e.printStackTrace();
        }
        System.out.println(json);



        /////////////////////////////////////////////////////
//        DESEERIALIZATION OF STREAM JSON TO OBJECT


        String productJson =
                """
                [{
                    "id":2,
                    "name":"chips",
                    "price":12.0,
                    "quantity":5
                },
                {
                    "id":22,
                    "name":"chocolate",
                    "price":13.0,
                    "quantity":15
                }
                ]
                """;


        Product [] product1 = null;
        try {
            // Deserializing the JSON array into an array of
            // Course objects
           product1 = mapper.readValue(productJson, Product[].class);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Arrays.stream(product1).forEach(System.out::println);



    }


}
