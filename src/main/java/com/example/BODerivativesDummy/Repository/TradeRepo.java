package com.example.BODerivativesDummy.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BODerivativesDummy.Entities.Trade;

@Repository
public interface TradeRepo extends CrudRepository<Trade,Long>{

}
