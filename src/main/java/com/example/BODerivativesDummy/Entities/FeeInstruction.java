package com.example.BODerivativesDummy.Entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FEEINSTRUCTION")
public class FeeInstruction extends ChargeRateInstruction {

	@Column(name = "FEE_RATE")
	private BigDecimal feeRate;

	public FeeInstruction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeeInstruction(LocalDate chargeStartDate, LocalDate chargeEndDate) {
		super(chargeStartDate, chargeEndDate);
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getFeeRate() {
		return feeRate;
	}

	public void setFeeRate(BigDecimal feeRate) {
		this.feeRate = feeRate;
	}

}
