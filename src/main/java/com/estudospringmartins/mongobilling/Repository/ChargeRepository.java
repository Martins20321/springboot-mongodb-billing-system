package com.estudospringmartins.mongobilling.Repository;

import com.estudospringmartins.mongobilling.domain.Charge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargeRepository extends MongoRepository<Charge, String> {
}
