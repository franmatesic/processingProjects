package com.temboo.Library.Dropbox.Files;

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
Delete

Deletes the file or folder at a given path.
*/
public class Delete extends Choreography {

	/**
	Create a new instance of the Delete Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Delete(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dropbox/Files/Delete"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token for a specific Dropbox user.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Path input for this Choreo. 

	@param String - (required, string) Path in the user's Dropbox to delete.
	*/
	public void setPath(String value) {
		this.inputs.setInput("Path", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public DeleteResultSet run() {
		JSONObject result = super.runWithResults();
		return new DeleteResultSet(result);
	}
	
}
