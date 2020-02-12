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
UploadSessionAppend

Appends more data to an upload session.
*/
public class UploadSessionAppend extends Choreography {

	/**
	Create a new instance of the UploadSessionAppend Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UploadSessionAppend(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dropbox/Files/UploadSessionAppend"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token for a specific Dropbox user.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Close input for this Choreo. 

	@param Boolean - (optional, boolean) If true, the current session will be closed, at which point you won't be able to call UploadSessionAppend anymore with the current session. The default for this field is false.
	*/
	public void setClose(Boolean value) {
		this.inputs.setInput("Close", value);
	}

	/** 
	Set the value of the Close input for this Choreo as a String. 

	@param String - (optional, boolean) If true, the current session will be closed, at which point you won't be able to call UploadSessionAppend anymore with the current session. The default for this field is false.
	*/
	public void setClose(String value) {
		this.inputs.setInput("Close", value);	
	}
	/** 
	Set the value of the ContentType input for this Choreo. 

	@param String - (optional, string) The content type of the file being uploaded. Defaults to application/octet-stream.
	*/
	public void setContentType(String value) {
		this.inputs.setInput("ContentType", value);
	}


	/** 
	Set the value of the FileContent input for this Choreo. 

	@param String - (conditional, string) The next file segment to upload. Binary files should be Base64-encoded. Encoding is not required when ContentType is set to "text/plain".
	*/
	public void setFileContent(String value) {
		this.inputs.setInput("FileContent", value);
	}


	/** 
	Set the value of the Offset input for this Choreo. 

	@param Integer - (required, integer) The amount of data that has been uploaded so far.
	*/
	public void setOffset(Integer value) {
		this.inputs.setInput("Offset", value);
	}

	/** 
	Set the value of the Offset input for this Choreo as a String. 

	@param String - (required, integer) The amount of data that has been uploaded so far.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);	
	}
	/** 
	Set the value of the SessionID input for this Choreo. 

	@param String - (conditional, string) The upload session ID returned from UploadSessionStart.
	*/
	public void setSessionID(String value) {
		this.inputs.setInput("SessionID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UploadSessionAppendResultSet run() {
		JSONObject result = super.runWithResults();
		return new UploadSessionAppendResultSet(result);
	}
	
}
