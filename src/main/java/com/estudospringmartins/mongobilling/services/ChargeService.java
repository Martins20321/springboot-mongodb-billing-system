package com.estudospringmartins.mongobilling.services;

import com.estudospringmartins.mongobilling.Repository.ChargeRepository;
import com.estudospringmartins.mongobilling.domain.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChargeService {

    @Autowired
    private ChargeRepository repository;

    public List<Charge> findAll(){
        return repository.findAll();
    }

    public Charge findById(String id){
        Optional<Charge> obj = repository.findById(id);
        return obj.get();
    }

    public Charge insert(Charge obj){
        return repository.save(obj);
    }

    //Uma cobrança não é apagada, ou seja, não possuíra delete

    public Charge update(Charge obj){
        Charge newCharge = findById(obj.getId());
        UpdateData(newCharge, obj);
        return repository.save(newCharge);
    }

    private void UpdateData(Charge newCharge, Charge obj) {
        newCharge.setDescription(obj.getDescription());
        newCharge.setDueDate(obj.getDueDate());
        newCharge.setAmount(obj.getAmount());
    }
}
