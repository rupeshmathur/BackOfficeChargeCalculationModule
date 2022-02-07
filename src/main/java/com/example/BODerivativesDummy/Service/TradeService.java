package com.example.BODerivativesDummy.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BODerivativesDummy.Entities.Trade;
import com.example.BODerivativesDummy.Repository.TradeRepo;

@Service
public class TradeService {

	@Autowired
	TradeRepo tradeRepo;

	public void saveTrade(Trade trade) {
		tradeRepo.save(trade);
	}

	public Optional<Trade> findTrade(Long id) {
		return tradeRepo.findById(id);
	}

}
