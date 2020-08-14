/**
 * 
 */
package com.integration.TallyIntegration.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
@Table(name = "subgroup_master")
public class SubgroupEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int subgroup_id;
	private String subgroup_name;
	
	@OneToMany(mappedBy="subgroup_id", fetch = FetchType.LAZY)
	private Set<ProductEntity> products=new HashSet<>();
	
	public int getSubgroup_id() {
		return subgroup_id;
	}
	public void setSubgroup_id(int subgroup_id) {
		this.subgroup_id = subgroup_id;
	}
	public String getSubgroup_name() {
		return subgroup_name;
	}
	public void setSubgroup_name(String subgroup_name) {
		this.subgroup_name = subgroup_name;
	}
	
	public SubgroupEntity() {}
	

}
