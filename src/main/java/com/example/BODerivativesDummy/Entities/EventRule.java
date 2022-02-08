package com.example.BODerivativesDummy.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EVENT_RULE")
public class EventRule {

	@Id
	@Column(name = "EVENT_RULE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "EXCHANGE")
	private String exchangeName;
	@Embedded
	@OneToOne(cascade = CascadeType.ALL)
	private ChargeRateInstruction chargeRateInstruction;

	public EventRule() {
		super();
	}

	public EventRule(long id, String exchangeName) {
		super();
		this.exchangeName = exchangeName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	public ChargeRateInstruction getChargeRateInstruction() {
		return chargeRateInstruction;
	}

	public void setChargeRateInstruction(ChargeRateInstruction chargeRateInstruction) {
		this.chargeRateInstruction = chargeRateInstruction;
	}

}
