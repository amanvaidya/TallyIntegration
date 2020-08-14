/**
 * 
 */
package com.integration.TallyIntegration.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integration.TallyIntegration.common.AssetPurchaseCommon;
import com.integration.TallyIntegration.repository.AssetTransferRepository;

/**
 * @author Aman
 *
 */
@Service
public class AssetTransferService {
	@Autowired
	private AssetTransferRepository assetTransferRepository;
	private String assetName="";
	private String assetCost="";
	private String assetCount="";
	private String result="";
	public String finalResult="";
	private String pxml="";
	private String pxmf="";
	private String TXML="";
	private String tQty="";
	private String tCost="";
	private String tTot="";
	public String generateTransferData(String facilityName) {
		List<Object[]> getTransfer = assetTransferRepository.getTransferData(facilityName);
		
		for(Object[] Trsf: getTransfer) {
			facilityName=Trsf[0].toString();
			assetName=Trsf[1].toString();
			assetCost=Trsf[2].toString();
			assetCount=Trsf[3].toString();
			result+=getTopXml(facilityName,assetName,assetCost);
			finalResult=result;
		}
		result="";
		AssetPurchaseCommon assetPurchaseCommon = new AssetPurchaseCommon();
		return assetPurchaseCommon.header+"<VOUCHER>"+finalResult+"</VOUCHER>"+assetPurchaseCommon.footer;
	}
	private String getTopXml(String facilityName,String assetName,String assetCost){
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate= formatter.format(date);  
		String tXML="<TransactionDocumentNo>"+strDate.replace("/", "")+assetCount+assetCost.replace(".","")+"</TransactionDocumentNo>"
					+"<Date>"+strDate+"</Date>"
					+"<Narration>Transfer of "+assetCount+" "+assetName+" from "+facilityName+"</Narration>";
					
		TXML=getLedger(assetName,assetCost,facilityName);
		return tXML+TXML;
	}
	private String getLedger(String assetName,String assetCost,String facilityName) {
		String lXML="<LedgerName>"+assetName+"</LedgerName>"
				+"<ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>"
				+"<ISPARTYLEDGER>No</ISPARTYLEDGER>"
				+"<LedgerAMOUNT>"+assetCost+"</LedgerAMOUNT>"
				+"<CostCentreName>"+facilityName+"</CostCentreName>";
		List<Object[]> getTransferAsset = assetTransferRepository.getTransferDetails(facilityName,assetName);
		for(Object[] getAsset:getTransferAsset) {
			tQty=getAsset[0].toString();
			tCost=getAsset[1].toString();
			tTot=getAsset[2].toString();
			pxml+=getPrdDetails(tQty,tCost,tTot,assetName);
			pxmf=pxml;
		}
		pxml="";
		return "<ALLLedgerEntries>"+lXML+pxmf+"</ALLLedgerEntries>";
	}
	private String getPrdDetails(String tQty,String tCost,String tTot,String assetName) {
		String pXML="<INVENTORYENTRIES>"
				+"<ITEMNAME>"+assetName+"</ITEMNAME>"
				+"<ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>"
				+"<QUANTITY>"+tQty+"</QUANTITY>"
				+"<RATE>"+tCost+"</RATE>"
				+"<AMOUNT>"+tTot+"</AMOUNT>"
				+"</INVENTORYENTRIES>";
		return pXML;
	}
}
