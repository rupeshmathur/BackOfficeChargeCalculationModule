package com.example.BODerivativesDummy.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BODerivativesDummy.Entities.Trade;
import com.example.BODerivativesDummy.POJO.Charge;
import com.example.BODerivativesDummy.Repository.ChargeCalculationRepo;

@Service
public abstract class ChargeCalculationService {

	public abstract List<Charge> calculateCharge(Trade trade, List<Charge> charges);

	@Autowired
	ChargeCalculationRepo chargeCalculationRepo;

	public void saveCharges(List<Charge> charges) {
		for (Charge charge : charges) {
			chargeCalculationRepo.save(charge);
		}
	}

}
