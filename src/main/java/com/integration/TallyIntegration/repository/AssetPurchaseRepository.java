/**
 * 
 */
package com.integration.TallyIntegration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.integration.TallyIntegration.entity.PurchaseDataEntity;

/**
 * @author Aman
 *
 */
public interface AssetPurchaseRepository extends CrudRepository<PurchaseDataEntity,Integer>{
	
	@Query
	("SELECT f.facility_id from FacilityEntity f where f.facility_name=(:facilityName)")
	int getFacilityId(@Param("facilityName") String facilityName);
	
	@Query
	("SELECT p.po_id,p.po_no,p.po_type from PurchaseEntity p where p.ship_to=(:facility_id) and p.po_no in (select g.po_number from GrnEntity g) or p.po_no in (select s.po_number from SrnEntity s)")
	List<Object[]> getPoNumber(@Param("facility_id")int facility_id);
	
	@Query
	("SELECT g.grn_number,g.grn_date,g.inv_number,g.inv_date,g.po_date,v.LedgerName,round(g.inv_amt,2),g.grn_id from GrnEntity g, VendorEntity v where g.vendor_id=v.vendor_id and g.po_number=(:poNumber)")
	List<Object[]> getGrnDetails(@Param("poNumber") String poNumber);
	@Query
	("SELECT g.grn_number,g.grn_date,g.inv_number,g.inv_date,g.po_date,v.LedgerName,round(g.inv_amt,2),g.grn_id from SrnEntity g, VendorEntity v where g.vendor_id=v.vendor_id and g.po_number=(:poNumber)")
	List<Object[]> getSrnDetails(@Param("poNumber") String poNumber);
	
	@Query
	("SELECT gp.group_name,sum(g.grn_asset_value),g.group_id from GrnDataEntity g, GroupEntity gp where g.group_id=gp.group_id and grn_id=(:grnId) group by gp.group_name,g.group_id")
	List<Object[]> getGroupDetails(@Param("grnId")String grnId);
	@Query
	("SELECT gp.group_name,sum(g.grn_asset_value),g.group_id from SrnDataEntity g, GroupEntity gp where g.group_id=gp.group_id and grn_id=(:grnId) group by gp.group_name,g.group_id")
	List<Object[]> getSGroupDetails(@Param("grnId")String grnId);
	
	@Query
	("select g.grn_asset_desc, g.grn_qty_recieved,g.grn_asset_cost,g.grn_asset_value,p.PartNo from GrnDataEntity g,ProductEntity p where g.grn_asset=p.AssetName and g.group_id=(:groupId) and g.grn_id=(:grnId)")
	List<Object[]> getGrnAssetDetails(@Param("groupId")int groupId,@Param("grnId")int grnId);
	@Query
	("select g.grn_asset_desc, g.grn_qty_recieved,g.grn_asset_cost,g.grn_asset_value,p.PartNo from GrnDataEntity g,ProductEntity p where g.grn_asset=p.AssetName and g.group_id=(:groupId) and g.grn_id=(:grnId)")
	List<Object[]> getSGrnAssetDetails(@Param("groupId")int groupId,@Param("grnId")int grnId);
	@Query
	("select  p.CGSTPer,p.SGSTPer,p.IGSTPer,g.grn_asset_cost from PurchaseDataEntity p,GrnDataEntity g where p.poasset_id=g.po_asset_id and p.po_id=(:poId) and g.grn_id=(:grnId)")
	List<Object[]> getGTaxDetails(@Param("poId")int poId,@Param("grnId")int grnId);
	@Query
	("select  p.CGSTPer,p.SGSTPer,p.IGSTPer,g.grn_asset_cost from PurchaseDataEntity p,SrnDataEntity g where p.poasset_id=g.po_asset_id and p.po_id=(:poId) and g.grn_id=(:grnId)")
	List<Object[]> getSTaxDetails(@Param("poId")int poId,@Param("grnId")int grnId);
	@Query("select t.LEDGERNAME from TaxEntity t where t.RATEOFTAXCALCULATION=(:exPer) and t.LEDGERNAME like ('CGST%')")
	String getCTax(@Param("exPer") String exPer);
	@Query("select t.LEDGERNAME from TaxEntity t where t.RATEOFTAXCALCULATION=(:exPer) and t.LEDGERNAME like ('SGST%')")
	String getGTax(@Param("exPer") String exPer);
	@Query("select t.LEDGERNAME from TaxEntity t where t.RATEOFTAXCALCULATION=(:exPer) and t.LEDGERNAME like ('IGST%')")
	String getITax(@Param("exPer") String exPer);
}
