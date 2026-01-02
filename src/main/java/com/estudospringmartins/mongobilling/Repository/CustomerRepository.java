package com.estudospringmartins.mongobilling.Repository;

import com.estudospringmartins.mongobilling.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    public List<Customer> findByTitleContaingIgnoreCase(String text);
}
