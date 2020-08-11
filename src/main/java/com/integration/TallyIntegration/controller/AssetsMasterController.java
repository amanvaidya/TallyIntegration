/**
 * 
 */
package com.integration.TallyIntegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integration.TallyIntegration.service.AssetsMasterService;

/**
 * @author Aman
 *
 */
@RestController
@RequestMapping(value="/tally")
public class AssetsMasterController {

	@Autowired
	AssetsMasterService assetMasterService;
	
	@PostMapping(value="assets",produces={MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")
	public String AssetMasterRequest() {
		return assetMasterService.AssetMasterRequest();
	}
}
