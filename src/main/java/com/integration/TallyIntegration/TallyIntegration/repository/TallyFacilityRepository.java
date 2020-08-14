/**
 * 
 */
package com.integration.TallyIntegration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.integration.TallyIntegration.entity.TallyFacilityEntity;

/**
 * @author Aman
 *
 */
public interface TallyFacilityRepository extends CrudRepository<TallyFacilityEntity, Integer>{

	@Query
	("SELECT new com.mobile.mzolo.entity.TallyFacilityEntity(t.CategoryName, t.CostcenterName) FROM TallyFacilityEntity t")
	List<TallyFacilityEntity> getAll();
}
