package com.temboo.Library.Pusher.Events;

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
PostEvent

Triggers an event on one or more channels.
*/
public class PostEvent extends Choreography {

	/**
	Create a new instance of the PostEvent Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public PostEvent(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Pusher/Events/PostEvent"));
	}

	/** 
	Set the value of the AppID input for this Choreo. 

	@param String - (required, string) The application ID provided by Pusher.
	*/
	public void setAppID(String value) {
		this.inputs.setInput("AppID", value);
	}


	/** 
	Set the value of the AppKey input for this Choreo. 

	@param String - (required, string) The authenticaion key provided by Pusher.
	*/
	public void setAppKey(String value) {
		this.inputs.setInput("AppKey", value);
	}


	/** 
	Set the value of the AppSecret input for this Choreo. 

	@param String - (required, string) The authentication secret provided by Pusher.
	*/
	public void setAppSecret(String value) {
		this.inputs.setInput("AppSecret", value);
	}


	/** 
	Set the value of the ChannelName input for this Choreo. 

	@param String - (required, string) The name of the channel to publish to. This can also be a list of channels formatted as a JSON array.
	*/
	public void setChannelName(String value) {
		this.inputs.setInput("ChannelName", value);
	}


	/** 
	Set the value of the EventData input for this Choreo. 

	@param String - (required, json) A JSON object containing the event data.
	*/
	public void setEventData(String value) {
		this.inputs.setInput("EventData", value);
	}


	/** 
	Set the value of the EventName input for this Choreo. 

	@param String - (required, string) The name of the event being triggered.
	*/
	public void setEventName(String value) {
		this.inputs.setInput("EventName", value);
	}


	/** 
	Set the value of the SocketID input for this Choreo. 

	@param String - (optional, string) Excludes the event from being sent to a specific connection.
	*/
	public void setSocketID(String value) {
		this.inputs.setInput("SocketID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public PostEventResultSet run() {
		JSONObject result = super.runWithResults();
		return new PostEventResultSet(result);
	}
	
}
