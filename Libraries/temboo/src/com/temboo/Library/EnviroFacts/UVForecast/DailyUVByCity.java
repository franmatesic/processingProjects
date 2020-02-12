package com.temboo.Library.EnviroFacts.UVForecast;

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
DailyUVByCity

Retrieves EPA daily Ultraviolet (UV) Index readings in a given city.
*/
public class DailyUVByCity extends Choreography {

	/**
	Create a new instance of the DailyUVByCity Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public DailyUVByCity(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/EnviroFacts/UVForecast/DailyUVByCity"));
	}

	/** 
	Set the value of the City input for this Choreo. 

	@param String - (required, string) A valid City Name in the United States.
	*/
	public void setCity(String value) {
		this.inputs.setInput("City", value);
	}


	/** 
	Set the value of the ResponseType input for this Choreo. 

	@param String - (optional, string) Results can be retrieved in either JSON or XML. Defaults to XML.
	*/
	public void setResponseType(String value) {
		this.inputs.setInput("ResponseType", value);
	}


	/** 
	Set the value of the State input for this Choreo. 

	@param String - (required, string) The abbreviation of the state that the city resides in.
	*/
	public void setState(String value) {
		this.inputs.setInput("State", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public DailyUVByCityResultSet run() {
		JSONObject result = super.runWithResults();
		return new DailyUVByCityResultSet(result);
	}
	
}
