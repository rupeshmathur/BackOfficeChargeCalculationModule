package com.example.BODerivativesDummy.Controller;

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
import com.example.BODerivativesDummy.Validator.DateValidator;

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
	public List<Charge> insertTrade(@RequestBody List<Trade> trades) {
		if (trades.isEmpty()) {
			return Collections.EMPTY_LIST;
		}
		List<Charge> charges = new ArrayList<Charge>();
		for (Trade trade : trades) {
			if (!DateValidator.validateTradeDates(trade)) {
				throw new QuantityOrPriceException();
			}

			charges = chargeCalServiceImpl.calculateCharge(trade, charges);
			tradeService.saveTrade(trade);
			chargeCalServiceImpl.saveCharges(charges);
			
			if (charges.isEmpty()) {
				System.out.println("No satisfied rules found for charge calculation");
				return Collections.EMPTY_LIST;
			}

		}
		return charges;
	}

	@GetMapping("/trades/{id}")
	public Optional<Trade> getTrade(@PathVariable(value = "id") Long id) {
		return tradeService.findTrade(id);
	}
}
