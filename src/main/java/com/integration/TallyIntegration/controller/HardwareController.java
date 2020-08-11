/**
 * 
 */
package com.integration.TallyIntegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integration.TallyIntegration.service.HardwareService;

/**
 * @author Aman
 *
 */
@RestController
public class HardwareController {
	@Autowired
	private HardwareService hardwareService;
	
	@PostMapping(value="/hard",produces={MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")
	public String findCount() {
		return hardwareService.HardwareRequest();
	}
}
