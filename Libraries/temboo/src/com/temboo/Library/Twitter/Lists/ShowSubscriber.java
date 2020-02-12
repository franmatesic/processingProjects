package com.temboo.Library.Twitter.Lists;

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
ShowSubscriber

Verifies that the specified user is a subscriber of the specified list.
*/
public class ShowSubscriber extends Choreography {

	/**
	Create a new instance of the ShowSubscriber Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ShowSubscriber(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twitter/Lists/ShowSubscriber"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token provided by Twitter or retrieved during the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AccessTokenSecret input for this Choreo. 

	@param String - (required, string) The Access Token Secret provided by Twitter or retrieved during the OAuth process.
	*/
	public void setAccessTokenSecret(String value) {
		this.inputs.setInput("AccessTokenSecret", value);
	}


	/** 
	Set the value of the ConsumerKey input for this Choreo. 

	@param String - (required, string) The API Key (or Consumer Key) provided by Twitter.
	*/
	public void setConsumerKey(String value) {
		this.inputs.setInput("ConsumerKey", value);
	}


	/** 
	Set the value of the ConsumerSecret input for this Choreo. 

	@param String - (required, string) The API Secret (or Consumer Secret) provided by Twitter.
	*/
	public void setConsumerSecret(String value) {
		this.inputs.setInput("ConsumerSecret", value);
	}


	/** 
	Set the value of the IncludeEntities input for this Choreo. 

	@param Boolean - (optional, boolean) The "entities" node containing extra metadata will not be included when set to false.
	*/
	public void setIncludeEntities(Boolean value) {
		this.inputs.setInput("IncludeEntities", value);
	}

	/** 
	Set the value of the IncludeEntities input for this Choreo as a String. 

	@param String - (optional, boolean) The "entities" node containing extra metadata will not be included when set to false.
	*/
	public void setIncludeEntities(String value) {
		this.inputs.setInput("IncludeEntities", value);	
	}
	/** 
	Set the value of the ListId input for this Choreo. 

	@param String - (conditional, string) The numerical ID of the list. Required unless Slug is provided.
	*/
	public void setListId(String value) {
		this.inputs.setInput("ListId", value);
	}


	/** 
	Set the value of the OwnerId input for this Choreo. 

	@param String - (optional, string) The user ID of the user who owns the list being requested by a slug.
	*/
	public void setOwnerId(String value) {
		this.inputs.setInput("OwnerId", value);
	}


	/** 
	Set the value of the OwnerScreenName input for this Choreo. 

	@param String - (optional, string) The screen name of the user who owns the list being requested by a slug.
	*/
	public void setOwnerScreenName(String value) {
		this.inputs.setInput("OwnerScreenName", value);
	}


	/** 
	Set the value of the ScreenName input for this Choreo. 

	@param String - (conditional, string) The screen name of the user to retrieve from the list. Required unless providing the UserId.
	*/
	public void setScreenName(String value) {
		this.inputs.setInput("ScreenName", value);
	}


	/** 
	Set the value of the SkipStatus input for this Choreo. 

	@param Boolean - (optional, boolean) When set to either true, statuses will not be included in the returned user objects.
	*/
	public void setSkipStatus(Boolean value) {
		this.inputs.setInput("SkipStatus", value);
	}

	/** 
	Set the value of the SkipStatus input for this Choreo as a String. 

	@param String - (optional, boolean) When set to either true, statuses will not be included in the returned user objects.
	*/
	public void setSkipStatus(String value) {
		this.inputs.setInput("SkipStatus", value);	
	}
	/** 
	Set the value of the Slug input for this Choreo. 

	@param String - (optional, string) When identifying a list by a slug, either OwnerScreenName or OwnerId must be provided.
	*/
	public void setSlug(String value) {
		this.inputs.setInput("Slug", value);
	}


	/** 
	Set the value of the UserId input for this Choreo. 

	@param String - (conditional, string) The ID of the user to retrieve from the list. Required unless providing the ScreenName.
	*/
	public void setUserId(String value) {
		this.inputs.setInput("UserId", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ShowSubscriberResultSet run() {
		JSONObject result = super.runWithResults();
		return new ShowSubscriberResultSet(result);
	}
	
}
