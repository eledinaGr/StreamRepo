package com.scytalys.streams;

import com.scytalys.model.Product;


import java.util.List;
import java.util.Map;

public class FakeDataGenerator {

    public static void main(String[] args) {

       ProductRepository productRepository = new ProductRepository();
       productRepository.fillListWithData();
//       productRepository.printList();
       System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
       productRepository.sortProducts();
       productRepository.printList();

       List<Product> products = productRepository.getProductsStartsWith("A");
       products.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
       List<String> descriptionList = productRepository.getProductDescriptions();
       descriptionList.forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("products above 200 euros = "+ productRepository.countProductsAbovePriceLevel(200));

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("exist products with name chips " + productRepository.existsProductWithName("chips"));

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
        Map<Integer, List<Product>> map = productRepository.createGroupsPerQuantity();
        map.forEach((quantity, group) ->{
            System.out.println("Quantity = " + quantity);
            System.out.println("**************************************************************************************************************************************************");
            group.forEach(System.out::println);
        });

    }

}
