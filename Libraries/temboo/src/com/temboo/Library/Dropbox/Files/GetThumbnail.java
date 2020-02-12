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
GetThumbnail

Gets a thumbnail for an image.
*/
public class GetThumbnail extends Choreography {

	/**
	Create a new instance of the GetThumbnail Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetThumbnail(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dropbox/Files/GetThumbnail"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token for a specific Dropbox user.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Format input for this Choreo. 

	@param String - (optional, string) The format for the thumbnail image, jpeg (default) or png.
	*/
	public void setFormat(String value) {
		this.inputs.setInput("Format", value);
	}


	/** 
	Set the value of the Path input for this Choreo. 

	@param String - (required, string) The path of the file to download.
	*/
	public void setPath(String value) {
		this.inputs.setInput("Path", value);
	}


	/** 
	Set the value of the Size input for this Choreo. 

	@param String - (optional, string) The size for the thumbnail image. The default for this union is w64h64.
	*/
	public void setSize(String value) {
		this.inputs.setInput("Size", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetThumbnailResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetThumbnailResultSet(result);
	}
	
}
