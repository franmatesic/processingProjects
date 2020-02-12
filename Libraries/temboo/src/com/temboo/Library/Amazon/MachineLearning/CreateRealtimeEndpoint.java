package com.temboo.Library.Amazon.MachineLearning;

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
CreateRealtimeEndpoint

This Choreo creates a real-time endpoint for the MLModel. The endpoint contains the URI of the MLModel which is the location to send real-time prediction requests for the specified MLModel.
*/
public class CreateRealtimeEndpoint extends Choreography {

	/**
	Create a new instance of the CreateRealtimeEndpoint Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateRealtimeEndpoint(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/MachineLearning/CreateRealtimeEndpoint"));
	}

	/** 
	Set the value of the AWSAccessKeyId input for this Choreo. 

	@param String - (required, string) The Access Key ID provided by Amazon Web Services.
	*/
	public void setAWSAccessKeyId(String value) {
		this.inputs.setInput("AWSAccessKeyId", value);
	}


	/** 
	Set the value of the AWSSecretKeyId input for this Choreo. 

	@param String - (required, string) The Secret Key ID provided by Amazon Web Services.
	*/
	public void setAWSSecretKeyId(String value) {
		this.inputs.setInput("AWSSecretKeyId", value);
	}


	/** 
	Set the value of the MLModelId input for this Choreo. 

	@param String - (required, string) The ID assigned to the MLModelId at creation.
	*/
	public void setMLModelId(String value) {
		this.inputs.setInput("MLModelId", value);
	}


	/** 
	Set the value of the UserRegion input for this Choreo. 

	@param String - (optional, string) The AWS region that corresponds to the S3 endpoint you wish to access. The default region is "us-east-1".
	*/
	public void setUserRegion(String value) {
		this.inputs.setInput("UserRegion", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateRealtimeEndpointResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateRealtimeEndpointResultSet(result);
	}
	
}
