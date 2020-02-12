package com.temboo.Library.Utilities.Test;

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
	A ResultSet with methods tailored to the values returned by the HelloWorld Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class HelloWorldResultSet extends ResultSet {
		
	public HelloWorldResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "Result" output from this Choreo execution

	@return String - (string) Contains a sample Choreo output. If no input is provided, the result will be "Hello, world!". When passing an input value, the result will be "Hello, {Value}!".
	*/
	public String getResult() {
		return this.getResultString("Result");
	}
}