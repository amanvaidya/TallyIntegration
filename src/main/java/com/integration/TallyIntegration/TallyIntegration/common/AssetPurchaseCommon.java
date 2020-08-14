/**
 * 
 */
package com.integration.TallyIntegration.common;

/**
 * @author Aman
 *
 */
public class AssetPurchaseCommon {
	public String header="<ENVELOPE>" 
			+"<BODY>" 
			+"<DATA>"
			+"<IMPORTDATA>"
			+"<VOUCHERS>";
	public String footer="</VOUCHERS>"
			+"</IMPORTDATA>"
			+"</DATA>"
			+"</BODY>"
			+"</ENVELOPE>";
}
