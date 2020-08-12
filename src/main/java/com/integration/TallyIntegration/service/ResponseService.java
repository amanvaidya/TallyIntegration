/**
 * 
 */
package com.integration.TallyIntegration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integration.TallyIntegration.common.TallyCommon;
import com.integration.TallyIntegration.entity.TallyResponse;
import com.integration.TallyIntegration.repository.TallyResponseRepo;

/**
 * @author Aman
 *
 */
@Service
public class ResponseService {
	/*@Autowired 
	private TallyResponseRepo tallyResponseRepo;
	*/
	private String generateXML() {
		String SXML="<STATUS>"
					+"<MASTERNAME></MASTERNAME>"
					+"<TALLYCOUNT></TALLYCOUNT>"
					+"<TRAXXCOUNT></TRAXXCOUNT>"
					+"<DATASTATUS></DATASTATUS>"
					+"</STATUS>";
		TallyCommon tallyCommon = new TallyCommon();
		return tallyCommon.TallyHeader+SXML+tallyCommon.TallyFooter;
	}
	
	public String saveRespone(TallyResponse tallyResponse) {
		//tallyResponseRepo.save(tallyResponse);
		String result = generateXML();
		return result;
	}
}
