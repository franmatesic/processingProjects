package com.temboo.Library.Amazon.DynamoDB;

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
BatchWriteItem

Puts or deletes multiple items in one or more tables.
*/
public class BatchWriteItem extends Choreography {

	/**
	Create a new instance of the BatchWriteItem Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public BatchWriteItem(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/DynamoDB/BatchWriteItem"));
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
	Set the value of the RequestItems input for this Choreo. 

	@param String - (required, json) A map of one or more table names and, for each table, a list of operations to be performed (DeleteRequest or PutRequest). See choreo notes for more details.
	*/
	public void setRequestItems(String value) {
		this.inputs.setInput("RequestItems", value);
	}


	/** 
	Set the value of the ReturnConsumedCapacity input for this Choreo. 

	@param String - (optional, string) Determines the level of detail about provisioned throughput consumption that is returned in the response. Valid values are: INDEXES, TOTAL, NONE.
	*/
	public void setReturnConsumedCapacity(String value) {
		this.inputs.setInput("ReturnConsumedCapacity", value);
	}


	/** 
	Set the value of the ReturnItemCollectionMetrics input for this Choreo. 

	@param String - (optional, string) Determines whether item collection metrics are returned. Valid values are: SIZE and NONE.
	*/
	public void setReturnItemCollectionMetrics(String value) {
		this.inputs.setInput("ReturnItemCollectionMetrics", value);
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
	public BatchWriteItemResultSet run() {
		JSONObject result = super.runWithResults();
		return new BatchWriteItemResultSet(result);
	}
	
}
