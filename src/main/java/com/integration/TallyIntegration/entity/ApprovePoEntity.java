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
@Table(name="t_approve_po")
public class ApprovePoEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int approvepo_id;
	private String po_no;
	
	public int getApprovepo_id() {
		return approvepo_id;
	}
	public void setApprovepo_id(int approvepo_id) {
		this.approvepo_id = approvepo_id;
	}
	public String getPo_no() {
		return po_no;
	}
	public void setPo_no(String po_no) {
		this.po_no = po_no;
	}
}
