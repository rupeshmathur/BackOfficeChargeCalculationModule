package com.example.BODerivativesDummy.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BODerivativesDummy.Entities.ChargeRateInstruction;
import com.example.BODerivativesDummy.Repository.ChargeInstrRepo;

@Service
public class ChargeRateInstructionService {

	@Autowired
	ChargeInstrRepo chargeInstrRepo;

	public void saveChargeRateInstructions(ChargeRateInstruction rateInstr) {
		chargeInstrRepo.save(rateInstr);
	}
	
}
