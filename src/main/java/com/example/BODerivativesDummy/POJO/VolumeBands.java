package com.example.BODerivativesDummy.POJO;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Embeddable
public class VolumeBands {

	public BigDecimal band;
	public BigDecimal rate;

	public VolumeBands() {
		super();
	}

	public VolumeBands(BigDecimal band, BigDecimal rate) {
		super();
		this.band = band;
		this.rate = rate;
	}

	public BigDecimal getBand() {
		return band;
	}

	public void setBand(BigDecimal band) {
		this.band = band;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getRateBasedOnBand(List<VolumeBands> volumeBand) {
		return BigDecimal.ZERO;
	}
}
