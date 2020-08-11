/**
 * 
 */
package com.integration.TallyIntegration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integration.TallyIntegration.common.TallyCommon;
import com.integration.TallyIntegration.entity.ProductEntity;
import com.integration.TallyIntegration.repository.ProductRepository;

/**
 * @author Aman
 *
 */

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	String Name;
	String PartNo;
	String Description;
	String Group;
	String UOM;
	String HSNCode;
	String result ="";
	String finalResult = "";
	TallyCommon tallyCommon = new TallyCommon();
	public String PustRequest(String Name,String PartNo,String Description,String Group,String UOM,String HSNCode)
    {             
        String TXML = null;
        
        TXML = "<STOCKITEM>"
                +"<STOCKITEMNAME>"+Name.replace("&", "&amp;")+"</STOCKITEMNAME>"
                +"<MAILINGNAME>"+PartNo.replace("&", "&amp;")+"</MAILINGNAME>"
                +"<DESCRIPTION>"+Description.replace("&", "&amp;")+"</DESCRIPTION>"
                +"<PARENT>"+Group.replace("&", "&amp;")+"</PARENT>"
                +"<BASEUNITS>"+UOM.replace("&", "&amp;")+"</BASEUNITS>"
                +"<HSNCODE>"+HSNCode.replace("&", "&amp;")+"</HSNCODE>"
                +"<HSNDescription></HSNDescription>"
                +"<TaxRate></TaxRate>"
                +"<COSTINGMETHOD>FIFO</COSTINGMETHOD>"
                +"<VALUATIONMETHOD>Avg. Price</VALUATIONMETHOD>"
                +"</STOCKITEM>";
        return TXML;
    }
	public String ProductRequest() {
		List<ProductEntity> list = productRepository.getAll();
		for(ProductEntity productEntity:list) {
			Name=productEntity.getAssetName().replaceAll("\n", "").trim();
			PartNo=productEntity.getPartNo().replace(System.getProperty("line.separator"), "").replace("\"", "").trim();
			Description=productEntity.getDescription().replace(System.getProperty("line.separator"), "").replace("\"", "").trim();
			Group=productEntity.getSubgroup_name().replace(System.getProperty("line.separator"), "").replace("\"", "").trim();
			UOM=productEntity.getUnit_name().replace(System.getProperty("line.separator"), "").replace("\"", "").trim();
			HSNCode=productEntity.getHSNCode().replace(System.getProperty("line.separator"), "").replace("\"", "").trim();
			if(Name.equals("-")||Name.equals("0")) {
				Name="";
			}
			if(PartNo.equals("-")||PartNo.equals("0")) {
				PartNo="";
			}
			if(Description.equals("-")||Description.equals("0")) {
				Description="";
			}
			if(Group.equals("-")||Group.equals("0")) {
				Group="";
			}
			if(UOM.equals("-")||UOM.equals("0")) {
				UOM="";
			}
			if(UOM.equals("-")||UOM.equals("0")) {
				HSNCode="";
			}
			result += PustRequest(Name,PartNo,Description,Group,UOM,HSNCode);
			finalResult = result;
		}
		result = "";
		return tallyCommon.TallyHeader+finalResult+tallyCommon.TallyFooter;
	}
}
