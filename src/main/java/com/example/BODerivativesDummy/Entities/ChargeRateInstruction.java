package com.example.BODerivativesDummy.Entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.example.BODerivativesDummy.Enums.ChargeCalculationAlgorithm;
import com.example.BODerivativesDummy.Enums.RateStructure;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
/*
 * @DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name =
 * "CHARGE_TYPE")
 */
@Embeddable
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "CHARGE_INSTR_TYPE")
@JsonSubTypes({ @Type(value = CommissionInstruction.class, name = "COMMINSTRUCTION"),
		@Type(value = FeeInstruction.class, name = "FEEINSTRUCTION") })
public abstract class ChargeRateInstruction {

	@Id
	@Column(name = "CHARGE_INSTR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long instrId;
	@Column(name = "CHARGE_START_DATE")
	private LocalDate chargeStartDate;
	@Column(name = "CHARGE_END_DATE")
	private LocalDate chargeEndDate;
	@Enumerated(EnumType.STRING)
	private ChargeCalculationAlgorithm chargeCalculationAlgorithm;
	@Enumerated(EnumType.STRING)
	private RateStructure rateStructure;

	public ChargeRateInstruction() {
		super();
	}

	public ChargeRateInstruction(LocalDate chargeStartDate, LocalDate chargeEndDate) {
		super();
		this.chargeStartDate = chargeStartDate;
		this.chargeEndDate = chargeEndDate;
	}

	public long getInstrId() {
		return instrId;
	}

	public void setInstrId(long instrId) {
		this.instrId = instrId;
	}

	public LocalDate getChargeStartDate() {
		return chargeStartDate;
	}

	public void setChargeStartDate(LocalDate chargeStartDate) {
		this.chargeStartDate = chargeStartDate;
	}

	public LocalDate getChargeEndDate() {
		return chargeEndDate;
	}

	public void setChargeEndDate(LocalDate chargeEndDate) {
		this.chargeEndDate = chargeEndDate;
	}

	public ChargeCalculationAlgorithm getChargeCalculationAlgorithm() {
		return chargeCalculationAlgorithm;
	}

	public void setChargeCalculationAlgorithm(ChargeCalculationAlgorithm chargeCalculationAlgorithm) {
		this.chargeCalculationAlgorithm = chargeCalculationAlgorithm;
	}

	public RateStructure getRateStructure() {
		return rateStructure;
	}

	public void setRateStructure(RateStructure rateStructure) {
		this.rateStructure = rateStructure;
	}

	public abstract BigDecimal getRate();
	

}
