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
Upload

Creates a new file with the contents provided in the request.
*/
public class Upload extends Choreography {

	/**
	Create a new instance of the Upload Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Upload(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dropbox/Files/Upload"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token for a specific Dropbox user.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AutoRename input for this Choreo. 

	@param Boolean - (optional, boolean) If there's a conflict, as determined by mode, have the Dropbox server try to autorename the file to avoid conflict. The default for this field is false.
	*/
	public void setAutoRename(Boolean value) {
		this.inputs.setInput("AutoRename", value);
	}

	/** 
	Set the value of the AutoRename input for this Choreo as a String. 

	@param String - (optional, boolean) If there's a conflict, as determined by mode, have the Dropbox server try to autorename the file to avoid conflict. The default for this field is false.
	*/
	public void setAutoRename(String value) {
		this.inputs.setInput("AutoRename", value);	
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

	@param String - (conditional, string) The Base64-encoded file content of the file you want to upload. Required unless uploading a file from a URL using the FileURL input. Encoding is not required when ContentType is set to "text/plain".
	*/
	public void setFileContent(String value) {
		this.inputs.setInput("FileContent", value);
	}


	/** 
	Set the value of the FileURL input for this Choreo. 

	@param String - (optional, string) The public URL for file you want to upload. This can be used as an alternative to uploading Base64 encoded data.
	*/
	public void setFileURL(String value) {
		this.inputs.setInput("FileURL", value);
	}


	/** 
	Set the value of the Mode input for this Choreo. 

	@param String - (optional, string) Selects what to do if the file already exists. Valid values are: add (default), overwrite, and update.
	*/
	public void setMode(String value) {
		this.inputs.setInput("Mode", value);
	}


	/** 
	Set the value of the Mute input for this Choreo. 

	@param Boolean - (optional, boolean) If true, this tells the clients that this modification shouldn't result in a user notification. The default for this field is false.
	*/
	public void setMute(Boolean value) {
		this.inputs.setInput("Mute", value);
	}

	/** 
	Set the value of the Mute input for this Choreo as a String. 

	@param String - (optional, boolean) If true, this tells the clients that this modification shouldn't result in a user notification. The default for this field is false.
	*/
	public void setMute(String value) {
		this.inputs.setInput("Mute", value);	
	}
	/** 
	Set the value of the Path input for this Choreo. 

	@param String - (required, string) Path in the user's Dropbox to save the file, including the filename.
	*/
	public void setPath(String value) {
		this.inputs.setInput("Path", value);
	}


	/** 
	Set the value of the Revision input for this Choreo. 

	@param String - (optional, string) The revision identifier. Used only when Mode is set to "update".
	*/
	public void setRevision(String value) {
		this.inputs.setInput("Revision", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UploadResultSet run() {
		JSONObject result = super.runWithResults();
		return new UploadResultSet(result);
	}
	
}
