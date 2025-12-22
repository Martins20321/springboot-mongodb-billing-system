package com.estudospringmartins.mongobilling.services;

import com.estudospringmartins.mongobilling.Repository.CustomerRepository;
import com.estudospringmartins.mongobilling.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public List<Customer> findAll(){
        return repository.findAll();
    }

}
