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
import com.integration.TallyIntegration.repository.DepRepo;

/**
 * @author Aman
 *
 */
@Service
public class DepService {
	@Autowired
	private DepRepo depRepo;
	private String result="";
	String finalResult="";
	private String facilityName="";
	private String mDep="";
	private String gxml="";
	private String fgxml="";
	private String cumDep="";
	private String groupName="";
	 
	private String pattern = "dd-MM-yyyy";
	String dateInString =new SimpleDateFormat(pattern).format(new Date());
	
	public String DepreciationRecord(String facility_name, String startDate, String endDate) throws ParseException{
		
		List<Object[]> getAll = depRepo.getAllFacility(facility_name,startDate,endDate);
		for(Object[] depRec:getAll) {
			facilityName = depRec[0].toString();
			mDep=depRec[1].toString();
			result+=generateXML(facilityName,mDep,startDate,endDate);
			finalResult=result;
		}
		result="";
		AssetPurchaseCommon assetPurchaseCommon = new AssetPurchaseCommon();
		return assetPurchaseCommon.header+finalResult+assetPurchaseCommon.footer;
	}
	private String generateXML(String facilityName,String mDep,String startDate, String endDate) throws ParseException {
		SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat out = new SimpleDateFormat("dd-MM-yy");
		Date sdate = in.parse(startDate);
		Date edate = in.parse(endDate);
		String DXML="<TransactionDocumentNo>"+startDate.replace("-","")+endDate.replace("-","")+"</TransactionDocumentNo>"
				+"<Date>"+dateInString+"</Date>"
				+"<Narration>Depreciation Download Date("+out.format(sdate)+" to "+out.format(edate)+")</Narration>"
				+"<ALLLedgerEntries>"
				+"<LedgerName>Depreciation</LedgerName>"
				+"<ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>"
				+"<ISPARTYLEDGER>No</ISPARTYLEDGER>"
				+"<LedgerAMOUNT>"+mDep+"</LedgerAMOUNT>"
				+"<CostCentreName>"+facilityName+"</CostCentreName>"
				+"</ALLLedgerEntries>";
		
		List<Object[]> getGroup=depRepo.getAllGroup(startDate,endDate,facilityName);
		for(Object[] grp:getGroup) {
			groupName=grp[0].toString();
			cumDep=grp[1].toString();
			gxml+=generateGroupXml(facilityName,groupName,cumDep);
			fgxml=gxml;
		}
		gxml="";
		return "<VOUCHER>"+DXML+fgxml+"</VOUCHER>";	
	}
	private String generateGroupXml(String facilityName,String groupName,String cumDep) {
		String GXML="<ALLLedgerEntries>"
					+"<LedgerName>Cumulative Depreciation -"+groupName+"</LedgerName>"
					+"<ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" 
					+"<ISPARTYLEDGER>No</ISPARTYLEDGER>" 
					+"<CostCentreName>"+facilityName+"</CostCentreName>" 
					+"<LedgerAMOUNT>"+cumDep+"</LedgerAMOUNT>" 
					+"</ALLLedgerEntries>";
		return GXML;
	}
}
