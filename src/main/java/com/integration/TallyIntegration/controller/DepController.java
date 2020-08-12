/**
 * 
 */
package com.integration.TallyIntegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integration.TallyIntegration.service.DepService;

/**
 * @author Aman
 *
 */
@RestController
@RequestMapping(value="/tally")
public class DepController {
	@Autowired
	private DepService depService;
	
	@PostMapping(value="/dep",produces={MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")
	public String dep(String facility_name) {
		return depService.DepreciationRecord(facility_name);
	}
}
