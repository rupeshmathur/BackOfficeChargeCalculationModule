package com.example.BODerivativesDummy.POJO;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.example.BODerivativesDummy.Entities.CommissionInstruction;
import com.example.BODerivativesDummy.Entities.EventRule;
import com.example.BODerivativesDummy.Entities.Trade;
import com.example.BODerivativesDummy.Enums.ChargeRealizationStatus;

@Entity
@DiscriminatorValue("COMMISSIONS")
public class Commission extends Charge {

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

		CommissionInstruction commInstr = (CommissionInstruction) eventRule.getChargeRateInstruction();
		BigDecimal rate = ((CommissionInstruction) commInstr).getCommissionRate();
		BigDecimal chargeAmount = trade.getQuantity().multiply(rate);
		return new Commission(chargeAmount, ChargeRealizationStatus.CHARGED);
	}

}
