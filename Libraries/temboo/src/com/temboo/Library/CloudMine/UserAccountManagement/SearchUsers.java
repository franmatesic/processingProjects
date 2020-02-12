package com.temboo.Library.CloudMine.UserAccountManagement;

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
SearchUsers

Allows you to search for users using CloudMine's search query language syntax.
*/
public class SearchUsers extends Choreography {

	/**
	Create a new instance of the SearchUsers Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchUsers(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/CloudMine/UserAccountManagement/SearchUsers"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by CloudMine after registering your app.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the ApplicationIdentifier input for this Choreo. 

	@param String - (required, string) The application identifier provided by CloudMine after registering your app.
	*/
	public void setApplicationIdentifier(String value) {
		this.inputs.setInput("ApplicationIdentifier", value);
	}


	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (required, string) Search query for which users to retrieve.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	/** 
	Set the value of the SessionToken input for this Choreo. 

	@param String - (required, string) The session token for an existing user (returned by the AccountLogin Choreo).
	*/
	public void setSessionToken(String value) {
		this.inputs.setInput("SessionToken", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchUsersResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchUsersResultSet(result);
	}
	
}
