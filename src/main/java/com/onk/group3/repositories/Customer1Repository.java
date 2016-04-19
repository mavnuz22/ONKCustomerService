package com.onk.group3.repositories;

import com.onk.group3.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Magnus on 18/04/2016.
 */
public interface Customer1Repository extends CrudRepository<Customer, Long> {
    List<Customer> findByName(String name);
    List<Customer> findByEmail(String email);

}
