/**
 * 
 */
package com.integration.TallyIntegration.common;

/**
 * @author Aman
 *
 */
public class TallyCommon {
	public String TallyHeader="<ENVELOPE>"
    		+ "<HEADER><TALLYREQUEST>Import Data</TALLYREQUEST></HEADER>"
            + "<BODY>"
            + "<IMPORTDATA>"
            + "<REQUESTDATA>"
            + "<TALLYMESSAGE>";
	public String TallyFooter="</TALLYMESSAGE>"
            + "</REQUESTDATA>"
            + "</IMPORTDATA>"
            + "</BODY>"
            + "</ENVELOPE>";

}
