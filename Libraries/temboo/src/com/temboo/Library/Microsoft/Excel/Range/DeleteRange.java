package com.temboo.Library.Microsoft.Excel.Range;

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
DeleteRange

Deletes the cells associated with the range.
*/
public class DeleteRange extends Choreography {

	/**
	Create a new instance of the DeleteRange Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public DeleteRange(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Microsoft/Excel/Range/DeleteRange"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid Access Token retrieved during the OAuth process. This can be passed if your application is authenticating multiple Office 365 users.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The Client ID provided by Microsoft. This is requried unless providing a valid AccessToken (see optional inputs).
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (conditional, string) The Client Secret provided by Microsoft. This is requried unless providing a valid AccessToken (see optional inputs).
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the ItemPath input for this Choreo. 

	@param String - (required, string) The location of the spreadsheet in OneDrive (e.g. MyFolder/Book.xlsx).
	*/
	public void setItemPath(String value) {
		this.inputs.setInput("ItemPath", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (conditional, password) Your Microsoft password. This is requried unless providing a valid AccessToken (see optional inputs).
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the Range input for this Choreo. 

	@param String - (conditional, string) A cell ange to delete (e.g. A1:B2).
	*/
	public void setRange(String value) {
		this.inputs.setInput("Range", value);
	}


	/** 
	Set the value of the Shift input for this Choreo. 

	@param String - (required, string) Specifies which way to shift the cells.  Possible values are: Up, Left.
	*/
	public void setShift(String value) {
		this.inputs.setInput("Shift", value);
	}


	/** 
	Set the value of the Username input for this Choreo. 

	@param String - (conditional, string) Your Microsoft username. This is requried unless providing a valid AccessToken (see optional inputs).
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	/** 
	Set the value of the Worksheet input for this Choreo. 

	@param String - (required, string) The name or id of the worksheet.
	*/
	public void setWorksheet(String value) {
		this.inputs.setInput("Worksheet", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public DeleteRangeResultSet run() {
		JSONObject result = super.runWithResults();
		return new DeleteRangeResultSet(result);
	}
	
}
