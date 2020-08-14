/**
 * 
 */
package com.integration.TallyIntegration.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integration.TallyIntegration.common.AssetPurchaseCommon;

import com.integration.TallyIntegration.repository.AssetPurchaseRepository;


/**
 * @author Aman
 *
 */
@Service
public class AssetPurchaseService {
	@Autowired
	private AssetPurchaseRepository assetPurchaseRepository;
	
	private int facility_id;
	private String poNumber;
	private String poType;
	private String poId;
	private String result = "";
	private String grnNumber = "";
	private String grnDate;
	private String invNumber = "";
	private String invDate;
	private String poDate;
	private String venName = "";
	private String totlCost = "";
	private String grnId = "";
	private String grpName = "";
	private String grpVal = "";
	private String gxml = "";
	private String gxmf = "";
	private String groupId = "";
	private String prodDesc = "";
	private String qtyRec = "";
	private String utPrice = "";
	private String totPrice = "";
	private String itemCode = "";
	private String pxml = "";
	private String pxmf = "";
	public String finalResult = "";
	private String cGST="";
	private String sGST="";
	private String iGST="";
	private String taxTOT="";
	private String IAML="";
	private String TAML="";
	private String SAML="";
	private String txml = "";
	private String txmf = "";
	private double cPer=0.0;
	private double gPer;
	private double iPer;
	private double tPer;
	private double ctaxAmt;
	private double gtaxAmt;
	private double itaxAmt;
	public String getPurchaseData(String facilityName) throws ParseException {
		facility_id = assetPurchaseRepository.getFacilityId(facilityName);

		List<Object[]> poNo = assetPurchaseRepository.getPoNumber(facility_id);
		for (Object poNum[] : poNo) {
			poId = poNum[0].toString();
			poNumber = poNum[1].toString();
			poType = poNum[2].toString();
			System.out.println(poNumber);
			result += getPurchaseDetails(poId, poNumber, poType, facilityName);
			finalResult = result;
		}
		result = "";
		AssetPurchaseCommon assetPurchase = new AssetPurchaseCommon();
		return assetPurchase.header + finalResult + assetPurchase.footer;
	}

	private String getPurchaseDetails(String poId, String poNumber, String poType, String facilityName)
			throws ParseException {
		if (poType.equals("Capex") || poType.equals("Purchase")) {
			List<Object[]> capDetails = assetPurchaseRepository.getGrnDetails(poNumber);
			for (Object[] grnDetail : capDetails) {
				grnNumber = grnDetail[0].toString();
				grnDate = grnDetail[1].toString();
				invNumber = grnDetail[2].toString();
				invDate = grnDetail[3].toString();
				poDate = grnDetail[4].toString();
				venName = grnDetail[5].toString();
				totlCost = grnDetail[6].toString();
				grnId = grnDetail[7].toString();
			}
		} else {
			List<Object[]> capDetails = assetPurchaseRepository.getSrnDetails(poNumber);
			for (Object[] grnDetail : capDetails) {
				grnNumber = grnDetail[0].toString();
				grnDate = grnDetail[1].toString();
				invNumber = grnDetail[2].toString();
				invDate = grnDetail[3].toString();
				poDate = grnDetail[4].toString();
				venName = grnDetail[5].toString();
				totlCost = grnDetail[6].toString();
				grnId = grnDetail[7].toString();
			}
		}
		SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		SimpleDateFormat out = new SimpleDateFormat("dd-MM-yy");
		Date gdate = in.parse(grnDate);
		Date idate = in.parse(invDate);
		Date pdate = in.parse(poDate);

		String TXML = "<TransactionDocumentNo>" + grnNumber + "</TransactionDocumentNo>" + "<TransactionDocumentDate>"
				+ out.format(gdate) + "</TransactionDocumentDate>" + "<SUPPLIERINVOICENO>" + invNumber
				+ "</SUPPLIERINVOICENO>" + "<INVOICEDATE>" + out.format(idate) + "</INVOICEDATE>" + "<ORDERNO>"
				+ poNumber + "</ORDERNO>" + "<ORDERDATE>" + out.format(pdate) + "</ORDERDATE>" + "<VENDORNAME>"
				+ venName + "</VENDORNAME>" + "<TOTALINVENTORYAMOUNT>" + totlCost + "</TOTALINVENTORYAMOUNT>"
				+ "<Narration>Order No-" + poNumber + ", Order Date -" + out.format(pdate) + ", Supplier Invoice No"
				+ out.format(idate) + ", Invoice Date -" + invDate + "</Narration>" + "<ALLLedgerEntries>"
				+ "<LedgerName>" + venName + "</LedgerName>" + "<ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>"
				+ "<ISPARTYLEDGER>Yes</ISPARTYLEDGER>" + "<LedgerAMOUNT>" + totlCost + "</LedgerAMOUNT>"
				+ "<CostCentreName>" + facilityName + "</CostCentreName>" + "<INVENTORYENTRIES></INVENTORYENTRIES>"
				+ "</ALLLedgerEntries>";
		if (poType.equals("Capex") || poType.equals("Purchase")) {
			List<Object[]> getGrp = assetPurchaseRepository.getGroupDetails(grnId);
			for (Object[] grp : getGrp) {
				grpName = grp[0].toString();
				grpVal = grp[1].toString();
				groupId = grp[2].toString();
				gxml += groupDetails(grpName, grpVal, facilityName, groupId, grnId, poType);
				gxmf = gxml;
			}
			int ipoId = Integer.parseInt(poId);
			int igrnId=Integer.parseInt(grnId);
			List<Object[]> getTax=assetPurchaseRepository.getGTaxDetails(ipoId,igrnId);
			System.out.println("is it");
			for(Object[] tAX:getTax) {
				cGST=tAX[0].toString();
				sGST=tAX[1].toString();
				iGST=tAX[2].toString();
				taxTOT=tAX[3].toString();
				txml+=getTaxDetails(cGST,sGST,iGST,taxTOT,facilityName);
				txmf=txml;
			}
		} else {
			List<Object[]> getGrp = assetPurchaseRepository.getSGroupDetails(grnId);
			for (Object[] grp : getGrp) {
				grpName = grp[0].toString();
				grpVal = grp[1].toString();
				groupId = grp[2].toString();
				gxml += groupDetails(grpName, grpVal, facilityName, groupId, grnId, poType);
				gxmf = gxml;
			}
			int ipoId = Integer.parseInt(poId);
			int igrnId=Integer.parseInt(grnId);
			List<Object[]> getTax=assetPurchaseRepository.getSTaxDetails(ipoId,igrnId);
			for(Object[] tAX:getTax) {
				System.out.println("and what am i"+cGST);
				cGST=tAX[0].toString();
				sGST=tAX[1].toString();
				iGST=tAX[2].toString();
				taxTOT=tAX[3].toString();
				txml+=getTaxDetails(cGST,sGST,iGST,taxTOT,facilityName);	
				txmf=txml;
			}
			
		}
		
		txml="";	
		gxml = "";
		System.out.println(txml);
		return "<VOUCHER>" + TXML + gxmf + txmf + "</VOUCHER>";
	}

	private String groupDetails(String grpName, String grpVal, String facilityName, String groupId, String grnId,
			String poType) {
		String GXML = "<LedgerName>" + grpName + "</LedgerName>" + "<ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>"
				+ "<ISPARTYLEDGER>No</ISPARTYLEDGER>" + "<CostCentreName>" + facilityName + "</CostCentreName>"
				+ "<LedgerAMOUNT>" + grpVal + "</LedgerAMOUNT>";
		if (poType.equals("Capex") || poType.equals("Purchase")) {
			List<Object[]> getGrnAsset = assetPurchaseRepository.getGrnAssetDetails(Integer.parseInt(groupId), Integer.parseInt(grnId));
			for (Object[] grnAsset : getGrnAsset) {
				prodDesc = grnAsset[0].toString();
				qtyRec = grnAsset[1].toString();
				utPrice = grnAsset[2].toString();
				totPrice = grnAsset[3].toString();
				itemCode = grnAsset[4].toString();
				pxml += getProductDetails(prodDesc, qtyRec, utPrice, totPrice, itemCode);
				pxmf = pxml;
			}
		}else {
			List<Object[]> getGrnAsset = assetPurchaseRepository.getSGrnAssetDetails(Integer.parseInt(groupId),Integer.parseInt(grnId));
			for (Object[] grnAsset : getGrnAsset) {
				prodDesc = grnAsset[0].toString();
				qtyRec = grnAsset[1].toString();
				utPrice = grnAsset[2].toString();
				totPrice = grnAsset[3].toString();
				itemCode = grnAsset[4].toString();
				pxml += getProductDetails(prodDesc, qtyRec, utPrice, totPrice, itemCode);
				pxmf = pxml;
			}
		}
		pxml = "";
		return "<ALLLedgerEntries>" + GXML + pxmf + "</ALLLedgerEntries>";
	}

	private String getProductDetails(String prodDesc, String qtyRec, String utPrice, String totPrice, String itemCode) {
		String PXML = "<INVENTORYENTRIES>" + "<ITEMNAME>" + prodDesc + "</ITEMNAME>"
				+ "<ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>" + "<ITEMCODE>" + itemCode + "</ITEMCODE>" + "<QUANTITY>"
				+ qtyRec + "</QUANTITY>" + "<RATE>" + utPrice + "</RATE>" + "<AMOUNT>" + totPrice + "</AMOUNT>"
				+ "</INVENTORYENTRIES>";

		return PXML;
	}
	private String getTaxDetails(String cGST,String sGST,String iGST,String taxTOT,String facilityName) {
		cPer=Float.parseFloat(cGST);
		gPer=Float.parseFloat(sGST);
		iPer=Float.parseFloat(iGST);
		tPer=Float.parseFloat(taxTOT);
		ctaxAmt=taxFormula(tPer,cPer);
		gtaxAmt=taxFormula(tPer,gPer);
		 itaxAmt=taxFormula(tPer,iPer);
		System.out.println("Am i here or not"+cGST);
		if(cGST.equals("0")||cGST.equals(null)||cGST.equals("-")||cGST.equals("0.0")) {
			TAML="";
		}else {
			TAML="<ALLLedgerEntries>"
					+"<LedgerName>"+assetPurchaseRepository.getCTax(cGST)+"</LedgerName>"
					+"<ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>"
					+"<ISPARTYLEDGER>No</ISPARTYLEDGER>"
					+"<LedgerAMOUNT>"+ctaxAmt+"</LedgerAMOUNT>"
					+"<CostCentreName>"+facilityName+"</CostCentreName>"
					+"<INVENTORYENTRIES></INVENTORYENTRIES>"
					+"</ALLLedgerEntries>";
			
		}
		if(sGST.equals("0")||sGST.equals(null)||sGST.equals("-")||sGST.equals("0.0")) {
			SAML="";
		}else {

			SAML="<ALLLedgerEntries>"
					+"<LedgerName>"+assetPurchaseRepository.getGTax(sGST)+"</LedgerName>"
					+"<ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>"
					+"<ISPARTYLEDGER>No</ISPARTYLEDGER>"
					+"<LedgerAMOUNT>"+gtaxAmt+"</LedgerAMOUNT>"
					+"<CostCentreName>"+facilityName+"</CostCentreName>"
					+"<INVENTORYENTRIES></INVENTORYENTRIES>"
					+"</ALLLedgerEntries>";
		}
		if(iGST.equals("0")||iGST.equals(null)||iGST.equals("-")||iGST.equals("0.0")) {
			IAML="";
			
		}else {
			
			IAML="<ALLLedgerEntries>"
					+"<LedgerName>"+assetPurchaseRepository.getITax(iGST)+"</LedgerName>"
					+"<ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>"
					+"<ISPARTYLEDGER>No</ISPARTYLEDGER>"
					+"<LedgerAMOUNT>"+itaxAmt+"</LedgerAMOUNT>"
					+"<CostCentreName>"+facilityName+"</CostCentreName>"
					+"<INVENTORYENTRIES></INVENTORYENTRIES>"
					+"</ALLLedgerEntries>";
		}
		return TAML+SAML+IAML;
	}
	private double taxFormula(double taxTOT,double tax)
	{
		return ((taxTOT*tax)/100);
	}
}
