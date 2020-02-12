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
ListFolderContinue

Once a cursor has been retrieved from ListFolder, use this to paginate through all files and retrieve updates to the folder.
*/
public class ListFolderContinue extends Choreography {

	/**
	Create a new instance of the ListFolderContinue Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListFolderContinue(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dropbox/Files/ListFolderContinue"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token for a specific Dropbox user.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Cursor input for this Choreo. 

	@param String - (required, string) A cursor used to retrieve the next set of results.
	*/
	public void setCursor(String value) {
		this.inputs.setInput("Cursor", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListFolderContinueResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListFolderContinueResultSet(result);
	}
	
}
