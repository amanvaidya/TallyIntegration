/**
 * 
 */
package com.integration.TallyIntegration.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integration.TallyIntegration.common.AssetPurchaseCommon;
import com.integration.TallyIntegration.repository.HardwareRepository;

/**
 * @author Aman
 *
 */
@Service
public class HardwareService {

	@Autowired
	private HardwareRepository hardwareRepository; 
	
	
	private String invoicenumber, invoicedate, ponumber, podate;
	private String result = "";
	private String xml="";
	private String gxml="";
	private String pxml="";
	private String cost="";
	private String gcost="";
	private String dcost="";
	private String dqty="";
	private String groupId="";
	private String groupName="";
	private String vendorName="";
	protected String vendorId="";
	private String assetdesc="";
	private String facilityName="";
	String finalResult;
	public String HardwareRequest() {
		List<Object[]> getAll = hardwareRepository.getAllDetails();
		for(Object hardwareEntity[]:getAll) {
			
			
			invoicenumber=hardwareEntity[0].toString().replace("&", "&amp;");
			invoicedate=hardwareEntity[1].toString().replace("&", "&amp;");
			ponumber=hardwareEntity[2].toString().replace("&", "&amp;");
			podate=hardwareEntity[3].toString().replace("&", "&amp;");
			vendorName=hardwareEntity[4].toString().replace("&", "&amp;");
			facilityName=hardwareEntity[5].toString().replace("&", "&amp;");
			groupId=hardwareEntity[6].toString().replace("&", "&amp;");
			groupName=hardwareEntity[7].toString().replace("&", "&amp;");
			assetdesc=hardwareEntity[8].toString().replace("&", "&amp;");
			result+=findCount(invoicenumber,invoicedate,ponumber,podate, vendorName,facilityName,groupId,groupName,assetdesc);
			finalResult=result;
		}
		result="";
		AssetPurchaseCommon assetPurchaseCommon = new AssetPurchaseCommon();
		
		return assetPurchaseCommon.header+finalResult+assetPurchaseCommon.footer;
	}
	
	private String findCount(String invoicenumber,String invoicedate, String ponumber, String podate, String vendorName, String facilityName,String groupId, String groupName, String assetdesc) {
		cost = hardwareRepository.findCount(ponumber);
		gcost= hardwareRepository.findGCount(groupId,ponumber);
		dcost= hardwareRepository.findDCost(groupId,ponumber,assetdesc);
		dqty= hardwareRepository.findDCount(groupId,ponumber,assetdesc);
		xml = generateXML(invoicenumber,invoicedate,ponumber,podate,cost,vendorName,facilityName,groupName,assetdesc,groupId,gcost,dcost,dqty);
		
		return  "<VOUCHER>"+xml+"</VOUCHER>";
	}
	private String generateXML(String invoicenumber,String invoicedate,String ponumber,String podate,String cost, String vendorName,String facilityName, String groupName, String assetdesc,String groupId,String gcost,String dcost,String dqty) {
		String TXML="<SUPPLIERINVOICENO>"+invoicenumber+"</SUPPLIERINVOICENO>"
					+"<INVOICEDATE>"+invoicedate+"</INVOICEDATE>"
					+"<ORDERNO>"+ponumber+"</ORDERNO>"
					+"<ORDERDATE>"+podate+"</ORDERDATE>"
					+"<VENDORNAME>"+vendorName+"</VENDORNAME>"
					+"<TOTALINVENTORYAMOUNT>"+cost+"</TOTALINVENTORYAMOUNT>"
					+"<Narration>Test1</Narration>"
					+"<ALLLedgerEntries>"
                    +"<LedgerName>"+vendorName+"</LedgerName>"
                    +"<ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>"
                    +"<ISPARTYLEDGER>Yes</ISPARTYLEDGER>"
                    +"<LedgerAMOUNT>"+cost+"</LedgerAMOUNT>"
                    +"<CostCentreName>"+facilityName+"</CostCentreName>"
                    +"<INVENTORYENTRIES></INVENTORYENTRIES>"
                    +"</ALLLedgerEntries>";
		gxml= generateGroup(facilityName,groupName,assetdesc,groupId,ponumber,gcost,dcost,dqty);
		return TXML+gxml;
	}
	private String generateGroup(String facilityName, String groupName, String assetdesc,String groupId,String ponumber,String gcost,String dcost,String dqty) {
		
		String GXML="<LedgerName>"+groupName+"</LedgerName>"
				+"<ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>"
				+"<ISPARTYLEDGER>No</ISPARTYLEDGER>"
				+"<CostCentreName>"+facilityName+"</CostCentreName>"
				+"<LedgerAMOUNT>"+gcost+"</LedgerAMOUNT>";
		pxml = generateProduct(assetdesc,groupId,ponumber,gcost,dcost,dqty);
		return "<ALLLedgerEntries>"+GXML+pxml+"</ALLLedgerEntries>";
	}
	private String generateProduct(String assetdesc,String groupId,String ponumber,String gcost,String dcost,String dqty) {
		
		String PXML="<INVENTORYENTRIES>"
					+"<ITEMNAME>"+assetdesc+"</ITEMNAME>"
					+"<ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>"
					+"<ITEMCODE></ITEMCODE>"
					+"<QUANTITY>"+dqty+"</QUANTITY>"
					+"<RATE></RATE>"
					+"<AMOUNT>"+dcost+"</AMOUNT>"
					+"</INVENTORYENTRIES>";
		return PXML;
	}
}
