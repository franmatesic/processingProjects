package com.temboo.Library.YouTube.Videos;

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
ResumeUpload

Inserts a new file.
*/
public class ResumeUpload extends Choreography {

	/**
	Create a new instance of the ResumeUpload Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ResumeUpload(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/YouTube/Videos/ResumeUpload"));
	}

	/** 
	Set the value of the RequestBody input for this Choreo. 

	@param String - (conditional, json) A JSON representation of fields in a file resource. File metadata information (such as the title) can be inserted using this input. See documentation for formatting examples.
	*/
	public void setRequestBody(String value) {
		this.inputs.setInput("RequestBody", value);
	}


	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid access token retrieved during the OAuth2 process. This is required unless you provide the ClientID, ClientSecret, and RefreshToken to generate a new access token.
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
	Set the value of the ContentType input for this Choreo. 

	@param String - (optional, string) The Content-Type of the file that is being uploaded. Defaults to application/octet-stream.
	*/
	public void setContentType(String value) {
		this.inputs.setInput("ContentType", value);
	}


	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) Selector specifying a subset of fields to include in the response.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the FileContent input for this Choreo. 

	@param String - (conditional, string) The Base64 encoded contents of the file to upload.
	*/
	public void setFileContent(String value) {
		this.inputs.setInput("FileContent", value);
	}


	/** 
	Set the value of the Index input for this Choreo. 

	@param String - (conditional, any) 
	*/
	public void setIndex(String value) {
		this.inputs.setInput("Index", value);
	}


	/** 
	Set the value of the LastByte input for this Choreo. 

	@param Integer - (conditional, integer) 
	*/
	public void setLastByte(Integer value) {
		this.inputs.setInput("LastByte", value);
	}

	/** 
	Set the value of the LastByte input for this Choreo as a String. 

	@param String - (conditional, integer) 
	*/
	public void setLastByte(String value) {
		this.inputs.setInput("LastByte", value);	
	}
	/** 
	Set the value of the Offset input for this Choreo. 

	@param String - (conditional, any) 
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);
	}


	/** 
	Set the value of the Part input for this Choreo. 

	@param String - (required, string) This parameter identifies the properties that the write operation will set as well as the properties that the API response will include (e.g. snippet).
	*/
	public void setPart(String value) {
		this.inputs.setInput("Part", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth refresh token used to generate a new access token when the original token is expired. Required unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the ResumeUploadID input for this Choreo. 

	@param String - (optional, string) The UploadID used to resume a partially uploaded file.
	*/
	public void setResumeUploadID(String value) {
		this.inputs.setInput("ResumeUploadID", value);
	}


	/** 
	Set the value of the Size input for this Choreo. 

	@param Integer - (required, integer) 
	*/
	public void setSize(Integer value) {
		this.inputs.setInput("Size", value);
	}

	/** 
	Set the value of the Size input for this Choreo as a String. 

	@param String - (required, integer) 
	*/
	public void setSize(String value) {
		this.inputs.setInput("Size", value);	
	}
	/** 
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - A path to a vault file to upload. This can be used as an alternative to the FileContent input.
	*/

	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ResumeUploadResultSet run() {
		JSONObject result = super.runWithResults();
		return new ResumeUploadResultSet(result);
	}
	
}
