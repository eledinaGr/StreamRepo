package com.scytalys.streams;

import com.scytalys.model.Customer;
import com.scytalys.model.CustomerCategory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CustomerStreamMain {
    public static void main(String[] args) {
        CustomerStreamRepository customerStreamRepository = new CustomerStreamRepository();
        customerStreamRepository.fillCustomerListWithData();
        System.out.println("-------------------------- PRINT LIST OF CUSTOMERS -----------------------------------------------------------------------------------------");
        customerStreamRepository.printList();
        System.out.println("---------------------------------------------- PRINT SORTED LIST OF CUSTOMERS ------------------------------------------------------------------------------------------------------");
        customerStreamRepository.sortCustomers();
        customerStreamRepository.printList();
        System.out.println("---------------------------------------------- PRINT LIST OF CUSTOMERS ABOVE PRICE LEVEL -----------------------------------------------------------------------");
       List<Customer> customers = customerStreamRepository.getCustomersAbovePriceLevel(3000);
       customers.forEach(System.out::println);
//        System.out.println("---------------------------------------------- PRINT NEW CUSTOMERS (AFTER YEAR 2000) -------------------------------------------------------");
//        List<Customer> customers = customerStreamRepository.getNewCustomers(LocalDate.of(2000, 4, 21));
//        customers.forEach(System.out::println);
//                System.out.println("---------------------------------------------- PRINT LIST OF CUSTOMERS WITH CERTAIN CATEGORY  -------------------------------------------------------");
//        List<Customer> customers = customerStreamRepository.printCustomersWithCertainCategory(CustomerCategory.RETAIL);
//        customers.forEach(System.out::println);
//        System.out.println("---------------------------------------------- PRINT NUMBER OF CUSTOMERS WITH CERTAIN CATEGORY -----------------------------------------------------------");
//        long customers = customerStreamRepository.countCustomersWithCertainCategory(CustomerCategory.RETAIL);
//        System.out.println(customers);
             System.out.println("---------------------------------------------- DOES A CERTAIN CUSTOMER EXIST? -----------------------------------------------------");
        System.out.println(customerStreamRepository.existsCustomerWithName("Kevin"));

        System.out.println("---------------------------------------------- PRINT EXISTING CUSTOMERS WITH CERTAIN CATEGORY ---------------------------------------------------");
        Map<CustomerCategory, List<Customer>> map = customerStreamRepository.createGroupsPerCategory();
        map.forEach((category, group) -> {
            System.out.println("***************************");
            System.out.println("Category=" + category);
            System.out.println("--------------------");
            group.forEach(System.out::println);
        });
    }
}
