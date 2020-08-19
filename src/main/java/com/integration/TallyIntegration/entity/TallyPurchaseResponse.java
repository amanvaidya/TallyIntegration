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
@Table(name="tally_purchase_response")
public class TallyPurchaseResponse {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String grn_number;
	public String getGrn_number() {
		return grn_number;
	}
	public void setGrn_number(String grn_number) {
		this.grn_number = grn_number;
	}
	/**
	 * @param id
	 * @param grn_number
	 */
	public TallyPurchaseResponse(int id, String grn_number) {
		super();
		this.id = id;
		this.grn_number = grn_number;
	}
	/**
	 * @param grn_number
	 */
	public TallyPurchaseResponse(String grn_number) {
		super();
		this.grn_number = grn_number;
	}
	public TallyPurchaseResponse() {
		
	}
	
	
}
