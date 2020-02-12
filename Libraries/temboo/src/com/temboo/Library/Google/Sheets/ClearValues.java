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
ClearValues

Clears values from a spreadsheet.
*/
public class ClearValues extends Choreography {

	/**
	Create a new instance of the ClearValues Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ClearValues(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Sheets/ClearValues"));
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
	Set the value of the Range input for this Choreo. 

	@param String - (required, string) The A1 notation of the values to clear (e.g. Sheet1!A2:C3).
	*/
	public void setRange(String value) {
		this.inputs.setInput("Range", value);
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
	public ClearValuesResultSet run() {
		JSONObject result = super.runWithResults();
		return new ClearValuesResultSet(result);
	}
	
}
