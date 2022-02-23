package com.example.BODerivativesDummy.Validator;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.example.BODerivativesDummy.Entities.Trade;

@Component
public class TradeQtyPriceValidator {

	
	public static boolean validateTradeQtyAndPrice(Trade trade) {

		System.out.println("Inside Trade Date Validator");
		if (trade.getQuantity().compareTo(BigDecimal.ZERO) == -1
				|| trade.getPrice().compareTo(BigDecimal.ZERO) == -1) {
			return false;
		}
		return true;
	}
}
