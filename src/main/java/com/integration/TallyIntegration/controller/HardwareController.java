/**
 * 
 */
package com.integration.TallyIntegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integration.TallyIntegration.service.HardwareService;

/**
 * @author Aman
 *
 */
@RestController
@RequestMapping(value="/tally")
public class HardwareController {
	@Autowired
	private HardwareService hardwareService;
	
	@PostMapping(value="/assetPur",produces={MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")
	public String findCount(String facility_name) {
		return hardwareService.HardwareRequest(facility_name);
	}
}
