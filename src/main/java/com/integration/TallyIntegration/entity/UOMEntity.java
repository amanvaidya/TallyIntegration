/**
 * 
 */
package com.integration.TallyIntegration.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Aman
 *
 */
@Entity
@Table(name = "uom_master")
public class UOMEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="unit_id")
	private int uom;
	private String unit_name;
	
	@OneToMany(mappedBy="uom", fetch = FetchType.LAZY)
	private Set<ProductEntity> products=new HashSet<>();
	
	public int getUnit_id() {
		return uom;
	}
	public void setUnit_id(int unit_id) {
		this.uom = unit_id;
	}
	public String getUnit_name() {
		return unit_name;
	}
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}
	public UOMEntity() {}
	
}
