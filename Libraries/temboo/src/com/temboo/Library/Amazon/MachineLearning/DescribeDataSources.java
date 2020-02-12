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
DescribeDataSources

Returns a list of DataSources that match the search criteria in the request.
*/
public class DescribeDataSources extends Choreography {

	/**
	Create a new instance of the DescribeDataSources Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public DescribeDataSources(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/MachineLearning/DescribeDataSources"));
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
	Set the value of the EQ input for this Choreo. 

	@param String - (optional, string) The equal to operator. The DataSource results will have FilterVariable values that exactly match the value specified with EQ.
	*/
	public void setEQ(String value) {
		this.inputs.setInput("EQ", value);
	}


	/** 
	Set the value of the FilterVariable input for this Choreo. 

	@param String - (optional, string) Use one of the following variables to filter a list of DataSource: CreatedAt, Status, Name, DataUri, IAMUser.
	*/
	public void setFilterVariable(String value) {
		this.inputs.setInput("FilterVariable", value);
	}


	/** 
	Set the value of the GE input for this Choreo. 

	@param String - (optional, string) The greater than or equal to operator. The DataSource results will have FilterVariable values that are greater than or equal to the value specified with GE.
	*/
	public void setGE(String value) {
		this.inputs.setInput("GE", value);
	}


	/** 
	Set the value of the GT input for this Choreo. 

	@param String - (optional, string) The greater than operator. The DataSource results will have FilterVariable values that are greater than the value specified with GT.
	*/
	public void setGT(String value) {
		this.inputs.setInput("GT", value);
	}


	/** 
	Set the value of the LE input for this Choreo. 

	@param String - (optional, string) The less than or equal to operator. The DataSource results will have FilterVariable values that are less than or equal to the value specified with LE.
	*/
	public void setLE(String value) {
		this.inputs.setInput("LE", value);
	}


	/** 
	Set the value of the LT input for this Choreo. 

	@param String - (optional, string) The less than operator. The DataSource results will have FilterVariable values that are less than the value specified with LT.
	*/
	public void setLT(String value) {
		this.inputs.setInput("LT", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) The maximum number of DataSource to include in the result.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) The maximum number of DataSource to include in the result.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the NE input for this Choreo. 

	@param String - (optional, string) The not equal to operator. The DataSource results will have FilterVariable values not equal to the value specified with NE.
	*/
	public void setNE(String value) {
		this.inputs.setInput("NE", value);
	}


	/** 
	Set the value of the NextToken input for this Choreo. 

	@param String - (optional, string) The ID of the page in the paginated results.
	*/
	public void setNextToken(String value) {
		this.inputs.setInput("NextToken", value);
	}


	/** 
	Set the value of the Prefix input for this Choreo. 

	@param String - (optional, string) A string that is found at the beginning of a variable, such as Name or Id.
	*/
	public void setPrefix(String value) {
		this.inputs.setInput("Prefix", value);
	}


	/** 
	Set the value of the SortOrder input for this Choreo. 

	@param String - (optional, string) Determines the sequence of the resulting list of DataSource. Valid values are: asc, dsc.
	*/
	public void setSortOrder(String value) {
		this.inputs.setInput("SortOrder", value);
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
	public DescribeDataSourcesResultSet run() {
		JSONObject result = super.runWithResults();
		return new DescribeDataSourcesResultSet(result);
	}
	
}
