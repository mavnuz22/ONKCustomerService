package com.onk.group3.controller;

/**
 * Created by Magnus on 18/04/2016.
 */

import com.onk.group3.models.Customer;
import com.onk.group3.repositories.Customer1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    @Autowired
    private Customer1Repository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Customer>> getAllCustomers(){
        return new ResponseEntity<>((Collection<Customer>) repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Customer> getPieWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"name"})
    public ResponseEntity<Collection<Customer>> findPieWithName(@RequestParam(value="name") String name) {
        return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"email"})
    public ResponseEntity<Collection<Customer>> findPieWithEmail(@RequestParam(value="email") String email) {
        return new ResponseEntity<>(repository.findByEmail(email), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addCustomer(@RequestBody Customer input) {
        return new ResponseEntity<>(repository.save(input), HttpStatus.CREATED);
    }
}
