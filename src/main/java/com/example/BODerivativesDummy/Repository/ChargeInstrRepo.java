package com.example.BODerivativesDummy.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BODerivativesDummy.Entities.ChargeRateInstruction;

@Repository
public interface ChargeInstrRepo extends CrudRepository<ChargeRateInstruction, Long> {

}
