package com.example.BODerivativesDummy.Entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.BODerivativesDummy.Entities.EventRule;
import com.example.BODerivativesDummy.Entities.FeeInstruction;
import com.example.BODerivativesDummy.Entities.Trade;
import com.example.BODerivativesDummy.Enums.ChargeRealizationStatus;
import com.example.BODerivativesDummy.POJO.Charge;

@Entity
@DiscriminatorValue("FEES")
public class Fee extends Charge implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	@Enumerated(EnumType.STRING)
	private ChargeRealizationStatus chargeRealizationStatus;

	public Fee() {
		super();
	}

	public Fee(BigDecimal amount, ChargeRealizationStatus chargeRealizationStatus) {
		super();
		this.amount = amount;
		this.chargeRealizationStatus = chargeRealizationStatus;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public ChargeRealizationStatus getChargeRealizationStatus() {
		return chargeRealizationStatus;
	}

	public void setChargeRealizationStatus(ChargeRealizationStatus chargeRealizationStatus) {
		this.chargeRealizationStatus = chargeRealizationStatus;
	}

	@Override
	public Object processCharge(Trade trade, EventRule eventRule) {

		BigDecimal chargeAmount = super.calculateChargeAmount(trade, eventRule);
		return new Fee(chargeAmount, ChargeRealizationStatus.CHARGED);
	}

}
