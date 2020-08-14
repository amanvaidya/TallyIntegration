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
@Table(name="depreciation_new")
public class DepreciationEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ast_id;
	private String ddep;
	private String in_dt;
	private String group_id;
	private String facility_id;

	public int getAst_id() {
		return ast_id;
	}

	public String getDdep() {
		return ddep;
	}

	public void setDdep(String ddep) {
		this.ddep = ddep;
	}

	public String getIn_dt() {
		return in_dt;
	}

	public void setIn_dt(String in_dt) {
		this.in_dt = in_dt;
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
}
