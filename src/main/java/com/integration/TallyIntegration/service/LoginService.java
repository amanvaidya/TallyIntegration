/**
 * 
 */
package com.integration.TallyIntegration.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.integration.TallyIntegration.common.TallyCommon;
import com.integration.TallyIntegration.encryption.EncrypterDecrypter;
import com.integration.TallyIntegration.entity.LoginEntity;
import com.integration.TallyIntegration.repository.LoginRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Aman
 *
 */
@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;
	String result="";
	TallyCommon tallyCommon = new TallyCommon();
	public String PushRequest(String auth_token)
    {             
        String TXML = null;
        
        TXML = "<Authorization>"+auth_token+"</Authorization>";
        return TXML;
    }
	
	public String findUser(String login_name, String password){
		final String secretKey = "YOUR_SECRET_KEY";
		

		String DecryptedLoginName = EncrypterDecrypter.decrypt(login_name, secretKey) ;
		String DecryptedPassword = EncrypterDecrypter.decrypt(password, secretKey) ;
		
		String token = getJWTToken(DecryptedLoginName);
		LoginEntity user = new LoginEntity();
		user.setLogin_name(DecryptedLoginName);
		user.setAuth_token(token);
		
		if(loginRepository.findUser(DecryptedLoginName, DecryptedPassword) != null){
			result =  PushRequest(token);
			}else {
				result = PushRequest("Invalid Credentials");
			}
		return tallyCommon.TallyHeader+result+tallyCommon.TallyFooter;
	}
	
	
	/*to get auth token*/
	private String getJWTToken(String username) {
		String secretKey = "YOUR_SECRET_KEY";
		final long JWT_TOKEN_VALIDITY = 60*60*24;//Token Validity
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "PREFIX" + token;

	}
}
