/**
 * 
 */
package com.integration.TallyIntegration.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integration.TallyIntegration.entity.TallyTransferResponse;
import com.integration.TallyIntegration.service.TallyTransferService;

/**
 * @author Aman
 *
 */
@RestController
@RequestMapping(value="/tally")
public class TallyTransferResController {
	@Autowired
	private TallyTransferService tallyTransferService;
	
	@PostMapping(path="/trnRes",consumes={MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")
	public void TrnInsert(@RequestBody ArrayList<TallyTransferResponse> TallyTransferResponse) {
		tallyTransferService.multipleTrnInsert(TallyTransferResponse);
	}
}
