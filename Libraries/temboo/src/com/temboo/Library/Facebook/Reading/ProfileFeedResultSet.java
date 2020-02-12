package com.temboo.Library.Facebook.Reading;

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
import com.temboo.core.Choreography.ResultSet;

	
/**
	A ResultSet with methods tailored to the values returned by the ProfileFeed Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class ProfileFeedResultSet extends ResultSet {
		
	public ProfileFeedResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "HasNext" output from this Choreo execution

	@return String - (boolean) A boolean flag indicating that a next page exists.
	*/
	public String getHasNext() {
		return this.getResultString("HasNext");
	}
	/** 
	Retrieve the value for the "HasPrevious" output from this Choreo execution

	@return String - (boolean) A boolean flag indicating that a previous page exists.
	*/
	public String getHasPrevious() {
		return this.getResultString("HasPrevious");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - The response from Facebook. Corresponds to the ResponseFormat input. Defaults to JSON.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}