/**
 * 
 */
package com.integration.TallyIntegration.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.integration.TallyIntegration.service.AssetPurchaseService;

/**
 * @author Aman
 *
 */
@RestController
@RequestMapping(value="/tally")
public class AssetPurchaseController {
	@Autowired
	private AssetPurchaseService assetPurchaseService; 
	
	@PostMapping(value="/assetPur",produces={MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")
	public String generateAssetPurchase(@RequestParam(required=true)String facilityName) throws ParseException {
		return assetPurchaseService.getPurchaseData(facilityName);
	}
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public String handleMissingParams(MissingServletRequestParameterException ex) {
	    String name = ex.getParameterName();
	    return "<Error>"+name + " parameter is missing</Error>";
	    // 
	}
}

