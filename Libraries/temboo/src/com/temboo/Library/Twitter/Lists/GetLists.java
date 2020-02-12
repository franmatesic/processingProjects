package com.temboo.Library.Twitter.Lists;

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
GetLists

Retrieves all lists the authenticating or specified user subscribes to, including lists that they own.
*/
public class GetLists extends Choreography {

	/**
	Create a new instance of the GetLists Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetLists(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twitter/Lists/GetLists"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token provided by Twitter or retrieved during the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AccessTokenSecret input for this Choreo. 

	@param String - (required, string) The Access Token Secret provided by Twitter or retrieved during the OAuth process.
	*/
	public void setAccessTokenSecret(String value) {
		this.inputs.setInput("AccessTokenSecret", value);
	}


	/** 
	Set the value of the ConsumerKey input for this Choreo. 

	@param String - (required, string) The API Key (or Consumer Key) provided by Twitter.
	*/
	public void setConsumerKey(String value) {
		this.inputs.setInput("ConsumerKey", value);
	}


	/** 
	Set the value of the ConsumerSecret input for this Choreo. 

	@param String - (required, string) The API Secret (or Consumer Secret) provided by Twitter.
	*/
	public void setConsumerSecret(String value) {
		this.inputs.setInput("ConsumerSecret", value);
	}


	/** 
	Set the value of the Reverse input for this Choreo. 

	@param Boolean - (optional, boolean) When set to true, owned lists will be returned first in the response.
	*/
	public void setReverse(Boolean value) {
		this.inputs.setInput("Reverse", value);
	}

	/** 
	Set the value of the Reverse input for this Choreo as a String. 

	@param String - (optional, boolean) When set to true, owned lists will be returned first in the response.
	*/
	public void setReverse(String value) {
		this.inputs.setInput("Reverse", value);	
	}
	/** 
	Set the value of the ScreenName input for this Choreo. 

	@param String - (optional, string) The screen name of the user for whom to return results for. If not provided, the subscriptions for the authenticating user are returned.
	*/
	public void setScreenName(String value) {
		this.inputs.setInput("ScreenName", value);
	}


	/** 
	Set the value of the UserId input for this Choreo. 

	@param String - (optional, string) The ID of the user for whom to return results for. If not provided, the subscriptions for the authenticating user are returned.
	*/
	public void setUserId(String value) {
		this.inputs.setInput("UserId", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetListsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetListsResultSet(result);
	}
	
}
