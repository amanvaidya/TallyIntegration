/**
 * 
 */
package com.integration.TallyIntegration.service;

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
	
	public String DepreciationRecord(String facility_name) {
		List<Object[]> getAll = depRepo.getAllFacility(facility_name);
		for(Object[] depRec:getAll) {
			facilityName = depRec[0].toString();
			mDep=depRec[1].toString();
			result+=generateXML(facilityName,mDep);
			finalResult=result;
		}
		result="";
		AssetPurchaseCommon assetPurchaseCommon = new AssetPurchaseCommon();
		return assetPurchaseCommon.header+finalResult+assetPurchaseCommon.footer;
	}
	private String generateXML(String facilityName, String mDep) {
		String DXML="<TransactionDocumentNo>10892</TransactionDocumentNo>"
				+"<Date>01-04-2020</Date>"
				+"<Narration>Test2</Narration>"
				+"<ALLLedgerEntries>"
				+"<LedgerName>Depreciation</LedgerName>"
				+"<ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>"
				+"<ISPARTYLEDGER>No</ISPARTYLEDGER>"
				+"<LedgerAMOUNT>"+mDep+"</LedgerAMOUNT>"
				+"<CostCentreName>"+facilityName+"</CostCentreName>"
				+"</ALLLedgerEntries>";
		
		List<Object[]> getGroup=depRepo.getAllGroup();
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
