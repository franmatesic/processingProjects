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
Restore

Restores a file to a specific revision.
*/
public class Restore extends Choreography {

	/**
	Create a new instance of the Restore Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Restore(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dropbox/Files/Restore"));
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

	@param String - (conditional, string) The path to the file you want to see the revisions of.
	*/
	public void setPath(String value) {
		this.inputs.setInput("Path", value);
	}


	/** 
	Set the value of the Revision input for this Choreo. 

	@param String - (required, string) The number of revisions to return. The default for this field is 10.
	*/
	public void setRevision(String value) {
		this.inputs.setInput("Revision", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RestoreResultSet run() {
		JSONObject result = super.runWithResults();
		return new RestoreResultSet(result);
	}
	
}
