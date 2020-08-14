/**
 * 
 */
package com.integration.TallyIntegration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.integration.TallyIntegration.entity.ProductEntity;

/**
 * @author Aman
 *
 */
public interface ProductRepository extends CrudRepository<ProductEntity, Integer>{

	@Query
	("SELECT  p from ProductEntity p")
	List<ProductEntity> getAll();
}
