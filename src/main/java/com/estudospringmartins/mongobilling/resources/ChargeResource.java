package com.estudospringmartins.mongobilling.resources;

import com.estudospringmartins.mongobilling.domain.Charge;
import com.estudospringmartins.mongobilling.services.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URLDecoder;
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

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Charge>> findByTitle(@RequestParam(value = "text", defaultValue = "")String text){
        text = URLDecoder.decode(text);
        List<Charge> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);

    }

    @PostMapping
    public ResponseEntity<Charge> insert(@RequestBody Charge obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody Charge obj){
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }
}
