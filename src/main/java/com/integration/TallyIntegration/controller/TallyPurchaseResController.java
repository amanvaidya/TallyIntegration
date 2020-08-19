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

import com.integration.TallyIntegration.entity.TallyPurchaseResponse;
import com.integration.TallyIntegration.service.TallyPurchaseResponseService;

/**
 * @author Aman
 *
 */
@RestController
@RequestMapping(value="/tally")
public class TallyPurchaseResController {
	@Autowired
	private TallyPurchaseResponseService tallyPurchaseResponseService;
	
	@PostMapping(path="/purRes",consumes={MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")
	public void GrnInsert(@RequestBody ArrayList<TallyPurchaseResponse> TallyPurchaseResponse) {
		tallyPurchaseResponseService.multipleGrnInsert(TallyPurchaseResponse);
	}
}
