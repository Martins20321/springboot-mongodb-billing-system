package com.estudospringmartins.mongobilling.resources;

import com.estudospringmartins.mongobilling.domain.Customer;
import com.estudospringmartins.mongobilling.dto.CustomerDTO;
import com.estudospringmartins.mongobilling.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

    @Autowired
    CustomerService service;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll(){
        List<Customer> list = service.findAll();
        List<CustomerDTO> listDTO = list.stream().map(x -> new CustomerDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}
