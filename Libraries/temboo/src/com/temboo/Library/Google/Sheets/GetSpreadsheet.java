package com.temboo.Library.Google.Sheets;

/*
Copyright 2014 Temboo, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

import processing.data.JSONArray;
import processing.data.JSONObject;
import java.math.BigDecimal;
import com.temboo.core.Choreography;
import com.temboo.core.Choreography.ResultSet;
import com.temboo.core.TembooException;
import com.temboo.core.TembooPath;
import com.temboo.core.TembooSession;

/** 
GetSpreadsheet

Returns the spreadsheet at the given ID.
*/
public class GetSpreadsheet extends Choreography {

	/**
	Create a new instance of the GetSpreadsheet Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetSpreadsheet(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Sheets/GetSpreadsheet"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid access token retrieved during the OAuth process. This is required unless you provide the ClientID, ClientSecret, and RefreshToken to generate a new access token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The Client ID provided by Google. Required unless providing a valid AccessToken.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (conditional, string) The Client Secret provided by Google. Required unless providing a valid AccessToken.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) A comma-separated list of fields to include in the response. See Choreo notes for syntax details.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the IncludeGridData input for this Choreo. 

	@param Boolean - (optional, boolean) Set to True if grid data should be returned.
	*/
	public void setIncludeGridData(Boolean value) {
		this.inputs.setInput("IncludeGridData", value);
	}

	/** 
	Set the value of the IncludeGridData input for this Choreo as a String. 

	@param String - (optional, boolean) Set to True if grid data should be returned.
	*/
	public void setIncludeGridData(String value) {
		this.inputs.setInput("IncludeGridData", value);	
	}
	/** 
	Set the value of the Ranges input for this Choreo. 

	@param String - (optional, string) The A1 notation of the values to retrieve formatted as an array (e.g. ["Sheet1!A2:C3"]). Note, this input support up to 10 ranges.
	*/
	public void setRanges(String value) {
		this.inputs.setInput("Ranges", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth refresh token used to generate a new access token when the original token is expired. Required unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the SpreadsheetID input for this Choreo. 

	@param String - (required, string) The ID of the spreadsheet. This can be found in the URL when viewing your spreadsheet in your web browser.
	*/
	public void setSpreadsheetID(String value) {
		this.inputs.setInput("SpreadsheetID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetSpreadsheetResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetSpreadsheetResultSet(result);
	}
	
}
