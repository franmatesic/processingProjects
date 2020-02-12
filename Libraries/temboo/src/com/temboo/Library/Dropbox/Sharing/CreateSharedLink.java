package com.temboo.Library.Dropbox.Sharing;

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
CreateSharedLink

Creates a shared link.
*/
public class CreateSharedLink extends Choreography {

	/**
	Create a new instance of the CreateSharedLink Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateSharedLink(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dropbox/Sharing/CreateSharedLink"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token for a specific Dropbox user.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Path input for this Choreo. 

	@param String - (required, string) The path to share.
	*/
	public void setPath(String value) {
		this.inputs.setInput("Path", value);
	}


	/** 
	Set the value of the ShortURL input for this Choreo. 

	@param Boolean - (optional, boolean) Whether to return a shortened URL. The default for this field is false.
	*/
	public void setShortURL(Boolean value) {
		this.inputs.setInput("ShortURL", value);
	}

	/** 
	Set the value of the ShortURL input for this Choreo as a String. 

	@param String - (optional, boolean) Whether to return a shortened URL. The default for this field is false.
	*/
	public void setShortURL(String value) {
		this.inputs.setInput("ShortURL", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateSharedLinkResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateSharedLinkResultSet(result);
	}
	
}
