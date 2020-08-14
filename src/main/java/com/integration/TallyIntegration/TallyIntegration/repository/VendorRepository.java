/**
 * 
 */
package com.integration.TallyIntegration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.integration.TallyIntegration.entity.VendorEntity;

/**
 * @author Aman
 *
 */
public interface VendorRepository extends CrudRepository<VendorEntity, Integer>{

	@Query
	("SELECT v from VendorEntity v")
	List<VendorEntity> getAll();
	
}
