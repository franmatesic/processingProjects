package com.temboo.Library.Amazon.CloudDrive.Folders;

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
CreateFolder

Creates a new folder using the Amazon Cloud Drive API.
*/
public class CreateFolder extends Choreography {

	/**
	Create a new instance of the CreateFolder Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateFolder(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/CloudDrive/Folders/CreateFolder"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid access token retrieved during the OAuth process. This is required unless you provide the ClientID, ClientSecret, and RefreshToken to generate a new access token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The Client ID provided by Amazon. Required unless providing a valid AccessToken.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (conditional, string) The Client Secret provided by Amazon. Required unless providing a valid AccessToken.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the HandleRequestThrottling input for this Choreo. 

	@param Boolean - (optional, boolean) Whether or not to perform a retry sequence if a throttling error occurs. Set to true to enable this feature. The request will be retried up-to five times when enabled.
	*/
	public void setHandleRequestThrottling(Boolean value) {
		this.inputs.setInput("HandleRequestThrottling", value);
	}

	/** 
	Set the value of the HandleRequestThrottling input for this Choreo as a String. 

	@param String - (optional, boolean) Whether or not to perform a retry sequence if a throttling error occurs. Set to true to enable this feature. The request will be retried up-to five times when enabled.
	*/
	public void setHandleRequestThrottling(String value) {
		this.inputs.setInput("HandleRequestThrottling", value);	
	}
	/** 
	Set the value of the Labels input for this Choreo. 

	@param String - (optional, json) A JSON array containing labels to apply to the folder.
	*/
	public void setLabels(String value) {
		this.inputs.setInput("Labels", value);
	}


	/** 
	Set the value of the LocalID input for this Choreo. 

	@param String - (optional, string) Globally unique client local Id for the customer.
	*/
	public void setLocalID(String value) {
		this.inputs.setInput("LocalID", value);
	}


	/** 
	Set the value of the MetaDataURL input for this Choreo. 

	@param String - (optional, string) The appropriate metadataUrl for your account. When not provided, the Choreo will lookup the URL using the Account.GetEndpoint Choreo.
	*/
	public void setMetaDataURL(String value) {
		this.inputs.setInput("MetaDataURL", value);
	}


	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (required, string) The name of the new folder.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the Parents input for this Choreo. 

	@param String - (optional, json) A JSON array containing parent names associated with the new folder.
	*/
	public void setParents(String value) {
		this.inputs.setInput("Parents", value);
	}


	/** 
	Set the value of the Properties input for this Choreo. 

	@param String - (optional, json) A JSON object containing properties to be applied to the folder.
	*/
	public void setProperties(String value) {
		this.inputs.setInput("Properties", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth refresh token used to generate a new access token when the original token is expired. Required unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateFolderResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateFolderResultSet(result);
	}
	
}
