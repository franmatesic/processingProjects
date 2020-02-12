package com.temboo.Library.Dropbox.Files;

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
Search

Searches for files and folders.
*/
public class Search extends Choreography {

	/**
	Create a new instance of the Search Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Search(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dropbox/Files/Search"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token for a specific Dropbox user.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the MaxResults input for this Choreo. 

	@param Boolean - (optional, boolean) The maximum number of search results to return. The default for this field is 100.
	*/
	public void setMaxResults(Boolean value) {
		this.inputs.setInput("MaxResults", value);
	}

	/** 
	Set the value of the MaxResults input for this Choreo as a String. 

	@param String - (optional, boolean) The maximum number of search results to return. The default for this field is 100.
	*/
	public void setMaxResults(String value) {
		this.inputs.setInput("MaxResults", value);	
	}
	/** 
	Set the value of the Mode input for this Choreo. 

	@param String - (optional, string) The search mode (filename, filename_and_content, or deleted_filename). Note that searching file content is only available for Dropbox Business accounts. The default for this union is filename.
	*/
	public void setMode(String value) {
		this.inputs.setInput("Mode", value);
	}


	/** 
	Set the value of the Path input for this Choreo. 

	@param String - (conditional, string) Path in the user's Dropbox to search. This should be empty to search at the root level.
	*/
	public void setPath(String value) {
		this.inputs.setInput("Path", value);
	}


	/** 
	Set the value of the Query input for this Choreo. 

	@param Boolean - (optional, boolean) The string to search for. 
	*/
	public void setQuery(Boolean value) {
		this.inputs.setInput("Query", value);
	}

	/** 
	Set the value of the Query input for this Choreo as a String. 

	@param String - (optional, boolean) The string to search for. 
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);	
	}
	/** 
	Set the value of the Start input for this Choreo. 

	@param Integer - (optional, integer) The starting index within the search results (used for paging). The default for this field is 0.
	*/
	public void setStart(Integer value) {
		this.inputs.setInput("Start", value);
	}

	/** 
	Set the value of the Start input for this Choreo as a String. 

	@param String - (optional, integer) The starting index within the search results (used for paging). The default for this field is 0.
	*/
	public void setStart(String value) {
		this.inputs.setInput("Start", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchResultSet(result);
	}
	
}
