package com.temboo.Library.Zoho.CRM;

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
InsertRecords

Inserts records into your Zoho CRM account.
*/
public class InsertRecords extends Choreography {

	/**
	Create a new instance of the InsertRecords Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public InsertRecords(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Zoho/CRM/InsertRecords"));
	}

	/** 
	Set the value of the AnnualRevenue input for this Choreo. 

	@param String - (optional, string) Corresponds to the Annual Revenue field in Zoho
	*/
	public void setAnnualRevenue(String value) {
		this.inputs.setInput("AnnualRevenue", value);
	}


	/** 
	Set the value of the AuthenticationToken input for this Choreo. 

	@param String - (required, string) A valid authentication token. Permanent authentication tokens can be generated by the GenerateAuthToken Choreo.
	*/
	public void setAuthenticationToken(String value) {
		this.inputs.setInput("AuthenticationToken", value);
	}


	/** 
	Set the value of the CampaignSource input for this Choreo. 

	@param String - (optional, string) Corresponds to the Campaign Source field in Zoho
	*/
	public void setCampaignSource(String value) {
		this.inputs.setInput("CampaignSource", value);
	}


	/** 
	Set the value of the City input for this Choreo. 

	@param String - (optional, string) Corresponds to the City field in Zoho
	*/
	public void setCity(String value) {
		this.inputs.setInput("City", value);
	}


	/** 
	Set the value of the Company input for this Choreo. 

	@param String - (optional, string) Corresponds to the Company field in Zoho
	*/
	public void setCompany(String value) {
		this.inputs.setInput("Company", value);
	}


	/** 
	Set the value of the Country input for this Choreo. 

	@param String - (optional, string) Corresponds to the Country field in Zoho
	*/
	public void setCountry(String value) {
		this.inputs.setInput("Country", value);
	}


	/** 
	Set the value of the Description input for this Choreo. 

	@param String - (optional, string) Corresponds to the Description field in Zoho
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the Email input for this Choreo. 

	@param String - (optional, string) Corresponds to the Email field in Zoho
	*/
	public void setEmail(String value) {
		this.inputs.setInput("Email", value);
	}


	/** 
	Set the value of the EmailOptOut input for this Choreo. 

	@param Boolean - (optional, boolean) Corresponds to the Email Opt Out field in Zoho. Defaults to 0 for false.
	*/
	public void setEmailOptOut(Boolean value) {
		this.inputs.setInput("EmailOptOut", value);
	}

	/** 
	Set the value of the EmailOptOut input for this Choreo as a String. 

	@param String - (optional, boolean) Corresponds to the Email Opt Out field in Zoho. Defaults to 0 for false.
	*/
	public void setEmailOptOut(String value) {
		this.inputs.setInput("EmailOptOut", value);	
	}
	/** 
	Set the value of the Fax input for this Choreo. 

	@param String - (optional, string) Corresponds to the Fax field in Zoho
	*/
	public void setFax(String value) {
		this.inputs.setInput("Fax", value);
	}


	/** 
	Set the value of the FirstName input for this Choreo. 

	@param String - (optional, string) Corresponds to the First Name field in Zoho
	*/
	public void setFirstName(String value) {
		this.inputs.setInput("FirstName", value);
	}


	/** 
	Set the value of the Industry input for this Choreo. 

	@param String - (optional, string) Corresponds to the Industry field in Zoho
	*/
	public void setIndustry(String value) {
		this.inputs.setInput("Industry", value);
	}


	/** 
	Set the value of the LastName input for this Choreo. 

	@param String - (required, string) Corresponds to the Last Name field in Zoho
	*/
	public void setLastName(String value) {
		this.inputs.setInput("LastName", value);
	}


	/** 
	Set the value of the LeadOwner input for this Choreo. 

	@param String - (optional, string) Corresponds to the Lead Owner field in Zoho
	*/
	public void setLeadOwner(String value) {
		this.inputs.setInput("LeadOwner", value);
	}


	/** 
	Set the value of the LeadSource input for this Choreo. 

	@param String - (optional, string) Corresponds to the Lead Source field in Zoho
	*/
	public void setLeadSource(String value) {
		this.inputs.setInput("LeadSource", value);
	}


	/** 
	Set the value of the LeadStatus input for this Choreo. 

	@param String - (optional, string) Corresponds to the Lead Status field in Zoho
	*/
	public void setLeadStatus(String value) {
		this.inputs.setInput("LeadStatus", value);
	}


	/** 
	Set the value of the Mobile input for this Choreo. 

	@param String - (optional, string) Corresponds to the Mobile field in Zoho
	*/
	public void setMobile(String value) {
		this.inputs.setInput("Mobile", value);
	}


	/** 
	Set the value of the Module input for this Choreo. 

	@param String - (optional, string) The Zoho module you want to access. Defaults to 'Leads'.
	*/
	public void setModule(String value) {
		this.inputs.setInput("Module", value);
	}


	/** 
	Set the value of the NumOfEmployees input for this Choreo. 

	@param String - (optional, string) Corresponds to the Num Of Employees field in Zoho
	*/
	public void setNumOfEmployees(String value) {
		this.inputs.setInput("NumOfEmployees", value);
	}


	/** 
	Set the value of the Phone input for this Choreo. 

	@param String - (optional, string) Corresponds to the Phone field in Zoho
	*/
	public void setPhone(String value) {
		this.inputs.setInput("Phone", value);
	}


	/** 
	Set the value of the Rating input for this Choreo. 

	@param String - (optional, string) Corresponds to the Rating field in Zoho
	*/
	public void setRating(String value) {
		this.inputs.setInput("Rating", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid formats are: json and xml (the default).
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Salutation input for this Choreo. 

	@param String - (optional, string) Corresponds to the Salutation field in Zoho
	*/
	public void setSalutation(String value) {
		this.inputs.setInput("Salutation", value);
	}


	/** 
	Set the value of the SkypeID input for this Choreo. 

	@param String - (optional, string) Corresponds to the Skype ID field in Zoho
	*/
	public void setSkypeID(String value) {
		this.inputs.setInput("SkypeID", value);
	}


	/** 
	Set the value of the State input for this Choreo. 

	@param String - (optional, string) Corresponds to the State field in Zoho
	*/
	public void setState(String value) {
		this.inputs.setInput("State", value);
	}


	/** 
	Set the value of the Street input for this Choreo. 

	@param String - (optional, string) Corresponds to the Street field in Zoho
	*/
	public void setStreet(String value) {
		this.inputs.setInput("Street", value);
	}


	/** 
	Set the value of the Title input for this Choreo. 

	@param String - (optional, string) Corresponds to the Title field in Zoho
	*/
	public void setTitle(String value) {
		this.inputs.setInput("Title", value);
	}


	/** 
	Set the value of the Website input for this Choreo. 

	@param String - (optional, string) Corresponds to the Website field in Zoho
	*/
	public void setWebsite(String value) {
		this.inputs.setInput("Website", value);
	}


	/** 
	Set the value of the ZipCode input for this Choreo. 

	@param Integer - (optional, integer) Corresponds to the Zip Code field in Zoho
	*/
	public void setZipCode(Integer value) {
		this.inputs.setInput("ZipCode", value);
	}

	/** 
	Set the value of the ZipCode input for this Choreo as a String. 

	@param String - (optional, integer) Corresponds to the Zip Code field in Zoho
	*/
	public void setZipCode(String value) {
		this.inputs.setInput("ZipCode", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public InsertRecordsResultSet run() {
		JSONObject result = super.runWithResults();
		return new InsertRecordsResultSet(result);
	}
	
}
