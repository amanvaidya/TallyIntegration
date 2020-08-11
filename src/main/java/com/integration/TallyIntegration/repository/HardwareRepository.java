/**
 * 
 */
package com.integration.TallyIntegration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.integration.TallyIntegration.entity.HardwareEntity;

/**
 * @author Aman
 *
 */
public interface HardwareRepository extends CrudRepository<HardwareEntity, Integer> {

	@Query("SELECT DISTINCT h.invoicenumber, h.invoicedate, h.ponumber, h.podate,v.LedgerName,f.facility_name,h.group_id,g.group_name, h.assetdesc from HardwareEntity h, VendorEntity v, FacilityEntity f,GroupEntity g where h.procured_vendor_id=v.vendor_id and h.facility_id=f.facility_id and h.group_id=g.group_id")
	List<Object[]> getAllDetails();

	@Query("SELECT SUM(h.asset_cost) from HardwareEntity h WHERE h.ponumber =(:ponumber)")
	String findCount(@Param("ponumber") String ponumber);
	
	@Query("SELECT SUM(h.asset_cost) from HardwareEntity h WHERE h.group_id =(:group_id) and h.ponumber=(:ponumber)")
	String findGCount(@Param("group_id") String group_id,@Param("ponumber") String ponumber);
	
	@Query("SELECT SUM(h.asset_cost) from HardwareEntity h WHERE h.group_id =(:group_id) and h.ponumber=(:ponumber) and h.assetdesc=(:assetdesc)")
	String findDCost(@Param("group_id") String group_id,@Param("ponumber") String ponumber,@Param("assetdesc") String assetdesc);
	
	@Query("SELECT SUM(h.assetqty) from HardwareEntity h WHERE h.group_id =(:group_id) and h.ponumber=(:ponumber) and h.assetdesc=(:assetdesc)")
	String findDCount(@Param("group_id") String group_id,@Param("ponumber") String ponumber,@Param("assetdesc") String assetdesc);
}
