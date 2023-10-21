package com.soaptest.soaptest;

import org.example.customer_details.CustomerDetails;
import org.example.customer_details.GetCustomerDetailsRequest;
import org.example.customer_details.GetCustomerDetailsResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CustomerEndpoint {

	@PayloadRoot(namespace = "http://www.example.org/customer-details", localPart = "getCustomerDetailsRequest")
	@ResponsePayload
	public GetCustomerDetailsResponse getCustomerResponseDetails(@RequestPayload GetCustomerDetailsRequest getCustomerDetailsRequest) {
		
		CustomerDetails custDetails= new CustomerDetails();
		custDetails.setId(1);
		custDetails.setName("Panda");
		custDetails.setAddress("Tokyo");
		
		GetCustomerDetailsResponse custReponse= new GetCustomerDetailsResponse();
		
		custReponse.setCustomerDetails(custDetails);
		
		return custReponse;
	}
}
