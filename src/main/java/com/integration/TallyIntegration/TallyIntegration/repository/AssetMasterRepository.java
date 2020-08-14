/**
 * 
 */
package com.integration.TallyIntegration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.integration.TallyIntegration.entity.AssetMasterEntity;


/**
 * @author Aman
 *
 */
public interface AssetMasterRepository extends CrudRepository<AssetMasterEntity, Integer>{
	
	@Query
	("SELECT new com.mobile.mzolo.entity.AssetMasterEntity(a.subgroup_name, a.subgroup_code) from AssetMasterEntity a")
	List<AssetMasterEntity> getAll();

}
