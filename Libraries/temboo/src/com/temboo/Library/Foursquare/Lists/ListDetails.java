package com.temboo.Library.Foursquare.Lists;

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
ListDetails

Returns details about a given list. 
*/
public class ListDetails extends Choreography {

	/**
	Create a new instance of the ListDetails Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListDetails(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Foursquare/Lists/ListDetails"));
	}

	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) Number of results to return, up to 500.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) Number of results to return, up to 500.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the ListID input for this Choreo. 

	@param String - (required, string) The id of a user-created or followed list or an id for a tip or todo in the form of USER_ID/tips or USER_ID/todos. When getting tips or todos for the acting user, the user id is not required.
	*/
	public void setListID(String value) {
		this.inputs.setInput("ListID", value);
	}


	/** 
	Set the value of the OauthToken input for this Choreo. 

	@param String - (required, string) The Foursquare API OAuth token string.
	*/
	public void setOauthToken(String value) {
		this.inputs.setInput("OauthToken", value);
	}


	/** 
	Set the value of the Offset input for this Choreo. 

	@param Integer - (optional, integer) Used to page through results.
	*/
	public void setOffset(Integer value) {
		this.inputs.setInput("Offset", value);
	}

	/** 
	Set the value of the Offset input for this Choreo as a String. 

	@param String - (optional, integer) Used to page through results.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (optional, string) Identity of the user to get lists for. Defaults to "self" to get lists of the acting user.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListDetailsResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListDetailsResultSet(result);
	}
	
}
