package com.scytalys.model;

import lombok.Data;


import java.time.LocalDate;

@Data

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate registrationDate;
    private CustomerCategory category;
    private double balance;
    private String emailAddress;

}
