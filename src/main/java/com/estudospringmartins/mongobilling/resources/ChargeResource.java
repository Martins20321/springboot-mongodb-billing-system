package com.estudospringmartins.mongobilling.resources;

import com.estudospringmartins.mongobilling.domain.Charge;
import com.estudospringmartins.mongobilling.services.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/charges")
public class ChargeResource {

    @Autowired
    private ChargeService service;

    @GetMapping
    public ResponseEntity<List<Charge>> finAll(){
        List<Charge> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Charge> findById(@PathVariable String id){
        Charge obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
