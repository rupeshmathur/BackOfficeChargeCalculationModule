package com.example.BODerivativesDummy.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BODerivativesDummy.Entities.CommissionInstruction;
import com.example.BODerivativesDummy.Entities.EventRule;
import com.example.BODerivativesDummy.Entities.Trade;
import com.example.BODerivativesDummy.POJO.Charge;
import com.example.BODerivativesDummy.POJO.Commission;
import com.example.BODerivativesDummy.POJO.Fee;
import com.example.BODerivativesDummy.Service.EventRuleService;
import com.example.BODerivativesDummy.Service.TradeService;

@RestController
@RequestMapping("/tradeApplication")
public class TradeController {

	TradeService tradeService;
	EventRuleService eventRuleService;

	@Autowired
	public TradeController(TradeService tradeService, EventRuleService eventRuleService) {
		this.eventRuleService = eventRuleService;
		this.tradeService = tradeService;
	}

	@PostMapping("/trade")
	public List<Charge> insertTrade(@RequestBody Trade trade) {
		List<Charge> charges = new ArrayList<Charge>();
		List<EventRule> allRules = (List<EventRule>) eventRuleService.findAllEventRules();
		List<EventRule> filteredEventRule = allRules.stream()
				.filter(er -> er.getExchangeName().equals(trade.getExchangeName())
						&& trade.getTradeDate().compareTo(er.getChargeRateInstruction().getChargeStartDate()) > 0
						&& trade.getTradeDate().compareTo(er.getChargeRateInstruction().getChargeEndDate()) < 0)
				.collect(Collectors.toList());

		if (!filteredEventRule.isEmpty()) {
			for (EventRule er : filteredEventRule) {
				if (er.getChargeRateInstruction() instanceof CommissionInstruction) {
					Charge comm = new Commission();
					Charge calculatedCommission = (Commission) comm.processCharge(trade, er);
					charges.add(calculatedCommission);
				} else {
					Charge fee = new Fee();
					Charge calculatedFee = (Fee) fee.processCharge(trade, er);
					charges.add(calculatedFee);
				}
			}
		}
		tradeService.saveTrade(trade);
		if (charges.isEmpty()) {
			System.out.println("No satisfied rules found for charge calculation");
			return Collections.EMPTY_LIST;
		}
		return charges;

	}

	@GetMapping("/getTrade/{id}")
	public void getTrade(@PathParam(value = "id") long id) {
		tradeService.findTrade(id);
	}
}
