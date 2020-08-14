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
@Table(name="t_po")
public class PurchaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int po_id;
	private String po_no;
	private String po_type;
	private int ship_to;
	
	public int getShip_to() {
		return ship_to;
	}
	public void setShip_to(int ship_to) {
		this.ship_to = ship_to;
	}
	public int getPo_id() {
		return po_id;
	}
	public void setPo_id(int po_id) {
		this.po_id = po_id;
	}
	public String getPo_no() {
		return po_no;
	}
	public void setPo_no(String po_no) {
		this.po_no = po_no;
	}
	public String getPo_type() {
		return po_type;
	}
	public void setPo_type(String po_type) {
		this.po_type = po_type;
	}
	
}
