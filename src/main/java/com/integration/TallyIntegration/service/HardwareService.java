/**
 * 
 */
package com.integration.TallyIntegration.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integration.TallyIntegration.common.AssetPurchaseCommon;
import com.integration.TallyIntegration.repository.AssetTaxMap;
import com.integration.TallyIntegration.repository.HardwareRepository;

/**
 * @author Aman
 *
 */
@Service
public class HardwareService {

	@Autowired
	private HardwareRepository hardwareRepository; 
	@Autowired
	private AssetTaxMap assetTaxMap;
	
	private String invoicenumber, invoicedate, ponumber, podate;
	private String result = "";
	private String xml="";
	private String gxml="";
	private String gxmf="";
	private String pxml="";
	private String cost="";
	private String taxl="";
	private String taxf="";
	private String gcost="";
	private String dcost="";
	private String dqty="";
	private String groupId="";
	private String groupName="";
	private String vendorName="";
	protected String vendorId="";
	private String assetdesc="";
	private String facilityName="";
	private String itemCode="";
	private String CxPer="";
	private String CxAmt="";
	private String SxPer="";
	private String SxAmt="";
	private String IxPer="";
	private String IxAmt="";
	private String TAML="";
	private String SAML="";
	private String IAML="";
	private String CName="";
	private String SName="";
	private String IName="";
	String finalResult;
	public String HardwareRequest(String facility_name) {
		List<Object[]> getAll = hardwareRepository.getAllDetails(facility_name);
		for(Object hardwareEntity[]:getAll) {
			invoicenumber=hardwareEntity[0].toString().replace("&", "&amp;");
			invoicedate=hardwareEntity[1].toString().replace("&", "&amp;");
			ponumber=hardwareEntity[2].toString().replace("&", "&amp;");
			podate=hardwareEntity[3].toString().replace("&", "&amp;");
			vendorName=hardwareEntity[4].toString().replace("&", "&amp;");
			facilityName=hardwareEntity[5].toString().replace("&", "&amp;");
			result+=findCount(invoicenumber,invoicedate,ponumber,podate, vendorName,facilityName);
			finalResult=result;
		}
		result="";
		AssetPurchaseCommon assetPurchaseCommon = new AssetPurchaseCommon();
		return assetPurchaseCommon.header+finalResult+assetPurchaseCommon.footer;
	}
	
	private String findCount(String invoicenumber,String invoicedate, String ponumber, String podate, String vendorName, String facilityName) {
		cost = hardwareRepository.findCount(ponumber);
		xml = generateXML(invoicenumber,invoicedate,ponumber,podate,cost,vendorName,facilityName);
		return  "<VOUCHER>"+xml+"</VOUCHER>";
	}
	private String generateXML(String invoicenumber,String invoicedate,String ponumber,String podate,String cost, String vendorName,String facilityName) {
		String TXML="<SUPPLIERINVOICENO>"+invoicenumber+"</SUPPLIERINVOICENO>"
					+"<INVOICEDATE>"+invoicedate+"</INVOICEDATE>"
					+"<ORDERNO>"+ponumber+"</ORDERNO>"
					+"<ORDERDATE>"+podate+"</ORDERDATE>"
					+"<VENDORNAME>"+vendorName+"</VENDORNAME>"
					+"<TOTALINVENTORYAMOUNT>"+cost+"</TOTALINVENTORYAMOUNT>"
					+"<Narration>Test1</Narration>"
					+"<ALLLedgerEntries>"
                    +"<LedgerName>"+vendorName+"</LedgerName>"
                    +"<ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>"
                    +"<ISPARTYLEDGER>Yes</ISPARTYLEDGER>"
                    +"<LedgerAMOUNT>"+cost+"</LedgerAMOUNT>"
                    +"<CostCentreName>"+facilityName+"</CostCentreName>"
                    +"<INVENTORYENTRIES></INVENTORYENTRIES>"
                    +"</ALLLedgerEntries>";
		List<Object[]> getGroupDesc = hardwareRepository.getGroupDesc(ponumber);
		for(Object grpDesc[]:getGroupDesc) {
			groupId=grpDesc[0].toString();
			groupName=grpDesc[1].toString();
			assetdesc=grpDesc[2].toString();
			gxml+=generateGroup(facilityName,groupName,assetdesc,ponumber,groupId);
			gxmf=gxml;
		}
		gxml="";
		/*For Taxes*/
		int appPoId=0;
		appPoId=assetTaxMap.getPoId(ponumber);
		List<Object[]> getTaxes=assetTaxMap.getAllTaxes(appPoId);
		for(Object getTax[]:getTaxes) {
			CxPer=getTax[0].toString()==null?"":getTax[0].toString();
			CxAmt=getTax[1].toString()==null?"":getTax[1].toString();
			SxPer=getTax[2].toString()==null?"":getTax[2].toString();
			SxAmt=getTax[3].toString()==null?"":getTax[3].toString();
			IxPer=getTax[4].toString()==null?"":getTax[4].toString();
			IxAmt=getTax[5].toString()==null?"":getTax[5].toString();
			taxl+=generateTax(facilityName,CxPer,CxAmt,SxPer,SxAmt,IxPer,IxAmt);
			taxf= taxl;
		}
		taxl="";
		/*Ends Here*/
		return TXML+gxmf+taxf;
	}
	private String generateGroup(String facilityName, String groupName, String assetdesc,String ponumber, String groupId) {
		gcost = hardwareRepository.findGCount(groupId,ponumber);
		String GXML="<TransactionDocumentNo></TransactionDocumentNo>"
				+"<TransactionDocumentDate></TransactionDocumentDate>"
				+"<LedgerName>"+groupName+"</LedgerName>"
				+"<ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>"
				+"<ISPARTYLEDGER>No</ISPARTYLEDGER>"
				+"<CostCentreName>"+facilityName+"</CostCentreName>"
				+"<LedgerAMOUNT>"+gcost+"</LedgerAMOUNT>";
		pxml = generateProduct(groupId,ponumber,assetdesc);
		
		return "<ALLLedgerEntries>"+GXML+pxml+"</ALLLedgerEntries>";
	}
	private String generateProduct(String groupId,String ponumber,String assetdesc) {
		dqty = hardwareRepository.findDCount(groupId, ponumber, assetdesc);
		dcost= hardwareRepository.findDCost(groupId, ponumber, assetdesc);
		itemCode= assetTaxMap.getItemCode(assetdesc)==null?"":assetTaxMap.getItemCode(assetdesc);
		String PXML="<INVENTORYENTRIES>"
					+"<ITEMNAME>"+assetdesc+"</ITEMNAME>"
					+"<ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>"
					+"<ITEMCODE>"+itemCode.replace("-", "")+"</ITEMCODE>"
					+"<QUANTITY>"+dqty+"</QUANTITY>"
					+"<RATE>"+dcost+"</RATE>"
					+"<AMOUNT>"+dcost+"</AMOUNT>"
					+"</INVENTORYENTRIES>";
		return PXML;
	}
	private String generateTax(String facilityName,String CxPer,String CxAmt,String SxPer,String SxAmt,String IxPer,String IxAmt) {
		if(CxPer.equals("0")||CxPer.equals(null)||CxPer.equals("-")||CxPer.equals("0.0")) {
			TAML="";
		}else {
			CName = assetTaxMap.getCTName(CxPer);
			TAML="<ALLLedgerEntries>"
					+"<LedgerName>"+CName+"</LedgerName>"
					+"<ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>"
					+"<ISPARTYLEDGER>No</ISPARTYLEDGER>"
					+"<LedgerAMOUNT>"+CxAmt+"</LedgerAMOUNT>"
					+"<CostCentreName>"+facilityName+"</CostCentreName>"
					+"<INVENTORYENTRIES></INVENTORYENTRIES>"
					+"</ALLLedgerEntries>";
		}
		if(SxPer.equals("0")||SxPer.equals(null)||SxPer.equals("-")||SxPer.equals("0.0")) {
			SAML="";
		}else {
			SName = assetTaxMap.getSTName(SxPer);
			SAML="<ALLLedgerEntries>"
					+"<LedgerName>"+SName+"</LedgerName>"
					+"<ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>"
					+"<ISPARTYLEDGER>No</ISPARTYLEDGER>"
					+"<LedgerAMOUNT>"+SxAmt+"</LedgerAMOUNT>"
					+"<CostCentreName>"+facilityName+"</CostCentreName>"
					+"<INVENTORYENTRIES></INVENTORYENTRIES>"
					+"</ALLLedgerEntries>";
		}
		if(IxPer.equals("0")||IxPer.equals(null)||IxPer.equals("-")||IxPer.equals("0.0")) {
			IAML="";
		}else {
			IName = assetTaxMap.getSTName(IxPer);
			IAML="<ALLLedgerEntries>"
					+"<LedgerName>"+IName+"</LedgerName>"
					+"<ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>"
					+"<ISPARTYLEDGER>No</ISPARTYLEDGER>"
					+"<LedgerAMOUNT>"+IxAmt+"</LedgerAMOUNT>"
					+"<CostCentreName>"+facilityName+"</CostCentreName>"
					+"<INVENTORYENTRIES></INVENTORYENTRIES>"
					+"</ALLLedgerEntries>";
		}
		return TAML+SAML+IAML;
	}
}
