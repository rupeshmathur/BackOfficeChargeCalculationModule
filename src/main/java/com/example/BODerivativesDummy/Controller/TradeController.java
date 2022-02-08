package com.example.BODerivativesDummy.Controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BODerivativesDummy.Entities.Trade;
import com.example.BODerivativesDummy.Exceptions.QuantityOrPriceException;
import com.example.BODerivativesDummy.POJO.Charge;
import com.example.BODerivativesDummy.Service.ChargeCalculationServiceImpl;
import com.example.BODerivativesDummy.Service.TradeService;

@RestController
@RequestMapping("/tradeApplication")
public class TradeController {

	TradeService tradeService;
	ChargeCalculationServiceImpl chargeCalServiceImpl;

	@Autowired
	public TradeController(TradeService tradeService, ChargeCalculationServiceImpl chargeCalServiceImpl) {
		this.tradeService = tradeService;
		this.chargeCalServiceImpl = chargeCalServiceImpl;
	}

	@PostMapping("/trade")
	public List<Charge> insertTrade(@RequestBody Trade trade) {
		if (trade.getQuantity().compareTo(BigDecimal.ZERO) == -1 || trade.getPrice().compareTo(BigDecimal.ZERO) == -1) {
			throw new QuantityOrPriceException();
		}
		List<Charge> charges = new ArrayList<Charge>();
		charges = chargeCalServiceImpl.calculateCharge(trade, charges);
		chargeCalServiceImpl.saveCharges(charges);
		tradeService.saveTrade(trade);
		if (charges.isEmpty()) {
			System.out.println("No satisfied rules found for charge calculation");
			return Collections.EMPTY_LIST;
		}
		return charges;

	}

	@GetMapping("/trades/{id}")
	public Optional<Trade> getTrade(@PathVariable(value = "id") Long id) {
		return tradeService.findTrade(id);
	}
}
