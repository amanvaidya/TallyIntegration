/**
 * 
 */
package com.integration.TallyIntegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integration.TallyIntegration.service.TaxService;

/**
 * @author Aman
 *
 */
@RestController
@RequestMapping(value="/tally")
public class TaxController {

	@Autowired
	TaxService taxService;
	
	@PostMapping(value="taxes",produces={MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")
	public String CreateRequest() {
			return taxService.CreateRequest();	
	}
}
