package com.temboo.Library.Microsoft.Excel.Table;

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
CreateTableRow

Creates new rows in a table.
*/
public class CreateTableRow extends Choreography {

	/**
	Create a new instance of the CreateTableRow Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateTableRow(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Microsoft/Excel/Table/CreateTableRow"));
	}

	/** 
	Set the value of the Values input for this Choreo. 

	@param String - (required, json) This is an array of arrays. The outer array can represent one or more rows while the inner array can represent one or more cell values. See Choreo notes below for more details.
	*/
	public void setValues(String value) {
		this.inputs.setInput("Values", value);
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
	Set the value of the Index input for this Choreo. 

	@param Integer - (optional, integer) Indicates that the row should be created at this index.
	*/
	public void setIndex(Integer value) {
		this.inputs.setInput("Index", value);
	}

	/** 
	Set the value of the Index input for this Choreo as a String. 

	@param String - (optional, integer) Indicates that the row should be created at this index.
	*/
	public void setIndex(String value) {
		this.inputs.setInput("Index", value);	
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
	Set the value of the Table input for this Choreo. 

	@param String - (required, string) The name or id of the table to write to (e.g. Table1).
	*/
	public void setTable(String value) {
		this.inputs.setInput("Table", value);
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

	@param String - (required, string) The name or id of the worksheet to write to (e.g. Sheet1).
	*/
	public void setWorksheet(String value) {
		this.inputs.setInput("Worksheet", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateTableRowResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateTableRowResultSet(result);
	}
	
}