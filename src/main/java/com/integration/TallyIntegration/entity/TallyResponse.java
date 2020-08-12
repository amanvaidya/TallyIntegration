/**
 * 
 */
package com.integration.TallyIntegration.entity;

import javax.persistence.Entity;

/**
 * @author Aman
 *
 */

public class TallyResponse {

	private String MasterName;
	private String TallyCount;
	private String TaskDate;
	private String CostcenterName;
	private String TraxxCount;
	public String getMasterName() {
		return MasterName;
	}
	public void setMasterName(String masterName) {
		MasterName = masterName;
	}
	public String getTallyCount() {
		return TallyCount;
	}
	public void setTallyCount(String tallyCount) {
		TallyCount = tallyCount;
	}
	public String getTaskDate() {
		return TaskDate;
	}
	public void setTaskDate(String taskDate) {
		TaskDate = taskDate;
	}
	public String getCostcenterName() {
		return CostcenterName;
	}
	public void setCostcenterName(String costcenterName) {
		CostcenterName = costcenterName;
	}
	public String getTraxxCount() {
		return TraxxCount;
	}
	public void setTraxxCount(String traxxCount) {
		TraxxCount = traxxCount;
	}
	
}
