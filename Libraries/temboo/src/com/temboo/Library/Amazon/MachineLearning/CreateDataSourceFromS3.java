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
CreateDataSourceFromS3

Creates a DataSource object.
*/
public class CreateDataSourceFromS3 extends Choreography {

	/**
	Create a new instance of the CreateDataSourceFromS3 Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateDataSourceFromS3(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/MachineLearning/CreateDataSourceFromS3"));
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
	Set the value of the ComputeStatistics input for this Choreo. 

	@param Boolean - (optional, boolean) The compute statistics for a DataSource. This parameter must be set to true if the DataSource needs to be used for MLModel training. Defaults to false.
	*/
	public void setComputeStatistics(Boolean value) {
		this.inputs.setInput("ComputeStatistics", value);
	}

	/** 
	Set the value of the ComputeStatistics input for this Choreo as a String. 

	@param String - (optional, boolean) The compute statistics for a DataSource. This parameter must be set to true if the DataSource needs to be used for MLModel training. Defaults to false.
	*/
	public void setComputeStatistics(String value) {
		this.inputs.setInput("ComputeStatistics", value);	
	}
	/** 
	Set the value of the DataLocationS3 input for this Choreo. 

	@param String - (required, string) The location of the data file(s) used by a DataSource. The URI specifies a data file or an Amazon Simple Storage Service (Amazon S3) directory or bucket containing data files.
	*/
	public void setDataLocationS3(String value) {
		this.inputs.setInput("DataLocationS3", value);
	}


	/** 
	Set the value of the DataRearrangement input for this Choreo. 

	@param String - (optional, json) A JSON string that represents the splitting and rearrangement requirements for the Datasource.
	*/
	public void setDataRearrangement(String value) {
		this.inputs.setInput("DataRearrangement", value);
	}


	/** 
	Set the value of the DataSchema input for this Choreo. 

	@param String - (optional, json) A JSON string representing the schema. This is required unless specifying a valid URI for DataSchemaLocationS3.
	*/
	public void setDataSchema(String value) {
		this.inputs.setInput("DataSchema", value);
	}


	/** 
	Set the value of the DataSchemaLocationS3 input for this Choreo. 

	@param String - (conditional, string) The Amazon S3 location of the DataSchema. This is required unless specifying a valid JSON schema file for DataSchema (see optional inputs).
	*/
	public void setDataSchemaLocationS3(String value) {
		this.inputs.setInput("DataSchemaLocationS3", value);
	}


	/** 
	Set the value of the DataSourceId input for this Choreo. 

	@param String - (required, string) A user-supplied identifier that uniquely identifies the DataSource.
	*/
	public void setDataSourceId(String value) {
		this.inputs.setInput("DataSourceId", value);
	}


	/** 
	Set the value of the DataSourceName input for this Choreo. 

	@param String - (optional, string) A user-supplied name or description of the DataSource.
	*/
	public void setDataSourceName(String value) {
		this.inputs.setInput("DataSourceName", value);
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
	public CreateDataSourceFromS3ResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateDataSourceFromS3ResultSet(result);
	}
	
}
