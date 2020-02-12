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
AddTags

Adds one or more tags to an object, up to a limit of 10. 
*/
public class AddTags extends Choreography {

	/**
	Create a new instance of the AddTags Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AddTags(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/MachineLearning/AddTags"));
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
	Set the value of the ResourceId input for this Choreo. 

	@param String - (required, string) The ID of the ML object to tag.
	*/
	public void setResourceId(String value) {
		this.inputs.setInput("ResourceId", value);
	}


	/** 
	Set the value of the ResourceType input for this Choreo. 

	@param String - (required, string) The type of the ML object to tag. Valid values are: BatchPrediction, DataSource, Evaluation, MLModel.
	*/
	public void setResourceType(String value) {
		this.inputs.setInput("ResourceType", value);
	}


	/** 
	Set the value of the Tags input for this Choreo. 

	@param String - (required, json) An array of tag objects in a key-value pair format.
	*/
	public void setTags(String value) {
		this.inputs.setInput("Tags", value);
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
	public AddTagsResultSet run() {
		JSONObject result = super.runWithResults();
		return new AddTagsResultSet(result);
	}
	
}
