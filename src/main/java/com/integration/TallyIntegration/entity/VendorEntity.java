/**
 * 
 */
package com.integration.TallyIntegration.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Aman
 *
 */
@XmlRootElement
@Entity
@Table(name="vendor_master")
public class VendorEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int vendor_id;
	@Column(name="vendor_code", insertable = false, updatable = false)
	private String Alias;
	@Column(name="vendor_name", insertable = false, updatable = false)
	private String LedgerName;
	@Column(name="creditdays", insertable = false, updatable = false)
	private String CreditDays;
	@Column(name="vendor_name", insertable = false, updatable = false)
	private String MailingName;
	@Column(name="vendor_add1", insertable = false, updatable = false)
	private String AddressLine1;
	@Column(name="vendor_add2", insertable = false, updatable = false)
	private String AddressLine2;
	@Column(name="vendor_country", insertable = false, updatable = false)
	private String Country;
	@Column(name="vendor_state", insertable = false, updatable = false)
	private String State;
	@Column(name="vendor_pincode", insertable = false, updatable = false)
	private String PinCode;
	@Column(name="vendor_contact1", insertable = false, updatable = false)
	private String ContactPerson;
	@Column(name="vendor_mailid1", insertable = false, updatable = false)
	private String EmailId;
	@Column(name="vendor_pan_no", insertable = false, updatable = false)
	private String PanNo;
	@Column(name="vendor_kst_no", insertable = false, updatable = false)
	private String GstInNo;
	@Column(name="vendor_mob1", insertable = false, updatable = false)
	private String Mobile;
	
	
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getAlias() {
		return Alias;
	}
	public void setAlias(String alias) {
		Alias = alias;
	}
	public String getLedgerName() {
		return LedgerName;
	}
	public void setLedgerName(String ledgerName) {
		LedgerName = ledgerName;
	}
	public String getCreditDays() {
		return CreditDays;
	}
	public void setCreditDays(String creditDays) {
		CreditDays = creditDays;
	}
	public String getMailingName() {
		return MailingName;
	}
	public void setMailingName(String mailingName) {
		MailingName = mailingName;
	}
	public String getAddressLine1() {
		return AddressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return AddressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getPinCode() {
		return PinCode;
	}
	public void setPinCode(String pinCode) {
		PinCode = pinCode;
	}
	public String getContactPerson() {
		return ContactPerson;
	}
	public void setContactPerson(String contactPerson) {
		ContactPerson = contactPerson;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getPanNo() {
		return PanNo;
	}
	public void setPanNo(String panNo) {
		PanNo = panNo;
	}
	public String getGstInNo() {
		return GstInNo;
	}
	public void setGstInNo(String gstInNo) {
		GstInNo = gstInNo;
	}
	public String getGstRegType() {
		if(GstInNo.equals("")||GstInNo.equals("-")) {
			return "Unregistered";
		}else {
			return "Regular";
		}
	}
	public String getGroup() {
		return "Sundry Creditors";
	}
	
	/**
	 * @param alias
	 * @param ledgerName
	 * @param creditDays
	 * @param mailingName
	 * @param addressLine1
	 * @param addressLine2
	 * @param country
	 * @param state
	 * @param pinCode
	 * @param contactPerson
	 * @param emailId
	 * @param panNo
	 * @param gstInNo
	 * @param mobile
	 */
	public VendorEntity(String alias, String ledgerName, String creditDays, String mailingName, String addressLine1,
			String addressLine2, String country, String state, String pinCode, String contactPerson, String emailId,
			String panNo, String gstInNo, String mobile) {
		super();
		Alias = alias;
		LedgerName = ledgerName;
		CreditDays = creditDays;
		MailingName = mailingName;
		AddressLine1 = addressLine1;
		AddressLine2 = addressLine2;
		Country = country;
		State = state;
		PinCode = pinCode;
		ContactPerson = contactPerson;
		EmailId = emailId;
		PanNo = panNo;
		GstInNo = gstInNo;
		Mobile = mobile;
	}
	public VendorEntity() {}
	
}
