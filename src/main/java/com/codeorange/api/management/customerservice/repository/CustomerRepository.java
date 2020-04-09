package com.codeorange.api.management.customerservice.repository;

import com.codeorange.api.management.customerservice.bean.Customer;
import com.github.fabiomaffioletti.firebase.repository.DefaultFirebaseRealtimeDatabaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository extends DefaultFirebaseRealtimeDatabaseRepository<Customer, String> {
}
