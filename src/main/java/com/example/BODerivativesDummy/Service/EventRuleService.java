package com.example.BODerivativesDummy.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BODerivativesDummy.Entities.EventRule;
import com.example.BODerivativesDummy.Repository.EventRuleRepo;

@Service
public class EventRuleService {

	@Autowired
	EventRuleRepo eventRepo;

	public void insertEventRule(EventRule eventRule) {
		eventRepo.save(eventRule);
	}

	public void deleteEventRule(Long id) {
		eventRepo.deleteById(id);
	}

	public Iterable<EventRule> findAllEventRules() {
		return eventRepo.findAll();
	}
}
