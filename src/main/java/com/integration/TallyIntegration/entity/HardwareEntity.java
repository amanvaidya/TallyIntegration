/**
 * 
 */
package com.integration.TallyIntegration.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Aman
 *
 */
@Entity
@Table(name="hardware_register")
public class HardwareEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ast_id;
	private String invoicenumber;
	private String invoicedate;
	private String ponumber;
	private String podate;
	private String asset_cost;
	private String procured_vendor_id;
	private String facility_id;
	private String group_id;
	private String assetdesc;
	private String assetqty;
	
	
	public String getAssetqty() {
		return assetqty;
	}
	public void setAssetqty(String assetqty) {
		this.assetqty = assetqty;
	}
	public String getAssetdesc() {
		return assetdesc;
	}
	public void setAssetdesc(String assetdesc) {
		this.assetdesc = assetdesc;
	}
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getFacility_id() {
		return facility_id;
	}
	public void setFacility_id(String facility_id) {
		this.facility_id = facility_id;
	}
	public String getProcured_vendor_id() {
		return procured_vendor_id;
	}
	public void setProcured_vendor_id(String procured_vendor_id) {
		this.procured_vendor_id = procured_vendor_id;
	}
	public String getInvoicenumber() {
		return invoicenumber;
	}
	public void setInvoicenumber(String invoicenumber) {
		this.invoicenumber = invoicenumber;
	}
	public String getInvoicedate() {
		return invoicedate;
	}
	public void setInvoicedate(String invoicedate) {
		this.invoicedate = invoicedate;
	}
	public String getPonumber() {
		return ponumber;
	}
	public void setPonumber(String ponumber) {
		this.ponumber = ponumber;
	}
	public String getPodate() {
		return podate;
	}
	public void setPodate(String podate) {
		this.podate = podate;
	}
	public String getAsset_cost() {
		return asset_cost;
	}
	public void setAsset_cost(String asset_cost) {
		this.asset_cost = asset_cost;
	}
	
}
