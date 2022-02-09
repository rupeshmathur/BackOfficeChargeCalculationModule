package com.example.BODerivativesDummy.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

	public List<EventRule> deleteEventRule(Long id) {
		TypedQuery<EventRule> query 
	      = entityManager.createQuery(
	          "SELECT * FROM COMMISSION T1,EVENT_RULE T2 \r\n" + 
	          "WHERE T1.EVENT_RULE_EVENT_RULE_ID = T2.EVENT_RULE_ID", EventRule.class);
		return query.getResultList();
	}

	public Iterable<EventRule> findAllEventRules() {
		return eventRepo.findAll();
	}
}
