/**
 * 
 */
package com.integration.TallyIntegration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integration.TallyIntegration.common.TallyCommon;
import com.integration.TallyIntegration.entity.VendorEntity;
import com.integration.TallyIntegration.repository.VendorRepository;

/**
 * @author Aman
 *
 */
@Service
public class VendorService {
	@Autowired
	private VendorRepository vendorRepository; 
	String NAME;
	String LEDGERCODE;
	String PARENT;
	String BILLCREDITPERIOD;
	String ISCOSTCENTRESON;
	String ADDRESS;
	String ADDRESS1;
	String ADDRESS2;
	String ADDRESS3;
	String EMAIL;
	String PINCODE;
	String INCOMETAXNUMBER;
	String COUNTRYNAME;
	String GSTREGISTRATIONTYPE;
	String PARTYGSTIN;
	String LEDGERCONTACT;
	String LEDGERMOBILE;
	String LEDSTATENAME;
	String result = "";
	String finalResult = "";
	TallyCommon tallyCommon = new TallyCommon();
	public String PustRequest(String NAME,String LEDGERCODE,String BILLCREDITPERIOD,String ADDRESS,String ADDRESS1,String EMAIL,String PINCODE,String INCOMETAXNUMBER,String COUNTRYNAME,String GSTREGISTRATIONTYPE,String PARTYGSTIN,String LEDGERCONTACT,String LEDGERMOBILE,String LEDSTATENAME)
    {             
        String TXML = null;
        
        TXML = "<LEDGER>"
                +"<MASTERTYPENAME>VENDOR MASTER</MASTERTYPENAME> "
                +"<LedgerName>"+NAME.replace("&", "&amp;")+"</LedgerName>"
                +"<LEDGERCODE>"+LEDGERCODE.replace("&", "&amp;")+"</LEDGERCODE>"
                +"<PARENT>Sundry Creditors</PARENT>"
                +"<BILLCREDITPERIOD>"+BILLCREDITPERIOD.replace("&", "&amp;")+"</BILLCREDITPERIOD>"
                +"<ISBILLWISEON>Yes</ISBILLWISEON>"
                +"<ISCOSTCENTRESON>No</ISCOSTCENTRESON>"
                +"<AddressLine1>"+ADDRESS.replace("&", "&amp;")+"</AddressLine1>"
                +"<ADDRESSLine2>"+ADDRESS1.replace("&", "&amp;")+"</ADDRESSLine2>"
                +"<EMAIL>"+EMAIL.replace("&", "&amp;")+"</EMAIL>"
                +"<MailingName>"+NAME.replace("&", "&amp;")+"</MailingName>"
                +"<PINCODE>"+PINCODE.replace("&", "&amp;")+"</PINCODE>"
                +"<INCOMETAXNUMBER>"+INCOMETAXNUMBER.replace("&", "&amp;")+"</INCOMETAXNUMBER>"
                +"<COUNTRYNAME>"+COUNTRYNAME.replace("&", "&amp;")+"</COUNTRYNAME>"
                +"<GSTREGISTRATIONTYPE>"+GSTREGISTRATIONTYPE.replace("&", "&amp;")+"</GSTREGISTRATIONTYPE>"
                +"<PARTYGSTIN>"+PARTYGSTIN.replace("&", "&amp;")+"</PARTYGSTIN>"
                +"<LEDGERCONTACT>"+LEDGERCONTACT.replace("&", "&amp;")+"</LEDGERCONTACT>"
                +"<LEDGERMOBILE>"+LEDGERMOBILE.replace("&", "&amp;")+"</LEDGERMOBILE>"
                +"<LEDSTATENAME>"+LEDSTATENAME.replace("&", "&amp;")+"</LEDSTATENAME>"
                +"</LEDGER>";
        return TXML;
    }
	public String VendorRequest() {
		List<VendorEntity> list= vendorRepository.getAll();
		for(VendorEntity vendorEntity:list) {
			NAME=vendorEntity.getLedgerName().replace(System.getProperty("line.separator"), "").replace("\"", "");
			LEDGERCODE=vendorEntity.getAlias().replace(System.getProperty("line.separator"), "").replace("\"", "");
			BILLCREDITPERIOD=vendorEntity.getCreditDays().replace(System.getProperty("line.separator"), "").replace("\"", "");
			ADDRESS=vendorEntity.getAddressLine1().replace(System.getProperty("line.separator"), "").replace("\"", "");
			ADDRESS1=vendorEntity.getAddressLine2().replace(System.getProperty("line.separator"), "").replace("\"", "");
			EMAIL=vendorEntity.getEmailId().replace(System.getProperty("line.separator"), "").replace("\"", "");
			PINCODE=vendorEntity.getPinCode().replace(System.getProperty("line.separator"), "").replace("\"", "");
			INCOMETAXNUMBER=vendorEntity.getPanNo().replace(System.getProperty("line.separator"), "").replace("\"", "");
			COUNTRYNAME=vendorEntity.getCountry().replace(System.getProperty("line.separator"), "").replace("\"", "");
			GSTREGISTRATIONTYPE=vendorEntity.getGstRegType().replace(System.getProperty("line.separator"), "").replace("\"", "");
			PARTYGSTIN=vendorEntity.getGstInNo().replace(System.getProperty("line.separator"), "").replace("\"", "");
			LEDGERCONTACT=vendorEntity.getContactPerson().replace(System.getProperty("line.separator"), "").replace("\"", "");
			LEDGERMOBILE=vendorEntity.getMobile().replace(System.getProperty("line.separator"), "").replace("\"", "");
			LEDSTATENAME=vendorEntity.getState().replace(System.getProperty("line.separator"), "").replace("\"", "");
			
			if(NAME.equals("-")||NAME.equals("0")) {
				NAME="";
			}
			if(LEDGERCODE.equals("-")||LEDGERCODE.equals("0")) {
				LEDGERCODE="";
			}
			if(BILLCREDITPERIOD.equals("-")||BILLCREDITPERIOD.equals("0")) {
				BILLCREDITPERIOD="";
			}
			if(ADDRESS.equals("-")||ADDRESS.equals("0")) {
				ADDRESS="";
			}
			if(ADDRESS1.equals("-")||ADDRESS1.equals("0")) {
				ADDRESS1="";
			}
			if(EMAIL.equals("-")||EMAIL.equals("0")) {
				EMAIL="";
			}
			if(PINCODE.equals("-")||PINCODE.equals("0")) {
				PINCODE="";
			}
			if(INCOMETAXNUMBER.equals("-")||INCOMETAXNUMBER.equals("0")) {
				INCOMETAXNUMBER="";
			}
			if(COUNTRYNAME.equals("-")||COUNTRYNAME.equals("0")) {
				COUNTRYNAME="";
			}
			if(GSTREGISTRATIONTYPE.equals("-")||GSTREGISTRATIONTYPE.equals("0")) {
				GSTREGISTRATIONTYPE="";
			}
			if(PARTYGSTIN.equals("-")||PARTYGSTIN.equals("0")) {
				PARTYGSTIN="";
			}
			if(LEDGERCONTACT.equals("-")||LEDGERCONTACT.equals("0")) {
				LEDGERCONTACT="";
			}
			if(LEDGERMOBILE.equals("-")||LEDGERMOBILE.equals("0")) {
				LEDGERMOBILE="";
			}
			if(LEDSTATENAME.equals("-")||LEDSTATENAME.equals("0")) {
				LEDSTATENAME="";
			}
			
			result+=PustRequest(NAME,LEDGERCODE,BILLCREDITPERIOD,ADDRESS,ADDRESS1,EMAIL,PINCODE,INCOMETAXNUMBER,COUNTRYNAME,GSTREGISTRATIONTYPE,PARTYGSTIN,LEDGERCONTACT,LEDGERMOBILE,LEDSTATENAME);
			finalResult = result;
		}
		result = "";
		return tallyCommon.TallyHeader+finalResult+tallyCommon.TallyFooter;
	}
}
