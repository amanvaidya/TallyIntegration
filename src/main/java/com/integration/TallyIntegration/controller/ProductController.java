/**
 * 
 */
package com.integration.TallyIntegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integration.TallyIntegration.service.ProductService;

/**
 * @author Aman
 *
 */
@RestController
@RequestMapping(value="/tally")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping(value="products",produces={MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")
	public String ProductRequest() {
		return productService.ProductRequest();
	}
}
