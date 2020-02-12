package com.temboo.Library.Google.NaturalLanguage.Documents;

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
AnnotateText

A convenience method that provides all the features that analyzeSentiment, analyzeEntities, and analyzeSyntax provide in one call.
*/
public class AnnotateText extends Choreography {

	/**
	Create a new instance of the AnnotateText Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AnnotateText(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/NaturalLanguage/Documents/AnnotateText"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (conditional, string) The API Key provided by Google.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Content input for this Choreo. 

	@param String - (conditional, string) The content to analyze.
	*/
	public void setContent(String value) {
		this.inputs.setInput("Content", value);
	}


	/** 
	Set the value of the EncodingType input for this Choreo. 

	@param String - (optional, string) The encoding type used by the API to calculate sentence offsets. Defaults to UTF-8.
	*/
	public void setEncodingType(String value) {
		this.inputs.setInput("EncodingType", value);
	}


	/** 
	Set the value of the ExtractDocumentSentiment input for this Choreo. 

	@param Boolean - (optional, boolean) Extract document-level sentiment. Defaults to true.
	*/
	public void setExtractDocumentSentiment(Boolean value) {
		this.inputs.setInput("ExtractDocumentSentiment", value);
	}

	/** 
	Set the value of the ExtractDocumentSentiment input for this Choreo as a String. 

	@param String - (optional, boolean) Extract document-level sentiment. Defaults to true.
	*/
	public void setExtractDocumentSentiment(String value) {
		this.inputs.setInput("ExtractDocumentSentiment", value);	
	}
	/** 
	Set the value of the ExtractEntities input for this Choreo. 

	@param Boolean - (optional, boolean) Extract entities. Defaults to true.
	*/
	public void setExtractEntities(Boolean value) {
		this.inputs.setInput("ExtractEntities", value);
	}

	/** 
	Set the value of the ExtractEntities input for this Choreo as a String. 

	@param String - (optional, boolean) Extract entities. Defaults to true.
	*/
	public void setExtractEntities(String value) {
		this.inputs.setInput("ExtractEntities", value);	
	}
	/** 
	Set the value of the ExtractSyntax input for this Choreo. 

	@param Boolean - (optional, boolean) Extract syntax information. Defaults to true.
	*/
	public void setExtractSyntax(Boolean value) {
		this.inputs.setInput("ExtractSyntax", value);
	}

	/** 
	Set the value of the ExtractSyntax input for this Choreo as a String. 

	@param String - (optional, boolean) Extract syntax information. Defaults to true.
	*/
	public void setExtractSyntax(String value) {
		this.inputs.setInput("ExtractSyntax", value);	
	}
	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) Selector specifying which fields to include in a partial response.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the GCSContentUri input for this Choreo. 

	@param String - (optional, string) The Google Cloud Storage URI where the file content is located. This can be used instead of the Content input.
	*/
	public void setGCSContentUri(String value) {
		this.inputs.setInput("GCSContentUri", value);
	}


	/** 
	Set the value of the Language input for this Choreo. 

	@param String - (optional, string) The language of the document. This is specified with the ISO-639-1 Code (e.g. "en"). If not specified, the language is detected if possible.
	*/
	public void setLanguage(String value) {
		this.inputs.setInput("Language", value);
	}


	/** 
	Set the value of the Type input for this Choreo. 

	@param String - (optional, string) The type of content being sent. Valid values are PLAIN_TEXT (the default) and HTML.
	*/
	public void setType(String value) {
		this.inputs.setInput("Type", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AnnotateTextResultSet run() {
		JSONObject result = super.runWithResults();
		return new AnnotateTextResultSet(result);
	}
	
}
