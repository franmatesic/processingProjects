package com.temboo.Library.Dropbox.OAuth;

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
FromOAuth1

Creates an OAuth 2.0 access token from the supplied OAuth 1.0 access token.
*/
public class FromOAuth1 extends Choreography {

	/**
	Create a new instance of the FromOAuth1 Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public FromOAuth1(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dropbox/OAuth/FromOAuth1"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) An OAuth 1.0 access token for a specific Dropbox user.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AccessTokenSecret input for this Choreo. 

	@param String - (required, string) An OAuth 1.0 access token secret for a specific Dropbox user.
	*/
	public void setAccessTokenSecret(String value) {
		this.inputs.setInput("AccessTokenSecret", value);
	}


	/** 
	Set the value of the AppKey input for this Choreo. 

	@param String - (required, string) The App Key provided by Dropbox after registering your application.
	*/
	public void setAppKey(String value) {
		this.inputs.setInput("AppKey", value);
	}


	/** 
	Set the value of the AppSecret input for this Choreo. 

	@param String - (required, string) The App Secret provided by Dropbox after registering your application.
	*/
	public void setAppSecret(String value) {
		this.inputs.setInput("AppSecret", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public FromOAuth1ResultSet run() {
		JSONObject result = super.runWithResults();
		return new FromOAuth1ResultSet(result);
	}
	
}
