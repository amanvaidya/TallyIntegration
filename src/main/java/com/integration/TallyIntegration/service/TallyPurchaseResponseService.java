/**
 * 
 */
package com.integration.TallyIntegration.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.integration.TallyIntegration.entity.TallyPurchaseResponse;
import com.integration.TallyIntegration.repository.TallyPurchaseRepo;

/**
 * @author Aman
 *
 */
@Service
public class TallyPurchaseResponseService {
	@Autowired
	private TallyPurchaseRepo tallyPurchaseRepo;
	
	public void multipleGrnInsert(ArrayList<TallyPurchaseResponse> tallyPurchaseResponse) {
		tallyPurchaseRepo.saveAll(tallyPurchaseResponse);
	}
}
