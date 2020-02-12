package com.temboo.Library.Google.BigQuery.TableData;

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
InsertAll

Streams data into BigQuery one record at a time.
*/
public class InsertAll extends Choreography {

	/**
	Create a new instance of the InsertAll Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public InsertAll(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/BigQuery/TableData/InsertAll"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid Access Token retrieved during the OAuth process. This is required unless you provide the ClientID, ClientSecret, and RefreshToken to generate a new Access Token.
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
	Set the value of the DatasetID input for this Choreo. 

	@param String - (required, string) The ID of the dataset that your table belongs to.
	*/
	public void setDatasetID(String value) {
		this.inputs.setInput("DatasetID", value);
	}


	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) Selector specifying which fields to include in a partial response.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the IgnoreUnknownValues input for this Choreo. 

	@param Boolean - (optional, boolean) Accept rows that contain values that do not match the schema. The unknown values are ignored. Default is false, which treats unknown values as errors.
	*/
	public void setIgnoreUnknownValues(Boolean value) {
		this.inputs.setInput("IgnoreUnknownValues", value);
	}

	/** 
	Set the value of the IgnoreUnknownValues input for this Choreo as a String. 

	@param String - (optional, boolean) Accept rows that contain values that do not match the schema. The unknown values are ignored. Default is false, which treats unknown values as errors.
	*/
	public void setIgnoreUnknownValues(String value) {
		this.inputs.setInput("IgnoreUnknownValues", value);	
	}
	/** 
	Set the value of the ProjectID input for this Choreo. 

	@param String - (required, string) The ID of your Google API project.
	*/
	public void setProjectID(String value) {
		this.inputs.setInput("ProjectID", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth Refresh Token used to generate a new Access Token when the original token is expired. Required unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the Rows input for this Choreo. 

	@param String - (conditional, json) The rows to insert. This should be a JSON array containing at least one object representing a row. See Choreo notes for formatting details.
	*/
	public void setRows(String value) {
		this.inputs.setInput("Rows", value);
	}


	/** 
	Set the value of the TableID input for this Choreo. 

	@param String - (required, string) The ID of the BigQuery table to insert a row into.
	*/
	public void setTableID(String value) {
		this.inputs.setInput("TableID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public InsertAllResultSet run() {
		JSONObject result = super.runWithResults();
		return new InsertAllResultSet(result);
	}
	
}
