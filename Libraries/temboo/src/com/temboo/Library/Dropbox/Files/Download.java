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
Download

Downloads a file from a user's Dropbox.
*/
public class Download extends Choreography {

	/**
	Create a new instance of the Download Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Download(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dropbox/Files/Download"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token for a specific Dropbox user.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Encode input for this Choreo. 

	@param Boolean - (optional, boolean) Binary files must be returned as Base64-encoded data. If the file you are donwloading is plain text, you can set this to false to return the raw data. Defaults to true. 
	*/
	public void setEncode(Boolean value) {
		this.inputs.setInput("Encode", value);
	}

	/** 
	Set the value of the Encode input for this Choreo as a String. 

	@param String - (optional, boolean) Binary files must be returned as Base64-encoded data. If the file you are donwloading is plain text, you can set this to false to return the raw data. Defaults to true. 
	*/
	public void setEncode(String value) {
		this.inputs.setInput("Encode", value);	
	}
	/** 
	Set the value of the Path input for this Choreo. 

	@param String - (required, string) The path of the file to download.
	*/
	public void setPath(String value) {
		this.inputs.setInput("Path", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public DownloadResultSet run() {
		JSONObject result = super.runWithResults();
		return new DownloadResultSet(result);
	}
	
}
