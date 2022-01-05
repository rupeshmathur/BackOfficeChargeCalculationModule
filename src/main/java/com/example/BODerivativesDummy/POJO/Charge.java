package com.example.BODerivativesDummy.POJO;

import com.example.BODerivativesDummy.Entities.EventRule;
import com.example.BODerivativesDummy.Entities.Trade;

public abstract class Charge<T> {

	public abstract T processCharge(Trade trade, EventRule eventRule) ;

}
