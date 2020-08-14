/**
 * 
 */
package com.integration.TallyIntegration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Aman
 *
 */
@Entity
@Table(name="product_master")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int prod_id; 
	@Column(name="product_name")
	private String AssetName;
	@Column(name="item_code")
	private String PartNo;
	@Column(name="product_desc")
	private String Description;
	@Column(name="hsn_sac")
	private String HSNCode;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uom", nullable = false)
	private UOMEntity uom;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subgroup_id", nullable = false)
	private SubgroupEntity subgroup_id;
	
	public String getSubgroup_name() {
		return subgroup_id.getSubgroup_name();
	}
	
	public String getUnit_name() {
		return uom.getUnit_name();
	}
	@JsonIgnore
	public UOMEntity getUom() {
		return uom;
	}
	
	@JsonIgnore
	public void setUom(UOMEntity uom) {
		this.uom = uom;
	}

	@JsonIgnore
	public SubgroupEntity getSubgroup_id() {
		return subgroup_id;
	}

	@JsonIgnore
	public void setSubgroup_id(SubgroupEntity subgroup_id) {
		this.subgroup_id = subgroup_id;
	}

	

	public String getAssetName() {
		return AssetName;
	}

	public void setAssetName(String assetName) {
		AssetName = assetName;
	}

	public String getPartNo() {
		return PartNo;
	}

	public void setPartNo(String partNo) {
		PartNo = partNo;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getHSNCode() {
		return HSNCode;
	}

	public void setHSNCode(String hSNCode) {
		HSNCode = hSNCode;
	}

	public String getHSNDescription() {
		return "";
	}

	public String getTax() {
		return "NA";
	}

	/**
	 * @param assetName
	 * @param partNo
	 * @param description
	 * @param hSNCode
	 * @param uom
	 * @param subgroup_id
	 */
	public ProductEntity(String assetName, String partNo, String description, String hSNCode, UOMEntity uom,
			SubgroupEntity subgroup_id) {
		super();
		AssetName = assetName;
		PartNo = partNo;
		Description = description;
		HSNCode = hSNCode;
		this.uom = uom;
		this.subgroup_id = subgroup_id;
	}
	
	public ProductEntity() {}
	
	
}
