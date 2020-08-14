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
@Table(name="t_grn_assets")
public class GrnDataEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int grn_asset_id;
	private int grn_id;
	private int po_id;
	private int po_asset_id;
	private String grn_qty_recieved;
	private String grn_asset_cost;
	private String grn_asset_value;
	private int group_id;
	private String grn_asset;
	private String grn_asset_desc;
	
	public String getGrn_asset() {
		return grn_asset;
	}
	public void setGrn_asset(String grn_asset) {
		this.grn_asset = grn_asset;
	}
	public int getGrn_asset_id() {
		return grn_asset_id;
	}
	public void setGrn_asset_id(int grn_asset_id) {
		this.grn_asset_id = grn_asset_id;
	}
	public int getGrn_id() {
		return grn_id;
	}
	public void setGrn_id(int grn_id) {
		this.grn_id = grn_id;
	}
	public int getPo_id() {
		return po_id;
	}
	public void setPo_id(int po_id) {
		this.po_id = po_id;
	}
	public int getPo_asset_id() {
		return po_asset_id;
	}
	public void setPo_asset_id(int po_asset_id) {
		this.po_asset_id = po_asset_id;
	}
	public String getGrn_qty_recieved() {
		return grn_qty_recieved;
	}
	public void setGrn_qty_recieved(String grn_qty_recieved) {
		this.grn_qty_recieved = grn_qty_recieved;
	}
	public String getGrn_asset_cost() {
		return grn_asset_cost;
	}
	public void setGrn_asset_cost(String grn_asset_cost) {
		this.grn_asset_cost = grn_asset_cost;
	}
	public String getGrn_asset_value() {
		return grn_asset_value;
	}
	public void setGrn_asset_value(String grn_asset_value) {
		this.grn_asset_value = grn_asset_value;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public String getGrn_asset_desc() {
		return grn_asset_desc;
	}
	public void setGrn_asset_desc(String grn_asset_desc) {
		this.grn_asset_desc = grn_asset_desc;
	}
	
}
