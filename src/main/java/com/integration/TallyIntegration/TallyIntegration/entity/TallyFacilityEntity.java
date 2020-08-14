/**
 * 
 */
package com.integration.TallyIntegration.entity;

import javax.persistence.Column;
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
@Table(name="facility_master")
public class TallyFacilityEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int facility_id;
	@Column(name="facility_name" , insertable = false, updatable = false)
	private String CategoryName;
	@Column(name="facility_name" , insertable = false, updatable = false)
	private String CostcenterName;
	
	
	/**
	 * 
	 */
	public TallyFacilityEntity() {
		
	}
	
	/**
	 * @param categoryName
	 * @param costcenterName
	 */
	public TallyFacilityEntity(String categoryName, String costcenterName) {
		super();
		CategoryName = categoryName;
		CostcenterName = costcenterName;
	}

	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public String getCostcenterName() {
		return CostcenterName;
	}
	public void setCostcenterName(String costcenterName) {
		CostcenterName = costcenterName;
	}
}
