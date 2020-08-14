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
@Table(name="iut_request_assets")
public class AssetMovementDetailEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String ast_id;
	private int iut_req_id;
	private String ast_name;
	private String ast_desc;
	private String approval_status;
	
	public String getAst_id() {
		return ast_id;
	}
	public void setAst_id(String ast_id) {
		this.ast_id = ast_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIut_req_id() {
		return iut_req_id;
	}
	public void setIut_req_id(int iut_req_id) {
		this.iut_req_id = iut_req_id;
	}
	public String getAst_name() {
		return ast_name;
	}
	public void setAst_name(String ast_name) {
		this.ast_name = ast_name;
	}
	public String getAst_desc() {
		return ast_desc;
	}
	public void setAst_desc(String ast_desc) {
		this.ast_desc = ast_desc;
	}
	public String getApproval_status() {
		return approval_status;
	}
	public void setApproval_status(String approval_status) {
		this.approval_status = approval_status;
	}
	
}
