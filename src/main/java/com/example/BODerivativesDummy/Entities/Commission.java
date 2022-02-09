package com.example.BODerivativesDummy.Entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.example.BODerivativesDummy.Entities.CommissionInstruction;
import com.example.BODerivativesDummy.Entities.EventRule;
import com.example.BODerivativesDummy.Entities.Trade;
import com.example.BODerivativesDummy.Enums.ChargeRealizationStatus;
import com.example.BODerivativesDummy.POJO.Charge;

@Entity
@DiscriminatorValue("COMMISSIONS")
public class Commission extends Charge  implements Serializable{

	@Column(name = "AMOUNT")
	private BigDecimal amount;
	@Enumerated(EnumType.STRING)
	private ChargeRealizationStatus chargeRealizationStatus;

	public Commission() {
		super();
	}

	public Commission(BigDecimal amount, ChargeRealizationStatus chargeRealizationStatus) {
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
		return calculateCharge(trade, eventRule);
	}

	private Object calculateCharge(Trade trade, EventRule eventRule) {
		CommissionInstruction commInstr = (CommissionInstruction) eventRule.getChargeRateInstruction();
		BigDecimal rate = ((CommissionInstruction) commInstr).getCommissionRate();
		BigDecimal chargeAmount = trade.getQuantity().multiply(rate);
		return new Commission(chargeAmount, ChargeRealizationStatus.CHARGED);
	}

}
