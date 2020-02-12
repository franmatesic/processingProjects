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
CreateMLModel

Creates a new MLModel using the DataSource and the recipe as information sources.
*/
public class CreateMLModel extends Choreography {

	/**
	Create a new instance of the CreateMLModel Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateMLModel(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/MachineLearning/CreateMLModel"));
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

	@param String - (required, string) A user-supplied identifier that uniquely identifies the MLModel.
	*/
	public void setMLModelId(String value) {
		this.inputs.setInput("MLModelId", value);
	}


	/** 
	Set the value of the MLModelName input for this Choreo. 

	@param String - (optional, string) A user-supplied name or description of the MLModel.
	*/
	public void setMLModelName(String value) {
		this.inputs.setInput("MLModelName", value);
	}


	/** 
	Set the value of the MLModelType input for this Choreo. 

	@param String - (required, string) The category of supervised learning that this MLModel will address. Choose from the following types: REGRESSION, BINARY, MULTICLASS.
	*/
	public void setMLModelType(String value) {
		this.inputs.setInput("MLModelType", value);
	}


	/** 
	Set the value of the Parameters input for this Choreo. 

	@param String - (optional, json) A list of the training parameters in the MLModel. The list is implemented as a map of key-value pairs.
	*/
	public void setParameters(String value) {
		this.inputs.setInput("Parameters", value);
	}


	/** 
	Set the value of the Recipe input for this Choreo. 

	@param String - (optional, string) The data recipe for creating the MLModel. You must specify either the recipe or its URI. If you don't specify a recipe or its URI, Amazon ML creates a default.
	*/
	public void setRecipe(String value) {
		this.inputs.setInput("Recipe", value);
	}


	/** 
	Set the value of the RecipeUri input for this Choreo. 

	@param String - (optional, string) The Amazon S3 location and file name that contains the MLModel recipe. You must specify either the recipe or its URI. If you don't specify a recipe or its URI, Amazon ML creates a default.
	*/
	public void setRecipeUri(String value) {
		this.inputs.setInput("RecipeUri", value);
	}


	/** 
	Set the value of the TrainingDataSourceId input for this Choreo. 

	@param String - (required, string) The DataSource that points to the training data.
	*/
	public void setTrainingDataSourceId(String value) {
		this.inputs.setInput("TrainingDataSourceId", value);
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
	public CreateMLModelResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateMLModelResultSet(result);
	}
	
}
