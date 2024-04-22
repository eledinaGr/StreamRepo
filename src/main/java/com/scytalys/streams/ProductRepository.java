package com.scytalys.streams;

import com.github.javafaker.Faker;
import com.scytalys.model.Product;

import java.util.*;
import java.util.stream.Collectors;


public class ProductRepository {
    private  List<Product> products = new ArrayList<>();


    public void fillListWithData() {
        Faker faker = new Faker();

        for (int i = 0; i < 100; i++) {
            // Generate fake data
            Product product = new Product();
            product.setId(i);
            product.setName(faker.commerce().productName());
            product.setPrice(faker.number().randomDouble(2, 1, 1000));
            product.setDescription(faker.lorem().sentence());
            product.setQuantity(faker.number().numberBetween(1, 5));
            products.add(product);

        }
    }

    public void printList(){
        products.forEach(System.out::println);
    }


    public void sortProducts(){
        // den epireazei tin arxiki lista, dimiourgei nea taxinomimeni,
        // idaniko gia lista pou einai immutable kai den boreis na tin peirakseis


        //creates new list, used when initial list is immutable


//        products = products.stream()
//                .sorted(Comparator.comparingDouble(Product::getPrice))
//                .collect(Collectors.toList());

        // reversed sorted list

        products = products.stream()
                .sorted(Comparator.comparingInt(Product::getQuantity)
                .thenComparing(Comparator.comparingDouble(Product::getPrice).reversed()))
                .collect(Collectors.toList());


        // mutates the list (reversed sorted list)
        products.sort(Comparator
                .comparing(Product::getPrice).reversed()
                .thenComparing(Product::getName));


        // gia reverse taksinomisi
//        products = products.stream()
//                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
//                .collect(Collectors.toList());


        // epireazei tin iparxousa lista auti i methodos, einai gia mutable lista
//        Collections.sort(products, Comparator.comparingDouble(Product::getPrice));


    }

    // 5 basic operations in a List
    //CRUD: create, read(eite oli ti lista eite ena sigekrimeno stoixeio), update, delete

    // 7 analytic operations in a List
    //Sorting, Filtering, Mapping, Reducing (min, max, average, sum, count, stdev - tipiki apoklisi, concatenation) , Matching, Counting

    public List<Product> getProductsAbovePriveLevel(double priceLevel){

        //i lista products paramenei anepireasti
        return products.stream()
                .filter(product -> product.getPrice() > priceLevel)
                .collect(Collectors.toList());
    }

    public List<Product> getProductsStartsWith(String starting){
        return products.stream()
                .filter(product -> product.getName() !=null)
                .filter(product -> product.getName().startsWith(starting))
                .collect(Collectors.toList());
    }

    public List<String> getProductDescriptions(){
        return products.stream()
                .map(product -> product.getDescription())
                .collect(Collectors.toList());
    }


    public double getAveragePrice(){
//        return products.stream()
//                .map(product -> product.getPrice())
//                        .reduce(0.0, Double::sum)/ products.size();

        return products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0);

    }

    public long countProductsAbovePriceLevel(double priceLevel){
        return products.stream()
                .filter(product -> product.getPrice() > priceLevel)
                .count();
    }

    public boolean existsProductWithName(String name){
        return products.stream()
                .anyMatch(p -> p.getName().equals(name));
    }

    public Map<Integer, List<Product>> createGroupsPerQuantity(){
        return products.stream()
                .collect(Collectors.groupingBy(Product::getQuantity));
    }


}