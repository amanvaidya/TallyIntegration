/**
 * 
 */
package com.integration.TallyIntegration.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integration.TallyIntegration.common.TallyCommon;
import com.integration.TallyIntegration.entity.TaxEntity;
import com.integration.TallyIntegration.repository.TaxRepository;

/**
 * @author Aman
 *
 */
@Service
public class TaxService {
	@Autowired
	private TaxRepository taxRepository;
	String check="";
	String LEDGERNAME;
	String RATEOFTAXCALCULATION;
	String LEDGERCODE;
	String GSTHEAD="";
	String result ="";
	String finalResult = "";
	TallyCommon tallyCommon = new TallyCommon();
	public String PushRequestCreateRequest(String LEDGERNAME, String LEDGERCODE, String RATEOFTAXCALCULATION, String GSTHEAD)
    {             
        String TXML = null;
        
        TXML =  "<LEDGER>"
                + "<MASTERTYPENAME>TAX MASTER</MASTERTYPENAME>"
                + "<LEDGERNAME>"+LEDGERNAME.replace("&", "&amp;")+"</LEDGERNAME>"
                + "<LEDGERCODE>"+LEDGERCODE.replace("&", "&amp;")+"</LEDGERCODE>"
                + "<PARENT>Duties &amp; Taxes</PARENT>"
                + "<TAXTYPE>GST</TAXTYPE>"
                + "<GSTDUTYHEAD>"+GSTHEAD+"</GSTDUTYHEAD>"
                + "<RATEOFTAXCALCULATION>"+RATEOFTAXCALCULATION.replace("&", "&amp;")+"</RATEOFTAXCALCULATION>"
                + "</LEDGER>" ;
        return TXML;
    }
	
	public String CreateRequest() {
		
		List<TaxEntity> getAll=taxRepository.getAll();
		for(TaxEntity list:getAll) {
			LEDGERNAME=list.getLEDGERNAME().replace(System.getProperty("line.separator"), "").replace("\"", "");
			LEDGERCODE = list.getLEDGERCODE().replace(System.getProperty("line.separator"), "").replace("\"", "");
			RATEOFTAXCALCULATION = list.getRATEOFTAXCALCULATION().replace(System.getProperty("line.separator"), "").replace("\"", "");
			if(LEDGERNAME.equals("-")||LEDGERNAME.equals("0")) {
				LEDGERNAME="";
			}
			if(LEDGERCODE.equals("-")||LEDGERCODE.equals("0")) {
				LEDGERCODE="";
			}
			if(RATEOFTAXCALCULATION.equals("-")||RATEOFTAXCALCULATION.equals("0")) {
				RATEOFTAXCALCULATION="";
			}
			if(LEDGERNAME.contains("CGST")) {
				GSTHEAD="Central Tax";
			}else if(LEDGERNAME.contains("IGST")) {
				GSTHEAD="Integrated Tax";
			}else if(LEDGERNAME.contains("SGST")) {
				GSTHEAD="State Tax";
			}else {
				GSTHEAD="";
			}
			result += PushRequestCreateRequest(LEDGERNAME,LEDGERCODE,RATEOFTAXCALCULATION,GSTHEAD);
			finalResult = result;
		}
		result = "";
		return tallyCommon.TallyHeader+finalResult+tallyCommon.TallyFooter;
	}
}
