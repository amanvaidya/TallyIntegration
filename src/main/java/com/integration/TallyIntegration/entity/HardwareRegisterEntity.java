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
public class HardwareRegisterEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ast_id;
	private String assetid;
	private String asset_cost;
	private String facility_id;
	private String assetname;
	
	public String getAssetname() {
		return assetname;
	}
	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}
	public String getFacility_id() {
		return facility_id;
	}
	public void setFacility_id(String facility_id) {
		this.facility_id = facility_id;
	}
	public int getAst_id() {
		return ast_id;
	}
	public void setAst_id(int ast_id) {
		this.ast_id = ast_id;
	}
	public String getAssetid() {
		return assetid;
	}
	public void setAssetid(String assetid) {
		this.assetid = assetid;
	}
	public String getAsset_cost() {
		return asset_cost;
	}
	public void setAsset_cost(String asset_cost) {
		this.asset_cost = asset_cost;
	}
}
