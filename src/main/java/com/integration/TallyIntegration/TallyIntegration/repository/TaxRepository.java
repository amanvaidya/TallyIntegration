/**
 * 
 */
package com.integration.TallyIntegration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.integration.TallyIntegration.entity.TaxEntity;

/**
 * @author Aman
 *
 */
public interface TaxRepository extends CrudRepository<TaxEntity, Integer>{

	@Query
	("SELECT o from TaxEntity o")
	List<TaxEntity> getAll();
	
}
