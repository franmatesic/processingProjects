package com.temboo.Library.Google.BigQuery.Jobs;

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
Query

Runs a BigQuery SQL query and returns results if the query completes within a specified timeout. When a query timeout occurs, results can be retrieved using the Job ID returned in the response.
*/
public class Query extends Choreography {

	/**
	Create a new instance of the Query Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Query(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/BigQuery/Jobs/Query"));
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

	@param String - (optional, string) The ID of the dataset that your table belongs to.
	*/
	public void setDatasetID(String value) {
		this.inputs.setInput("DatasetID", value);
	}


	/** 
	Set the value of the DryRun input for this Choreo. 

	@param Boolean - (optional, boolean) If set to true, BigQuery doesn't run the job. Instead, if the query is valid, BigQuery returns statistics about the job such as how many bytes would be processed. Defaults to false.
	*/
	public void setDryRun(Boolean value) {
		this.inputs.setInput("DryRun", value);
	}

	/** 
	Set the value of the DryRun input for this Choreo as a String. 

	@param String - (optional, boolean) If set to true, BigQuery doesn't run the job. Instead, if the query is valid, BigQuery returns statistics about the job such as how many bytes would be processed. Defaults to false.
	*/
	public void setDryRun(String value) {
		this.inputs.setInput("DryRun", value);	
	}
	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) Selector specifying which fields to include in a partial response.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the MaxResults input for this Choreo. 

	@param Integer - (optional, integer) Maximum number of results to return. Defaults to 100. Max is 1000.
	*/
	public void setMaxResults(Integer value) {
		this.inputs.setInput("MaxResults", value);
	}

	/** 
	Set the value of the MaxResults input for this Choreo as a String. 

	@param String - (optional, integer) Maximum number of results to return. Defaults to 100. Max is 1000.
	*/
	public void setMaxResults(String value) {
		this.inputs.setInput("MaxResults", value);	
	}
	/** 
	Set the value of the PageToken input for this Choreo. 

	@param String - (optional, string) Page token, returned by a previous call, identifying the result set.
	*/
	public void setPageToken(String value) {
		this.inputs.setInput("PageToken", value);
	}


	/** 
	Set the value of the ProjectID input for this Choreo. 

	@param String - (required, string) The ID of your Google API project.
	*/
	public void setProjectID(String value) {
		this.inputs.setInput("ProjectID", value);
	}


	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (required, string) A query to execute. Example: SELECT count(f1) FROM [myProjectId:myDatasetId.myTableId].
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth Refresh Token used to generate a new Access Token when the original token is expired. Required unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the TimeoutMs input for this Choreo. 

	@param Integer - (optional, integer) How long to wait for the query to complete, in milliseconds, before the request times out and returns. Defaults to 10000.
	*/
	public void setTimeoutMs(Integer value) {
		this.inputs.setInput("TimeoutMs", value);
	}

	/** 
	Set the value of the TimeoutMs input for this Choreo as a String. 

	@param String - (optional, integer) How long to wait for the query to complete, in milliseconds, before the request times out and returns. Defaults to 10000.
	*/
	public void setTimeoutMs(String value) {
		this.inputs.setInput("TimeoutMs", value);	
	}
	/** 
	Set the value of the UseQueryCache input for this Choreo. 

	@param Boolean - (optional, boolean) Whether to look for the result in the query cache. Defaults to true.
	*/
	public void setUseQueryCache(Boolean value) {
		this.inputs.setInput("UseQueryCache", value);
	}

	/** 
	Set the value of the UseQueryCache input for this Choreo as a String. 

	@param String - (optional, boolean) Whether to look for the result in the query cache. Defaults to true.
	*/
	public void setUseQueryCache(String value) {
		this.inputs.setInput("UseQueryCache", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public QueryResultSet run() {
		JSONObject result = super.runWithResults();
		return new QueryResultSet(result);
	}
	
}
