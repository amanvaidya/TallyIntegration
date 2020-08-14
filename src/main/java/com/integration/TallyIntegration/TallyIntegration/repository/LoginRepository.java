/**
 * 
 */
package com.integration.TallyIntegration.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.integration.TallyIntegration.entity.LoginEntity;





/**
 * @author Aman
 *
 */
public interface LoginRepository extends CrudRepository<LoginEntity, Integer> {
	@Query("SELECT t FROM LoginEntity t WHERE LOWER(t.login_name) = LOWER(:login_name) and t.password=:password")
	LoginEntity findUser(@Param("login_name") String login_name, @Param("password") String password);
}
