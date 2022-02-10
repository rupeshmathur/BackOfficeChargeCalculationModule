package com.example.BODerivativesDummy.Service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BODerivativesDummy.Entities.EventRule;
import com.example.BODerivativesDummy.Repository.EventRuleRepo;

@Service
public class EventRuleService {

	@Autowired
	EventRuleRepo eventRepo;

	@Autowired
	EntityManager entityManager;

	public void insertEventRule(EventRule eventRule) {
		eventRepo.save(eventRule);
	}

	public List<EventRule> checkERInUse(Long id) {
		return eventRepo.findAllRulesInUse();
	}

	public Iterable<EventRule> findAllEventRules() {
		return eventRepo.findAll();
	}

	public void deleteEventRule(Long id) {
		eventRepo.deleteById(id);
	}
}
