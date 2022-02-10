package com.example.BODerivativesDummy.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BODerivativesDummy.POJO.Charge;

@Repository
public interface ChargeCalculationRepo extends CrudRepository<Charge, Long>{

}
