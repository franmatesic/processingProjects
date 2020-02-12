package com.temboo.Library.Plotly;

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
ConfigureGraph

Creates, modifies, or styles a graph.
*/
public class ConfigureGraph extends Choreography {

	/**
	Create a new instance of the ConfigureGraph Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ConfigureGraph(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Plotly/ConfigureGraph"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Plotly.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the FileName input for this Choreo. 

	@param String - (required, string) The file name of your Plotly graph. If the file is nested within a directory, you can specify a path here (e.g., myFolder/myPlot).
	*/
	public void setFileName(String value) {
		this.inputs.setInput("FileName", value);
	}


	/** 
	Set the value of the FileOption input for this Choreo. 

	@param String - (required, string) The file operation being performed. Valid values are: "new", "overwrite", "append", or "extend". See Choreo description for more details.
	*/
	public void setFileOption(String value) {
		this.inputs.setInput("FileOption", value);
	}


	/** 
	Set the value of the GraphArguments input for this Choreo. 

	@param String - (conditional, json) The data and/or styling arguments. Typically, this is in the form of a JSON array where x and y are represented as arrays of numbers or strings. See Choreo description for more details.
	*/
	public void setGraphArguments(String value) {
		this.inputs.setInput("GraphArguments", value);
	}


	/** 
	Set the value of the Layout input for this Choreo. 

	@param String - (optional, json) A key-value paired JSON object that describes the layout of the plot (e.g., {"title": "Sensor Data"}).
	*/
	public void setLayout(String value) {
		this.inputs.setInput("Layout", value);
	}


	/** 
	Set the value of the Origin input for this Choreo. 

	@param String - (optional, string) Specifies the type of call and the type of data in the Arguments parameter. Valid values are: plot (the default), style, or layout.
	*/
	public void setOrigin(String value) {
		this.inputs.setInput("Origin", value);
	}


	/** 
	Set the value of the Style input for this Choreo. 

	@param String - (optional, json) A JSON object describing the style of the graph (e.g., {"type": "bar"}). This can be applied to every single trace (default) or to the traces specified in the optional Traces input.
	*/
	public void setStyle(String value) {
		this.inputs.setInput("Style", value);
	}


	/** 
	Set the value of the Traces input for this Choreo. 

	@param String - (optional, json) Specifies the indices that the Style input object should be applied to. This should be formatted as a JSON array.
	*/
	public void setTraces(String value) {
		this.inputs.setInput("Traces", value);
	}


	/** 
	Set the value of the Username input for this Choreo. 

	@param String - (required, string) A valid Plotly username.
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	/** 
	Set the value of the WorldReadable input for this Choreo. 

	@param Boolean - (optional, boolean) When set to true, the graph is viewable by anyone who has the link. If false (the default), the graph is only viewable in the owner's Plotly account.
	*/
	public void setWorldReadable(Boolean value) {
		this.inputs.setInput("WorldReadable", value);
	}

	/** 
	Set the value of the WorldReadable input for this Choreo as a String. 

	@param String - (optional, boolean) When set to true, the graph is viewable by anyone who has the link. If false (the default), the graph is only viewable in the owner's Plotly account.
	*/
	public void setWorldReadable(String value) {
		this.inputs.setInput("WorldReadable", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ConfigureGraphResultSet run() {
		JSONObject result = super.runWithResults();
		return new ConfigureGraphResultSet(result);
	}
	
}
