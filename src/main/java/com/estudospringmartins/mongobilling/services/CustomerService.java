package com.estudospringmartins.mongobilling.services;

import com.estudospringmartins.mongobilling.Repository.CustomerRepository;
import com.estudospringmartins.mongobilling.domain.Customer;
import com.estudospringmartins.mongobilling.dto.CustomerDTO;
import com.estudospringmartins.mongobilling.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public List<Customer> findAll(){
        return repository.findAll();
    }

    public Customer findById(String id){
        Optional<Customer> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not Found"));
    }

    public Customer insert(Customer obj){
        return repository.save(obj);
    }

    public Customer fromDTO(CustomerDTO customerDTO){
        return new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getEmail(), customerDTO.getDocument());
    }
}
