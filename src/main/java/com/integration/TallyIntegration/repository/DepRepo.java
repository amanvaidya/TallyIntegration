/**
 * 
 */
package com.integration.TallyIntegration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.integration.TallyIntegration.entity.DepreciationEntity;

/**
 * @author Aman
 *
 */
public interface DepRepo extends CrudRepository<DepreciationEntity, Integer>{

	@Query
	("SELECT f.facility_name,sum(d.ddep*DAY(GETDATE())) from DepreciationEntity d, FacilityEntity f where d.facility_id=f.facility_id and f.facility_name=(:facility_name) group by f.facility_name")
	List<Object[]> getAllFacility(@Param("facility_name") String facility_name);
	
	@Query
	("SELECT g.group_name,sum(d.ddep*datediff(day,d.in_dt,getDate())) from DepreciationEntity d, GroupEntity g group by g.group_name")
	List<Object[]> getAllGroup();
}
