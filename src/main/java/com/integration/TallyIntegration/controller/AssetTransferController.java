/**
 * 
 */
package com.integration.TallyIntegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.integration.TallyIntegration.service.AssetTransferService;

/**
 * @author Aman
 *
 */
@RestController
@RequestMapping(value="/tally")
public class AssetTransferController {
	@Autowired
	private AssetTransferService assetTransferService;
	
	@PostMapping(value="/transferAsset",produces={MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")
	public String getTransferData(@RequestParam(required=true)String facilityName) {
		return assetTransferService.generateTransferData(facilityName);
	}
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public String handleMissingParams(MissingServletRequestParameterException ex) {
	    String name = ex.getParameterName();
	    return "<Error>"+name + " parameter is missing</Error>";
	    // 
	}
}
