package com.onk.group3.models;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by Magnus on 18/04/2016.
 */

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String address;
    private String email;

    /*private Long cart;
    private Long country;
    private List<Long> orders;
    private List<Long> invoices;
    private List<Long> tickets;*/

    public Customer(){}

    public Customer(String name, String address, String email){
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String getEmail(){
        return email;
    }
}
