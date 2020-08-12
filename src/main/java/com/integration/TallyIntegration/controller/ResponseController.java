/**
 * 
 */
package com.integration.TallyIntegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integration.TallyIntegration.entity.TallyResponse;
import com.integration.TallyIntegration.service.ResponseService;

/**
 * @author Aman
 *
 */
@RestController
@RequestMapping(value="/tally")
public class ResponseController {
	@Autowired
	private ResponseService responseService;
	@PostMapping(path = "/saveResponse",consumes={MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")
    public String TallyResponse(@RequestBody TallyResponse tallyResponse) {
		return responseService.saveRespone(tallyResponse);
    }
}
