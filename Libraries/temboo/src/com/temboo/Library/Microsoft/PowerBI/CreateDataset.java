package com.temboo.Library.Microsoft.PowerBI;

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
CreateDataset

Creates a new Dataset from a JSON schema definition and returns the Dataset ID and the properties of the dataset created.
*/
public class CreateDataset extends Choreography {

	/**
	Create a new instance of the CreateDataset Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateDataset(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Microsoft/PowerBI/CreateDataset"));
	}

	/** 
	Set the value of the SchemaDefinition input for this Choreo. 

	@param String - (required, json) A JSON object containing information about the dataset table and columns. See Choreo notes for formatting details.
	*/
	public void setSchemaDefinition(String value) {
		this.inputs.setInput("SchemaDefinition", value);
	}


	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid Access Token retrieved during the OAuth process. This can be passed if your application is authenticating multiple Power BI users.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The Client ID provided by Power BI. This is requried unless providing a valid AccessToken (see optional inputs).
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (conditional, string) The Client Secret provided by Power BI. This is requried unless providing a valid AccessToken (see optional inputs).
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the DefaultRetentionPolicy input for this Choreo. 

	@param String - (optional, string) Enables a default retention policy to automatically clean up old data while keeping a constant flow of new data going into your dashboard. Valid values are: None (the default) or basicFIFO.
	*/
	public void setDefaultRetentionPolicy(String value) {
		this.inputs.setInput("DefaultRetentionPolicy", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (conditional, password) Your Power BI password. This is requried unless providing a valid AccessToken (see optional inputs).
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the Username input for this Choreo. 

	@param String - (conditional, string) Your Power BI username. This is requried unless providing a valid AccessToken (see optional inputs).
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateDatasetResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateDatasetResultSet(result);
	}
	
}
