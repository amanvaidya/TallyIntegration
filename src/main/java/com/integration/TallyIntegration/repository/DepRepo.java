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
	("SELECT f.facility_name,round(sum(d.ddep*(DATEDIFF(DAY,(:startDate),(:endDate)))),2) from DepreciationEntity d, FacilityEntity f where d.facility_id=f.facility_id and f.facility_name=(:facility_name) and d.in_dt<(:startDate) group by f.facility_name")
	List<Object[]> getAllFacility(@Param("facility_name") String facility_name,@Param("startDate") String startDate,@Param("endDate") String endDate);
	
	@Query
	("SELECT g.group_name,round(sum(d.ddep*datediff(day,d.in_dt,(:endDate))),2) from DepreciationEntity d, GroupEntity g, FacilityEntity f where d.group_id=g.group_id and d.facility_id=f.facility_id and f.facility_name=(:facility_name) and d.in_dt<(:startDate) group by g.group_name")
	List<Object[]> getAllGroup(@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("facility_name") String facility_name);
}
