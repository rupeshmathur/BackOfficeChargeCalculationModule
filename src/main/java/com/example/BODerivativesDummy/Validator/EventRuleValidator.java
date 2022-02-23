package com.example.BODerivativesDummy.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.BODerivativesDummy.Service.EventRuleService;

@Component
public class EventRuleValidator {

	@Autowired
	static EventRuleService eventRuleService;
	
	public EventRuleValidator(EventRuleService eventRuleService) {
		super();
		this.eventRuleService = eventRuleService;
	}

	public static boolean validateERInUse(Long id) {
		if(eventRuleService.checkERInUse(id).isEmpty()) {
			return true;
		}
		return false;
	}
}
