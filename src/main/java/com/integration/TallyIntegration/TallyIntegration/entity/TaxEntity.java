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

/**
 * @author Aman
 *
 */
@Entity
@Table(name = "tax_master")
public class TaxEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tax_id")
	private int id;
	@Column(name="tax_name")
	private String LEDGERNAME;
	@Column(name="tax_per")
	private String RATEOFTAXCALCULATION;
	@Column(name="tax_code")
	private String LEDGERCODE;
	
	public TaxEntity() {}
	public TaxEntity(String LEDGERNAME) {
		this.LEDGERNAME=LEDGERNAME;
	}
	public TaxEntity(String LEDGERNAME, String LEDGERCODE, String RATEOFTAXCALCULATION) {
		this.LEDGERNAME=LEDGERNAME;
		this.LEDGERCODE=LEDGERCODE;
		this.RATEOFTAXCALCULATION=RATEOFTAXCALCULATION;
	}
	
	public String getLEDGERNAME() {
		return LEDGERNAME;
	}
	public void setLEDGERNAME(String lEDGERNAME) {
		LEDGERNAME = lEDGERNAME;
	}
	public String getRATEOFTAXCALCULATION() {
		return RATEOFTAXCALCULATION;
	}
	public void setRATEOFTAXCALCULATION(String rATEOFTAXCALCULATION) {
		RATEOFTAXCALCULATION = rATEOFTAXCALCULATION;
	}
	public String getLEDGERCODE() {
		return LEDGERCODE;
	}
	public void setLEDGERCODE(String lEDGERCODE) {
		LEDGERCODE = lEDGERCODE;
	}
	
	
}
