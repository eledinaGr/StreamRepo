package com.scytalys.streams;

import com.github.javafaker.Faker;
import com.scytalys.model.Customer;
import com.scytalys.model.CustomerCategory;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class CustomerStreamRepository {
    private List<Customer> customers = new ArrayList<>();
    Faker faker = new Faker();
    public CustomerCategory randomCategory(){

        int random = faker.number().numberBetween(0, CustomerCategory.values().length);
        return CustomerCategory.values()[random];
    }

    public void fillCustomerListWithData(){
        for (int i=0; i<100; i++){
            Customer customer = new Customer();
            customer.setId(i);
            customer.setFirstName(faker.name().firstName());
            customer.setLastName((faker.name().lastName()));
            customer.setRegistrationDate(faker.date().birthday().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate());
            customer.setCategory(randomCategory());
            customer.setBalance(faker.number().randomDouble(2,0,5000));
            customer.setEmailAddress(faker.internet().emailAddress());
            customers.add(customer);
        }
    }


    public void printList(){
        customers.forEach(System.out::println);
    }

    public void sortCustomers(){
        customers = customers.stream()
                .sorted(Comparator.comparingDouble(Customer::getBalance))
                        .collect(Collectors.toList());

    // OR WITH MODIFICATION OF EXISTING LIST (FOR MUTABLE LIST)
//        customers.sort(Comparator.comparing(Customer::getBalance));

    }

    public List<Customer> getCustomersAbovePriceLevel (double priceLevel){
        return customers.stream()
                .filter(customer -> customer.getBalance() > priceLevel)
                .collect(Collectors.toList());
    }

    public List<Customer> getNewCustomers (LocalDate date){
        return customers.stream()
                .filter(customer -> customer.getRegistrationDate().isAfter(date))
                .collect(Collectors.toList());
    }

    public List<Customer> printCustomersWithCertainCategory (CustomerCategory customerCategory){
        return customers.stream()
                .filter(customer -> customer.getCategory() == customerCategory)
                .collect(Collectors.toList());
    }

    public long countCustomersWithCertainCategory (CustomerCategory customerCategory){
        return customers.stream()
                .filter(customer -> customer.getCategory()== customerCategory)
                .count();
    }

    public boolean existsCustomerWithName (String name){
        return customers.stream()
                .anyMatch(product-> product.getFirstName().equals(name));
    }


    public Map<CustomerCategory, List<Customer>> createGroupsPerCategory() {
        return customers.stream()
                .collect(Collectors.groupingBy(Customer::getCategory));
    }







}
