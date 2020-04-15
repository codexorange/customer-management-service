package com.codeorange.api.management.customerservice.service;

import com.codeorange.api.management.customerservice.bean.Customer;
import com.codeorange.api.management.customerservice.bean.CustomerMetadata;
import com.codeorange.api.management.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = customerRepository.findAll();
        Collections.sort(customers);
        return customers;
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.push(customer);
    }

    @Override
    public CustomerMetadata getMetadata() {
        List<Customer> customers = customerRepository.findAll();
        List<Integer> ages = customers.stream().map(c -> c.getAge()).sorted().collect(Collectors.toList());

        CustomerMetadata customerMetadata = new CustomerMetadata();
        customerMetadata.setMean(ages.stream().reduce(0, Integer::sum) / ages.size());
        customerMetadata.setTotal(ages.size());
        customerMetadata.setMinAge(ages.get(0));
        customerMetadata.setMaxAge(ages.get(ages.size() - 1));

        double sum = 0;
        for (Integer age : ages) {
            sum += Math.pow(age - customerMetadata.getMean(), 2);
        }
        customerMetadata.setStandardDeviation(Math.sqrt(sum / ages.size()));

        return customerMetadata;
    }


}
