package com.example.BODerivativesDummy.POJO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.example.BODerivativesDummy.Entities.Commission;
import com.example.BODerivativesDummy.Entities.EventRule;
import com.example.BODerivativesDummy.Entities.Fee;
import com.example.BODerivativesDummy.Entities.Trade;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "CHARGE_TYPE")
@JsonSubTypes({ @Type(value = Commission.class, name = "COMMISSIONS"), @Type(value = Fee.class, name = "FEES") })
public abstract class Charge<T> {

	@Id
	@Column(name = "CHARGE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long charge_id;
	@OneToOne
	private EventRule eventRule;
	@OneToOne
	private Trade trade;

	public Charge() {
		super();
	}

	public long getCharge_id() {
		return charge_id;
	}

	public void setCharge_id(long charge_id) {
		this.charge_id = charge_id;
	}

	public EventRule getEventRule() {
		return eventRule;
	}

	public void setEventRule(EventRule eventRule) {
		this.eventRule = eventRule;
	}

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

	public abstract T processCharge(Trade trade, EventRule eventRule);

}
