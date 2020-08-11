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
@Table(name="subgroup_master")
public class AssetMasterEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int subgroup_id;
	private String subgroup_name;
	private String subgroup_code;
	public String getSubgroup_name() {
		return subgroup_name;
	}
	public void setSubgroup_name(String subgroup_name) {
		this.subgroup_name = subgroup_name;
	}
	public String getSubgroup_code() {
		return subgroup_code;
	}
	public void setSubgroup_code(String subgroup_code) {
		this.subgroup_code = subgroup_code;
	}
	/**
	 * @param subgroup_name
	 * @param subgroup_code
	 */
	public AssetMasterEntity(String subgroup_name, String subgroup_code) {
		super();
		this.subgroup_name = subgroup_name;
		this.subgroup_code = subgroup_code;
	}
	
	public AssetMasterEntity() {}
	
}
