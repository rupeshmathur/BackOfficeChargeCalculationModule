package com.example.BODerivativesDummy.Validator;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.example.BODerivativesDummy.Entities.ChargeRateInstruction;
import com.example.BODerivativesDummy.Entities.Trade;

@Component
public class DateValidator {

	public static boolean validateERDates(ChargeRateInstruction chargeRateInstruction) {

		System.out.println("Inside ER dates Validator");
		if(chargeRateInstruction.getChargeEndDate().compareTo(chargeRateInstruction.getChargeStartDate()) < 0) {
			return false;
		}
		return true;
	}
	
}
