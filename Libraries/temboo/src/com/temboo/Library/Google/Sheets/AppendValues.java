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
AppendValues

Appends values to a spreadsheet.
*/
public class AppendValues extends Choreography {

	/**
	Create a new instance of the AppendValues Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AppendValues(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Sheets/AppendValues"));
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
	Set the value of the InsertDataOption input for this Choreo. 

	@param String - (optional, string) Specifies how the input data should be inserted. Valid values are: INSERT_ROWS (the default) and OVERWRITE.
	*/
	public void setInsertDataOption(String value) {
		this.inputs.setInput("InsertDataOption", value);
	}


	/** 
	Set the value of the MajorDimension input for this Choreo. 

	@param String - (optional, string) Indicates the dimension that the values array applies to. Valid values are ROWS (the default) or COLUMNS.
	*/
	public void setMajorDimension(String value) {
		this.inputs.setInput("MajorDimension", value);
	}


	/** 
	Set the value of the Range input for this Choreo. 

	@param String - (optional, string) The A1 notation of a range to begin appending to. Defaults to "A1" (begins at the first row). Values will be appended at the first empty row of this range. See Choreos notes for more details.
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
	Set the value of the ValueInputOption input for this Choreo. 

	@param String - (optional, string) Specifies how the input data should be interpreted. Valid values are: RAW (the default) and USER_ENTERED.
	*/
	public void setValueInputOption(String value) {
		this.inputs.setInput("ValueInputOption", value);
	}


	/** 
	Set the value of the Values input for this Choreo. 

	@param String - (required, json) This is an array of arrays. The outer array can represent one or more rows while the inner array can represent one or more cell values. See Choreo notes below for more details.
	*/
	public void setValues(String value) {
		this.inputs.setInput("Values", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AppendValuesResultSet run() {
		JSONObject result = super.runWithResults();
		return new AppendValuesResultSet(result);
	}
	
}
