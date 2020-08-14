/**
 * 
 */
package com.integration.TallyIntegration.repository;

import com.integration.TallyIntegration.entity.AssetMovementEntity;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
/**
 * @author Aman
 *
 */
public interface AssetTransferRepository extends CrudRepository<AssetMovementEntity, Integer>{
	@Query
	("select f.facility_name, i.ast_name, sum(h.asset_cost),count(h.ast_id) from AssetMovementDetailEntity i, FacilityEntity f, HardwareRegisterEntity h,AssetMovementEntity ir where i.ast_id=h.assetid and i.iut_req_id=ir.id and ir.facility_id=f.facility_id and i.approval_status='Approved' and f.facility_name=(:facilityName) group by f.facility_name, i.ast_name")
	List<Object[]> getTransferData(@Param("facilityName")String facilityName);
	@Query
	("select  count(i.ast_id),h.asset_cost,round((count(h.assetid)*h.asset_cost),2),h.assetname from AssetMovementDetailEntity i, HardwareRegisterEntity h, FacilityEntity f where i.ast_id=h.assetid and h.facility_id=f.facility_id and f.facility_name=(:facilityName) and h.assetname=(:assetName) group by h.assetname,h.asset_cost")
	List<Object[]> getTransferDetails(@Param("facilityName")String facilityName,@Param("assetName")String assetName);

}
