/**
 * 
 */
package com.integration.TallyIntegration.entity;

import java.io.Serializable;

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
@Table(name="tally_transfer_response")
public class TallyTransferResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String transaction_document_no;
	public String getTransaction_document_no() {
		return transaction_document_no;
	}
	public void setTransaction_document_no(String transaction_document_no) {
		this.transaction_document_no = transaction_document_no;
	}
	/**
	 * @param id
	 * @param transaction_document_no
	 */
	public TallyTransferResponse(int id, String transaction_document_no) {
		super();
		this.id = id;
		this.transaction_document_no = transaction_document_no;
	}
	public TallyTransferResponse(String transaction_document_no) {
		super();
		this.transaction_document_no = transaction_document_no;
	}
	public TallyTransferResponse() {
	}
	
	
}
