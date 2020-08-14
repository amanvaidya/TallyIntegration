/**
 * 
 */
package com.integration.TallyIntegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integration.TallyIntegration.service.VendorService;

/**
 * @author Aman
 *
 */
@RestController
@RequestMapping(value="/tally")
public class VendorController {
	@Autowired
	VendorService vendorService;
	
	@PostMapping(value="vendor",produces={MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")
	public String VendorRequest() {
		return vendorService.VendorRequest();
	}
}
