package com.codeorange.api.management.customerservice.controller;

import com.codeorange.api.management.customerservice.bean.Customer;
import com.codeorange.api.management.customerservice.service.ICustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "CustomerController")
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation(value = "Get all customers")
    @GetMapping("")
    public ResponseEntity<?> index() {
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }


    @ApiOperation(value = "Create one customer")
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.create(customer), HttpStatus.CREATED);
    }


    @ApiOperation(value = "Get customer metadata")
    @GetMapping("/metadata")
    public ResponseEntity<?> mean() {
        return new ResponseEntity<>(customerService.getMetadata(), HttpStatus.OK);
    }

}
