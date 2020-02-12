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
RevokeSharedLink

Revokes a shared link.
*/
public class RevokeSharedLink extends Choreography {

	/**
	Create a new instance of the RevokeSharedLink Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RevokeSharedLink(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dropbox/Sharing/RevokeSharedLink"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token for a specific Dropbox user.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the URL input for this Choreo. 

	@param String - (required, string) The URL of the shared link.
	*/
	public void setURL(String value) {
		this.inputs.setInput("URL", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RevokeSharedLinkResultSet run() {
		JSONObject result = super.runWithResults();
		return new RevokeSharedLinkResultSet(result);
	}
	
}
