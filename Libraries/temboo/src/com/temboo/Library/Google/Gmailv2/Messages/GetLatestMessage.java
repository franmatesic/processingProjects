package com.temboo.Library.Google.Gmailv2.Messages;

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
GetLatestMessage

Retrieves the latest email from a user's inbox.
*/
public class GetLatestMessage extends Choreography {

	/**
	Create a new instance of the GetLatestMessage Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetLatestMessage(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Gmailv2/Messages/GetLatestMessage"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid Access Token retrieved during the OAuth2 process. This is required unless you provide the ClientID, ClientSecret, and RefreshToken to generate a new Access Token.
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
	Set the value of the EncodeMessage input for this Choreo. 

	@param Boolean - (optional, boolean) When set to "true" (the default), the message Body will be Base64 encoded.
	*/
	public void setEncodeMessage(Boolean value) {
		this.inputs.setInput("EncodeMessage", value);
	}

	/** 
	Set the value of the EncodeMessage input for this Choreo as a String. 

	@param String - (optional, boolean) When set to "true" (the default), the message Body will be Base64 encoded.
	*/
	public void setEncodeMessage(String value) {
		this.inputs.setInput("EncodeMessage", value);	
	}
	/** 
	Set the value of the IncludeSpamTrash input for this Choreo. 

	@param Boolean - (optional, boolean) Set to "true" to include messages from SPAM and TRASH in the results. Defaults to "false".
	*/
	public void setIncludeSpamTrash(Boolean value) {
		this.inputs.setInput("IncludeSpamTrash", value);
	}

	/** 
	Set the value of the IncludeSpamTrash input for this Choreo as a String. 

	@param String - (optional, boolean) Set to "true" to include messages from SPAM and TRASH in the results. Defaults to "false".
	*/
	public void setIncludeSpamTrash(String value) {
		this.inputs.setInput("IncludeSpamTrash", value);	
	}
	/** 
	Set the value of the LabelID input for this Choreo. 

	@param String - (optional, string) Returns messages with a label matching this ID.
	*/
	public void setLabelID(String value) {
		this.inputs.setInput("LabelID", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth Refresh Token used to generate a new Access Token when the original token is expired. Required unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the StartHistoryID input for this Choreo. 

	@param String - (optional, string) Returns history records after the specified marker. The history ID is returned by this Choreo after retrieving a message.
	*/
	public void setStartHistoryID(String value) {
		this.inputs.setInput("StartHistoryID", value);
	}


	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (optional, string) The ID of the acting user. Defaults to "me" indicating the user associated with the Access Token or Refresh Token provided.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetLatestMessageResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetLatestMessageResultSet(result);
	}
	
}