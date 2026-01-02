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

    public List<Customer> findByTitle(String text){
        return repository.findByTitleContaingIngonoreCase(text);
    }
    public Customer insert(Customer obj){
        return repository.save(obj);
    }

    public void delete(String id){
        repository.deleteById(id);
    }

    public Customer update(Customer obj){
        Customer entity = findById(obj.getId());
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Customer entity, Customer obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
    }

    public Customer fromDTO(CustomerDTO customerDTO){
        return new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getEmail(), customerDTO.getDocument());
    }
}
