package com.example.BODerivativesDummy.POJO;

import java.math.BigDecimal;

import com.example.BODerivativesDummy.Entities.EventRule;
import com.example.BODerivativesDummy.Entities.FeeInstruction;
import com.example.BODerivativesDummy.Entities.Trade;
import com.example.BODerivativesDummy.Enums.ChargeRealizationStatus;

public class Fee extends Charge {

	private int feeId;
	private BigDecimal amount;
	private Trade trade;
	private EventRule eventRule;
	private ChargeRealizationStatus chargeRealizationStatus;

	public Fee() {
		super();
	}

	public Fee(BigDecimal amount, Trade trade, EventRule eventRule, ChargeRealizationStatus chargeRealizationStatus) {
		super();
		this.amount = amount;
		this.trade = trade;
		this.eventRule = eventRule;
		this.chargeRealizationStatus = chargeRealizationStatus;
	}

	public int getFeeId() {
		return feeId;
	}

	public void setFeeId(int feeId) {
		this.feeId = feeId;
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

		FeeInstruction feeInstr = (FeeInstruction) eventRule.getChargeRateInstruction();
		BigDecimal rate = ((FeeInstruction) feeInstr).getFeeRate();
		BigDecimal chargeAmount = trade.getQuantity().multiply(rate);
		return new Fee(chargeAmount, trade, eventRule, ChargeRealizationStatus.CHARGED);
	}

}
