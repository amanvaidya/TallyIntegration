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
@Table(name="t_po_assets")
public class PurchaseDataEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int poasset_id;
	private int po_id;
	@Column(name="Ex_percent")
	private String CGSTPer;
	@Column(name="Tax_percent")
	private String SGSTPer;
	@Column(name="Tax_percent1")
	private String IGSTPer;
	@Column(name="totalprice")
	private String totPrice;
	
	public String getTotPrice() {
		return totPrice;
	}
	public void setTotPrice(String totPrice) {
		this.totPrice = totPrice;
	}
	public int getPoasset_id() {
		return poasset_id;
	}
	public void setPoasset_id(int poasset_id) {
		this.poasset_id = poasset_id;
	}
	public int getPo_id() {
		return po_id;
	}
	public void setPo_id(int po_id) {
		this.po_id = po_id;
	}
	public String getCGSTPer() {
		return CGSTPer;
	}
	public void setCGSTPer(String cGSTPer) {
		CGSTPer = cGSTPer;
	}
	public String getSGSTPer() {
		return SGSTPer;
	}
	public void setSGSTPer(String sGSTPer) {
		SGSTPer = sGSTPer;
	}
	public String getIGSTPer() {
		return IGSTPer;
	}
	public void setIGSTPer(String iGSTPer) {
		IGSTPer = iGSTPer;
	}
	
	
}
