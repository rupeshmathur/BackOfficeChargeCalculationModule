package com.example.BODerivativesDummy.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BODerivativesDummy.Entities.CommissionInstruction;
import com.example.BODerivativesDummy.Entities.EventRule;
import com.example.BODerivativesDummy.Entities.Trade;
import com.example.BODerivativesDummy.POJO.Charge;
import com.example.BODerivativesDummy.POJO.Commission;
import com.example.BODerivativesDummy.POJO.Fee;

@Service
public class ChargeCalculationServiceImpl extends ChargeCalculationService {

	EventRuleService eventRuleService;

	@Autowired
	public ChargeCalculationServiceImpl(EventRuleService eventRuleService) {
		super();
		this.eventRuleService = eventRuleService;
	}

	@Override
	public List<Charge> calculateCharge(Trade trade, List<Charge> charges) {
		List<EventRule> allRules = (List<EventRule>) eventRuleService.findAllEventRules();
		List<EventRule> filteredEventRule = allRules.stream()
				.filter(er -> er.getExchangeName().equals(trade.getExchangeName())
						&& trade.getTradeDate().compareTo(er.getChargeRateInstruction().getChargeStartDate()) > 0
						&& trade.getTradeDate().compareTo(er.getChargeRateInstruction().getChargeEndDate()) < 0)
				.collect(Collectors.toList());

		if (!filteredEventRule.isEmpty()) {
			Charge newCharge = null;
			for (EventRule er : filteredEventRule) {
				if (er.getChargeRateInstruction() instanceof CommissionInstruction) {
					newCharge = new Commission();
					Charge calculatedCommission = (Commission) newCharge.processCharge(trade, er);
					charges.add(calculatedCommission);
				} else {
					newCharge = new Fee();
					Charge calculatedFee = (Fee) newCharge.processCharge(trade, er);
					charges.add(calculatedFee);
				}
			}
		}
		return charges;
	}

}