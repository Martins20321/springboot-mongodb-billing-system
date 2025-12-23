package com.estudospringmartins.mongobilling.resources;

import com.estudospringmartins.mongobilling.domain.Customer;
import com.estudospringmartins.mongobilling.dto.CustomerDTO;
import com.estudospringmartins.mongobilling.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable String id){
        Customer obj = service.findById(id);
        return ResponseEntity.ok().body(new CustomerDTO(obj));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CustomerDTO objDTO){
        Customer customer = service.fromDTO(objDTO);
        customer = service.insert(customer);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody CustomerDTO objDTO){
        Customer obj = service.fromDTO(objDTO);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }
}
