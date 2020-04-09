package com.codeorange.api.management.customerservice.service;

import com.codeorange.api.management.customerservice.bean.Customer;
import com.codeorange.api.management.customerservice.bean.CustomerMetadata;

import java.util.List;

public interface ICustomerService {

    List<Customer> getAll();
    Customer create(Customer customer);
    CustomerMetadata getMetadata();

}
