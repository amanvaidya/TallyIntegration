/**
 * 
 */
package com.integration.TallyIntegration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.integration.TallyIntegration.entity.ApprovePoAssetEntity;

/**
 * @author Aman
 *
 */
public interface AssetTaxMap extends CrudRepository<ApprovePoAssetEntity, Integer>{
	
	@Query
	("SELECT a.approvepo_id from ApprovePoEntity a where a.po_no=(:ponumber)")
	int getPoId(@Param("ponumber") String ponumber);
	
	@Query
	("SELECT ap.Ex_percent,ap.Ex_amount,ap.Tax_percent,ap.tax_amount,ap.Tax_percent1,ap.tax_amount1 from ApprovePoAssetEntity ap where ap.approve_id=(:approveId)")
	List<Object[]> getAllTaxes(@Param("approveId") int approveId);
	
	@Query
	("SELECT t.LEDGERNAME from TaxEntity t where t.RATEOFTAXCALCULATION=(:ExPer) and t.LEDGERNAME like 'CGST%'")
	String getCTName(@Param("ExPer") String ExPer);
	@Query
	("SELECT t.LEDGERNAME from TaxEntity t where t.RATEOFTAXCALCULATION=(:TxPer) and t.LEDGERNAME like 'SGST%'")
	String getSTName(@Param("TxPer") String TxPer);
	@Query
	("SELECT t.LEDGERNAME from TaxEntity t where t.RATEOFTAXCALCULATION=(:IxPer) and t.LEDGERNAME like 'IGST%'")
	String getITName(@Param("IxPer") String IxPer);
	
	@Query
	("SELECT p.PartNo from ProductEntity p where p.Description=(:assetdesc)")
	String getItemCode(@Param("assetdesc") String assetdesc);
	
}
