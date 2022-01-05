package com.example.BODerivativesDummy.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BODerivativesDummy.Entities.EventRule;
@Repository
public interface EventRuleRepo extends CrudRepository<EventRule, Long> {

}
