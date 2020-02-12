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
PlotBarGraph

Plots an array of points on a bar graph.
*/
public class PlotBarGraph extends Choreography {

	/**
	Create a new instance of the PlotBarGraph Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public PlotBarGraph(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Plotly/PlotBarGraph"));
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

	@param String - (optional, string) The file operation being performed. Valid values are: "new", "overwrite", "append", or "extend". See Choreo description for more details. This defaults to "overwrite".
	*/
	public void setFileOption(String value) {
		this.inputs.setInput("FileOption", value);
	}


	/** 
	Set the value of the Title input for this Choreo. 

	@param String - (optional, string) The title of the graph.
	*/
	public void setTitle(String value) {
		this.inputs.setInput("Title", value);
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
	Set the value of the XValues input for this Choreo. 

	@param String - (required, json) A JSON array containing the "x" coordinate values to be plotted on the graph.
	*/
	public void setXValues(String value) {
		this.inputs.setInput("XValues", value);
	}


	/** 
	Set the value of the YValues input for this Choreo. 

	@param String - (required, json) A JSON array containing the "y" coordinate values to be plotted on the graph.
	*/
	public void setYValues(String value) {
		this.inputs.setInput("YValues", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public PlotBarGraphResultSet run() {
		JSONObject result = super.runWithResults();
		return new PlotBarGraphResultSet(result);
	}
	
}
