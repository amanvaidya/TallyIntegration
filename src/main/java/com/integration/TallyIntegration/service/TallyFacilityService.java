/**
 * 
 */
package com.integration.TallyIntegration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integration.TallyIntegration.common.TallyCommon;
import com.integration.TallyIntegration.entity.TallyFacilityEntity;
import com.integration.TallyIntegration.repository.TallyFacilityRepository;

/**
 * @author Aman
 *
 */
@Service
public class TallyFacilityService {
	@Autowired
	private TallyFacilityRepository tallyFacilityRepository;
	String CategoryName="";
	String CostCentreName="";
	String result="";
	String finalResult = "";
	TallyCommon tallyCommon = new TallyCommon();
	public String PushRequest(String CategoryName, String CostCentreName)
    {             
        String TXML = null;
        
        TXML = "<CostCentres>"
        		+"<PrimaryCostCategory>"+CategoryName.replace("&", "&amp;")+"</PrimaryCostCategory>"
                +"<CostCentreName>"+CostCentreName.replace("&", "&amp;")+"</CostCentreName>"
                +"</CostCentres>";
        return TXML;
    }
	public String CostcenterRequest() {
		List<TallyFacilityEntity> list= tallyFacilityRepository.getAll();
		for(TallyFacilityEntity tallyFacilityEntity:list) {
			CategoryName=tallyFacilityEntity.getCategoryName().replace(System.getProperty("line.separator"), "").replace("\"", "");
			CostCentreName=tallyFacilityEntity.getCostcenterName().replace(System.getProperty("line.separator"), "").replace("\"", "");
			if(CategoryName.equals("-")||CategoryName.equals("0")) {
				CategoryName="";
			}
			if(CostCentreName.equals("-")||CostCentreName.equals("0")) {
				CostCentreName="";
			}
			result += PushRequest(CategoryName, CostCentreName); 
			finalResult = result;
		}
		result = "";
		return tallyCommon.TallyHeader+finalResult+tallyCommon.TallyFooter;
	}
}
