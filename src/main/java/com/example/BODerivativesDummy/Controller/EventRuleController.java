package com.example.BODerivativesDummy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BODerivativesDummy.Entities.CommissionInstruction;
import com.example.BODerivativesDummy.Entities.EventRule;
import com.example.BODerivativesDummy.Entities.FeeInstruction;
import com.example.BODerivativesDummy.Exceptions.DateInvalidException;
import com.example.BODerivativesDummy.Service.ChargeRateInstructionService;
import com.example.BODerivativesDummy.Service.EventRuleService;
import com.example.BODerivativesDummy.Validator.DateValidator;

@RestController
@RequestMapping("/tradeApplication")
public class EventRuleController {

	@Autowired
	EventRuleService eventRuleService;

	@Autowired
	ChargeRateInstructionService chargeInstrService;

	@PostMapping(value = "/eventRule")
	public void createEventRule(@RequestBody List<EventRule> eventRules) {

		for (EventRule er : eventRules) {
			if (er.getChargeRateInstruction() instanceof CommissionInstruction) {
				CommissionInstruction commissionInstruction = (CommissionInstruction) er.getChargeRateInstruction();
				if(!DateValidator.validateDates(commissionInstruction)) {
					throw new DateInvalidException();
				}
				chargeInstrService.saveChargeRateInstructions(commissionInstruction);

			} else {
				FeeInstruction feeInstruction = (FeeInstruction) er.getChargeRateInstruction();
				if(!DateValidator.validateDates(feeInstruction)) {
					throw new DateInvalidException();
				}
				chargeInstrService.saveChargeRateInstructions(feeInstruction);
			}
			eventRuleService.insertEventRule(er);
		}

	}

	@DeleteMapping(value = "/deleteER/{id}")
	public void deleteEventRule(@PathVariable Long id) {
		eventRuleService.deleteEventRule(id);

	}

}
