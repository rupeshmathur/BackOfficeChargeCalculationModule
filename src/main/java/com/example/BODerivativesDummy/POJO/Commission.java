package com.example.BODerivativesDummy.POJO;

import java.math.BigDecimal;

import com.example.BODerivativesDummy.Entities.CommissionInstruction;
import com.example.BODerivativesDummy.Entities.EventRule;
import com.example.BODerivativesDummy.Entities.Trade;
import com.example.BODerivativesDummy.Enums.ChargeRealizationStatus;

public class Commission extends Charge {

	private int commissionId;
	private BigDecimal amount;
	private Trade trade;
	private EventRule eventRule;
	private ChargeRealizationStatus chargeRealizationStatus;

	public Commission() {
		super();
	}

	public Commission(BigDecimal amount, Trade trade, EventRule eventRule,
			ChargeRealizationStatus chargeRealizationStatus) {
		super();
		this.amount = amount;
		this.trade = trade;
		this.eventRule = eventRule;
		this.chargeRealizationStatus = chargeRealizationStatus;
	}

	public int getCommissionId() {
		return commissionId;
	}

	public void setCommissionId(int commissionId) {
		this.commissionId = commissionId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

	public EventRule getEventRule() {
		return eventRule;
	}

	public void setEventRule(EventRule eventRule) {
		this.eventRule = eventRule;
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
		return new Commission(chargeAmount, trade, eventRule, ChargeRealizationStatus.CHARGED);
	}

}
