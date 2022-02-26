package com.example.BODerivativesDummy.Entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("COMMINSTRUCTION")
public class CommissionInstruction extends ChargeRateInstruction {

	@Column(name = "COMMISSION_RATE")
	private BigDecimal commissionRate;

	public CommissionInstruction() {
		super();
	}

	public CommissionInstruction(LocalDate chargeStartDate, LocalDate chargeEndDate) {
		super(chargeStartDate, chargeEndDate);
	}

	public BigDecimal getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(BigDecimal commissionRate) {
		this.commissionRate = commissionRate;
	}

	@Override
	public BigDecimal getRate() {
		return commissionRate;
	}

}
