package com.temboo.Library.Twilio.Calls;

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
CaptureKeyPadEntry

Initiates a call from the specified Twilio account and returns a key pad entry.
*/
public class CaptureKeyPadEntry extends Choreography {

	/**
	Create a new instance of the CaptureKeyPadEntry Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CaptureKeyPadEntry(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twilio/Calls/CaptureKeyPadEntry"));
	}

	/** 
	Set the value of the AccountSID input for this Choreo. 

	@param String - (required, string) The AccountSID provided when you signed up for a Twilio account.
	*/
	public void setAccountSID(String value) {
		this.inputs.setInput("AccountSID", value);
	}


	/** 
	Set the value of the AnswerURL input for this Choreo. 

	@param String - (conditional, string) The URL for the Twiml file containing your Temboo Callback URL. See Choreo notes below.
	*/
	public void setAnswerURL(String value) {
		this.inputs.setInput("AnswerURL", value);
	}


	/** 
	Set the value of the AuthToken input for this Choreo. 

	@param String - (required, string) The authorization token provided when you signed up for a Twilio account.
	*/
	public void setAuthToken(String value) {
		this.inputs.setInput("AuthToken", value);
	}


	/** 
	Set the value of the From input for this Choreo. 

	@param String - (required, string) The Twilio phone number or client identifier to use as the caller id.
	*/
	public void setFrom(String value) {
		this.inputs.setInput("From", value);
	}


	/** 
	Set the value of the GoodbyeURL input for this Choreo. 

	@param String - (required, string) The URL for the Twiml file that contains a "goodbye" message that will be evalated after a Twilio webhook event. This is an optional input that can be used when passing the AnswerURL.
	*/
	public void setGoodbyeURL(String value) {
		this.inputs.setInput("GoodbyeURL", value);
	}


	/** 
	Set the value of the IfMachine input for this Choreo. 

	@param String - (optional, string) Indicates if Twilio should to try and determine if a machine (like voicemail) or a human has answered the call. Possible values are "Continue" and "Hangup".
	*/
	public void setIfMachine(String value) {
		this.inputs.setInput("IfMachine", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SubAccountSID input for this Choreo. 

	@param String - (optional, string) The SID of the subaccount associated with this call. If not specified, the main AccountSID used to authenticate is used in request.
	*/
	public void setSubAccountSID(String value) {
		this.inputs.setInput("SubAccountSID", value);
	}


	/** 
	Set the value of the Timeout input for this Choreo. 

	@param Integer - (optional, integer) The integer number of seconds that Twilio should allow the phone to ring before assuming there is no answer. Default is 60 seconds, the maximum is 999 seconds.
	*/
	public void setTimeout(Integer value) {
		this.inputs.setInput("Timeout", value);
	}

	/** 
	Set the value of the Timeout input for this Choreo as a String. 

	@param String - (optional, integer) The integer number of seconds that Twilio should allow the phone to ring before assuming there is no answer. Default is 60 seconds, the maximum is 999 seconds.
	*/
	public void setTimeout(String value) {
		this.inputs.setInput("Timeout", value);	
	}
	/** 
	Set the value of the To input for this Choreo. 

	@param String - (required, string) The phone number or client identifier to call.
	*/
	public void setTo(String value) {
		this.inputs.setInput("To", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CaptureKeyPadEntryResultSet run() {
		JSONObject result = super.runWithResults();
		return new CaptureKeyPadEntryResultSet(result);
	}
	
}
