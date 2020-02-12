package com.temboo.Library.NYTimes.CampaignFinance.Committees;

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
CommitteeSearch

Search for a political action committee (PACs) by name, or partial name.
*/
public class CommitteeSearch extends Choreography {

	/**
	Create a new instance of the CommitteeSearch Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CommitteeSearch(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/NYTimes/CampaignFinance/Committees/CommitteeSearch"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by NY Times.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the CampaignCycle input for this Choreo. 

	@param Integer - (required, integer) Enter the campaign cycle year in YYYY format.  This must be an even year. 
	*/
	public void setCampaignCycle(Integer value) {
		this.inputs.setInput("CampaignCycle", value);
	}

	/** 
	Set the value of the CampaignCycle input for this Choreo as a String. 

	@param String - (required, integer) Enter the campaign cycle year in YYYY format.  This must be an even year. 
	*/
	public void setCampaignCycle(String value) {
		this.inputs.setInput("CampaignCycle", value);	
	}
	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (required, string) Specify the name of the committee to be retireved. Partial names are also acceptable.  Examples: viacom.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) Enter json or xml.  Default is json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CommitteeSearchResultSet run() {
		JSONObject result = super.runWithResults();
		return new CommitteeSearchResultSet(result);
	}
	
}
