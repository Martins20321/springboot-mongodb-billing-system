package com.estudospringmartins.mongobilling.resources;

import com.estudospringmartins.mongobilling.domain.Charge;
import com.estudospringmartins.mongobilling.services.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Charge> insert(@RequestBody Charge obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
