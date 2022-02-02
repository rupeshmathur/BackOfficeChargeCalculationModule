package com.example.BODerivativesDummy.Validator;

import org.springframework.stereotype.Component;

import com.example.BODerivativesDummy.Entities.ChargeRateInstruction;

@Component
public class DateValidator {

	public static boolean validateDates(ChargeRateInstruction chargeRateInstruction) {

		System.out.println("Inside Validator");
		if(chargeRateInstruction.getChargeEndDate().compareTo(chargeRateInstruction.getChargeStartDate()) < 0) {
			return false;
		}
		return true;
	}
}
