/**
 * 
 */
package com.integration.TallyIntegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integration.TallyIntegration.service.LoginService;

/**
 * @author Aman
 *
 */
@RestController
@RequestMapping(value="/Login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@PostMapping(value="/LoginToApp" ,produces={MediaType.APPLICATION_XML_VALUE},headers = "Accept=application/xml")
	public String findUser(String login_name, String password){
		return loginService.findUser(login_name, password);
	}
	
}
