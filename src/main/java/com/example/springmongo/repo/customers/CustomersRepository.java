package com.example.springmongo.repo.customers;

import com.example.springmongo.model.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends MongoRepository<Customer, Integer> {
}
