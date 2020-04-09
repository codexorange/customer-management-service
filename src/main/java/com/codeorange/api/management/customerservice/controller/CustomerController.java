package com.codeorange.api.management.customerservice.controller;

import com.codeorange.api.management.customerservice.bean.Customer;
import com.codeorange.api.management.customerservice.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    public ResponseEntity<?> index() {
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.create(customer), HttpStatus.CREATED);
    }

    @GetMapping("/mean")
    public ResponseEntity<?> mean() {
        return new ResponseEntity<>(customerService.getMetadata(), HttpStatus.OK);
    }

}
