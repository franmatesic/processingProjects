package com.temboo.Library.Microsoft.Excel.Workbook;

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
InvokeFunction

Invokes a workbook function.
*/
public class InvokeFunction extends Choreography {

	/**
	Create a new instance of the InvokeFunction Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public InvokeFunction(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Microsoft/Excel/Workbook/InvokeFunction"));
	}

	/** 
	Set the value of the Arguments input for this Choreo. 

	@param String - (required, json) A JSON object containing the function arguments. See Choreo notes for more details.
	*/
	public void setArguments(String value) {
		this.inputs.setInput("Arguments", value);
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
	Set the value of the Function input for this Choreo. 

	@param String - (required, string) The name of the function (e.g. vlookup).
	*/
	public void setFunction(String value) {
		this.inputs.setInput("Function", value);
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
	Set the value of the Username input for this Choreo. 

	@param String - (conditional, string) Your Microsoft username. This is requried unless providing a valid AccessToken (see optional inputs).
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public InvokeFunctionResultSet run() {
		JSONObject result = super.runWithResults();
		return new InvokeFunctionResultSet(result);
	}
	
}
