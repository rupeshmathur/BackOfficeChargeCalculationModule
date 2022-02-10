package com.example.BODerivativesDummy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BODerivativesDummy.Entities.EventRule;
@Repository
public interface EventRuleRepo extends CrudRepository<EventRule, Long> {

	@Query(value = "SELECT * FROM COMMISSION T1,EVENT_RULE T2 \r\n" + 
	          "WHERE T1.EVENT_RULE_EVENT_RULE_ID = T2.EVENT_RULE_ID",nativeQuery = true)
	public List<EventRule> findAllRulesInUse();
}
