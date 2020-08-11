/**
 * 
 */
package com.integration.TallyIntegration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integration.TallyIntegration.common.TallyCommon;
import com.integration.TallyIntegration.entity.AssetMasterEntity;
import com.integration.TallyIntegration.repository.AssetMasterRepository;

/**
 * @author Aman
 *
 */
@Service
public class AssetsMasterService {

	@Autowired 
	private AssetMasterRepository assetMasterRepository;
	String subgroupName;
	String subgroupCode;
	String result="";
	String finalResult = "";
	TallyCommon tallyCommon = new TallyCommon();
	public String PushRequest(String subgroupName, String subgroupCode)
    {             
        String TXML = null;
        
        TXML ="<LEDGER>"
                +"<LedgerName>"+subgroupName.replace("&", "&amp;")+"</LedgerName>"
                +"<LEDGERCODE>"+subgroupCode.replace("&", "&amp;")+"</LEDGERCODE>"
                +"<PARENT>"+subgroupName.replace("&", "&amp;")+"</PARENT>"
                +"<ISBILLWISEON>No</ISBILLWISEON>"
                +"<ISCOSTCENTRESON>Yes</ISCOSTCENTRESON>"
                +"<ISINVENTORYON>Yes</ISINVENTORYON>"
                +"<GSTAPPLICABLE>No</GSTAPPLICABLE>"
                +"<HSNCODE></HSNCODE>"
                +"<IGSTRate></IGSTRate>"
                +"</LEDGER>";
        return TXML;
    }
	public String AssetMasterRequest() {
		List<AssetMasterEntity> list = assetMasterRepository.getAll();
		for(AssetMasterEntity assetMasterEntity:list) {
			subgroupName=assetMasterEntity.getSubgroup_name().replace(System.getProperty("line.separator"), "").replace("\"", "");
			subgroupCode=assetMasterEntity.getSubgroup_code().replace(System.getProperty("line.separator"), "").replace("\"", "");
			if(subgroupName.equals("-")||subgroupName.equals("0")) {
				subgroupName="";
			}
			if(subgroupCode.equals("-")||subgroupCode.equals("0")) {
				subgroupCode="";
			}
			result+=PushRequest(subgroupName,subgroupCode);
			finalResult = result;
		}
		result="";
		return tallyCommon.TallyHeader+finalResult+tallyCommon.TallyFooter;
	}
}
