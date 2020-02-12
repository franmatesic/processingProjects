package com.temboo.Library.Stripe.Charges;

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
CreateNewChargeWithToken

Charges a credit card by creating a new charge object using a card token that is associated with the credit card details.
*/
public class CreateNewChargeWithToken extends Choreography {

	/**
	Create a new instance of the CreateNewChargeWithToken Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateNewChargeWithToken(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Stripe/Charges/CreateNewChargeWithToken"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Stripe
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Amount input for this Choreo. 

	@param Integer - (required, integer) The amount to charge a customer in cents
	*/
	public void setAmount(Integer value) {
		this.inputs.setInput("Amount", value);
	}

	/** 
	Set the value of the Amount input for this Choreo as a String. 

	@param String - (required, integer) The amount to charge a customer in cents
	*/
	public void setAmount(String value) {
		this.inputs.setInput("Amount", value);	
	}
	/** 
	Set the value of the Currency input for this Choreo. 

	@param String - (optional, string) 3-letter ISO code for currency. Defaults to 'usd' which is currently the only supported currency.
	*/
	public void setCurrency(String value) {
		this.inputs.setInput("Currency", value);
	}


	/** 
	Set the value of the Description input for this Choreo. 

	@param String - (optional, string) An arbitrary string of text that will be associated with the charge as a description
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the Metadata input for this Choreo. 

	@param String - (optional, json) A JSON object used to attach key-value data to this Stripe object.
	*/
	public void setMetadata(String value) {
		this.inputs.setInput("Metadata", value);
	}


	/** 
	Set the value of the Token input for this Choreo. 

	@param String - (required, string) The token associated with a set of credit card details.
	*/
	public void setToken(String value) {
		this.inputs.setInput("Token", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateNewChargeWithTokenResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateNewChargeWithTokenResultSet(result);
	}
	
}
