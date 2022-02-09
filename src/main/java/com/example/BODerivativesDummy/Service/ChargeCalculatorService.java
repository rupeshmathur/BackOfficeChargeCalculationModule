package com.example.BODerivativesDummy.Service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.example.BODerivativesDummy.Entities.Commission;
import com.example.BODerivativesDummy.Entities.CommissionInstruction;
import com.example.BODerivativesDummy.Entities.EventRule;
import com.example.BODerivativesDummy.Entities.Trade;
import com.example.BODerivativesDummy.Enums.ChargeRealizationStatus;

@Service
public class ChargeCalculatorService {

	private Object calculateCharge(Trade trade, EventRule eventRule) {
		CommissionInstruction commInstr = (CommissionInstruction) eventRule.getChargeRateInstruction();
		BigDecimal rate = ((CommissionInstruction) commInstr).getCommissionRate();
		BigDecimal chargeAmount = trade.getQuantity().multiply(rate);
		return new Commission(chargeAmount, ChargeRealizationStatus.CHARGED);
	}
}
