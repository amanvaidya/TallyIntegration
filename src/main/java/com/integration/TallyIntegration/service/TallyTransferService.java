/**
 * 
 */
package com.integration.TallyIntegration.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integration.TallyIntegration.entity.TallyTransferResponse;
import com.integration.TallyIntegration.repository.TallyTransferRepo;



/**
 * @author Aman
 *
 */
@Service
public class TallyTransferService {
	@Autowired
	private TallyTransferRepo tallyTransferRepo;
	
	public void multipleTrnInsert(ArrayList<TallyTransferResponse> tallyTransferResponse) {
		tallyTransferRepo.saveAll(tallyTransferResponse);
	}
}
