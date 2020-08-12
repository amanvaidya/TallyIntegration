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
@Table(name="t_approve_po_assets")
public class ApprovePoAssetEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int poasset_id;
	private int approve_id;
	private String Ex_ids;
	private String Ex_percent;
	private String Ex_amount;
	private String tax_ids;
	private String Tax_percent;
	private String tax_amount;
	private String tax_ids1;
	private String Tax_percent1;
	private String tax_amount1;
	public int getApprove_id() {
		return approve_id;
	}
	public void setApprove_id(int approve_id) {
		this.approve_id = approve_id;
	}
	public String getEx_ids() {
		return Ex_ids;
	}
	public void setEx_ids(String ex_ids) {
		Ex_ids = ex_ids;
	}
	public String getEx_percent() {
		return Ex_percent;
	}
	public void setEx_percent(String ex_percent) {
		Ex_percent = ex_percent;
	}
	public String getEx_amount() {
		return Ex_amount;
	}
	public void setEx_amount(String ex_amount) {
		Ex_amount = ex_amount;
	}
	public String getTax_ids() {
		return tax_ids;
	}
	public void setTax_ids(String tax_ids) {
		this.tax_ids = tax_ids;
	}
	public String getTax_percent() {
		return Tax_percent;
	}
	public void setTax_percent(String tax_percent) {
		Tax_percent = tax_percent;
	}
	public String getTax_amount() {
		return tax_amount;
	}
	public void setTax_amount(String tax_amount) {
		this.tax_amount = tax_amount;
	}
	public String getTax_ids1() {
		return tax_ids1;
	}
	public void setTax_ids1(String tax_ids1) {
		this.tax_ids1 = tax_ids1;
	}
	public String getTax_percent1() {
		return Tax_percent1;
	}
	public void setTax_percent1(String tax_percent1) {
		Tax_percent1 = tax_percent1;
	}
	public String getTax_amount1() {
		return tax_amount1;
	}
	public void setTax_amount1(String tax_amount1) {
		this.tax_amount1 = tax_amount1;
	}
	
	
}
