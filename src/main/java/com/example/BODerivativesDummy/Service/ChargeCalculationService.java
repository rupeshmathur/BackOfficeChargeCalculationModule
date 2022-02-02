package com.example.BODerivativesDummy.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.BODerivativesDummy.Entities.Trade;
import com.example.BODerivativesDummy.POJO.Charge;

public abstract class ChargeCalculationService {
	
	public abstract  List<Charge> calculateCharge(Trade trade, List<Charge> charges);

}
