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
GetMetadata

Returns the metadata for a file or folder.
*/
public class GetMetadata extends Choreography {

	/**
	Create a new instance of the GetMetadata Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetMetadata(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dropbox/Files/GetMetadata"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token for a specific Dropbox user.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the IncludeDeleted input for this Choreo. 

	@param Boolean - (optional, boolean) If true, DeletedMetadata will be returned for deleted file or folder, otherwise LookupError.not_found will be returned. The default for this field is false.
	*/
	public void setIncludeDeleted(Boolean value) {
		this.inputs.setInput("IncludeDeleted", value);
	}

	/** 
	Set the value of the IncludeDeleted input for this Choreo as a String. 

	@param String - (optional, boolean) If true, DeletedMetadata will be returned for deleted file or folder, otherwise LookupError.not_found will be returned. The default for this field is false.
	*/
	public void setIncludeDeleted(String value) {
		this.inputs.setInput("IncludeDeleted", value);	
	}
	/** 
	Set the value of the IncludeHasExplicitSharedMembers input for this Choreo. 

	@param Boolean - (optional, boolean) If true, the results will include a flag for each file indicating whether or not that file has any explicit members. The default for this field is false.
	*/
	public void setIncludeHasExplicitSharedMembers(Boolean value) {
		this.inputs.setInput("IncludeHasExplicitSharedMembers", value);
	}

	/** 
	Set the value of the IncludeHasExplicitSharedMembers input for this Choreo as a String. 

	@param String - (optional, boolean) If true, the results will include a flag for each file indicating whether or not that file has any explicit members. The default for this field is false.
	*/
	public void setIncludeHasExplicitSharedMembers(String value) {
		this.inputs.setInput("IncludeHasExplicitSharedMembers", value);	
	}
	/** 
	Set the value of the IncludeMediaInfo input for this Choreo. 

	@param Boolean - (optional, boolean) If true, FileMetadata.media_info is set for photo and video. The default for this field is false.
	*/
	public void setIncludeMediaInfo(Boolean value) {
		this.inputs.setInput("IncludeMediaInfo", value);
	}

	/** 
	Set the value of the IncludeMediaInfo input for this Choreo as a String. 

	@param String - (optional, boolean) If true, FileMetadata.media_info is set for photo and video. The default for this field is false.
	*/
	public void setIncludeMediaInfo(String value) {
		this.inputs.setInput("IncludeMediaInfo", value);	
	}
	/** 
	Set the value of the Path input for this Choreo. 

	@param String - (required, string) The path of a file or folder on Dropbox.
	*/
	public void setPath(String value) {
		this.inputs.setInput("Path", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetMetadataResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetMetadataResultSet(result);
	}
	
}