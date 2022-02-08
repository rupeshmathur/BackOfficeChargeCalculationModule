package com.example.BODerivativesDummy.Entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRADE_ENTITY")
public class Trade {

	public Trade() {
		super();
	}

	public Trade(LocalDate tradeDate, BigDecimal price, BigDecimal quantity, String exchangeName) {
		super();
		this.tradeDate = tradeDate;
		this.price = price;
		this.quantity = quantity;
		this.exchangeName = exchangeName;
	}

	@Id
	@Column(name = "TRADE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tradeID;
	@Column(name = "TRADE_DATE")
	private LocalDate tradeDate;
	@Column(name = "TRADE_PRICE")
	private BigDecimal price;
	@Column(name = "TRADE_QTY")
	private BigDecimal quantity;
	@Column(name = "EXCHANGE")
	private String exchangeName;

	public long getTradeID() {
		return tradeID;
	}

	public void setTradeID(long tradeID) {
		this.tradeID = tradeID;
	}

	public LocalDate getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(LocalDate tradeDate) {
		this.tradeDate = tradeDate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

}
