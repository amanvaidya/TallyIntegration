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
@Table(name="t_grn")
public class GrnEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int grn_id;
	private String grn_number;
	private String inv_number;
	private String inv_date;
	private String grn_date;
	private String qty;
	private int po_id;
	private String inv_amt;
	private int facility_id;
	private String invoice_copy;
	private String vendor_id;
	private String po_number;
	private String po_date;
	
	
	
	public String getPo_date() {
		return po_date;
	}
	public void setPo_date(String po_date) {
		this.po_date = po_date;
	}
	public String getGrn_date() {
		return grn_date;
	}
	public void setGrn_date(String grn_date) {
		this.grn_date = grn_date;
	}
	public String getPo_no() {
		return po_number;
	}
	public void setPo_no(String po_number) {
		this.po_number = po_number;
	}
	public String getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(String vendor_id) {
		this.vendor_id = vendor_id;
	}
	public int getGrn_id() {
		return grn_id;
	}
	public void setGrn_id(int grn_id) {
		this.grn_id = grn_id;
	}
	public String getGrn_number() {
		return grn_number;
	}
	public void setGrn_number(String grn_number) {
		this.grn_number = grn_number;
	}
	public String getInv_number() {
		return inv_number;
	}
	public void setInv_number(String inv_number) {
		this.inv_number = inv_number;
	}
	public String getInv_date() {
		return inv_date;
	}
	public void setInv_date(String inv_date) {
		this.inv_date = inv_date;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public int getPo_id() {
		return po_id;
	}
	public void setPo_id(int po_id) {
		this.po_id = po_id;
	}
	public String getInv_amt() {
		return inv_amt;
	}
	public void setInv_amt(String inv_amt) {
		this.inv_amt = inv_amt;
	}
	public int getFacility_id() {
		return facility_id;
	}
	public void setFacility_id(int facility_id) {
		this.facility_id = facility_id;
	}
	public String getInvoice_copy() {
		return invoice_copy;
	}
	public void setInvoice_copy(String invoice_copy) {
		this.invoice_copy = invoice_copy;
	}
	
}
