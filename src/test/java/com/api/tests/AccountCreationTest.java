package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	@Test
	public void accountCreationTest() {
		SignUpRequest signupRequest = new SignUpRequest.Builder()
				.username("sachin1234")
				.password("sachin12345")
				.email("sachin1234@gmail.com")
				.firstName("sachin")
				.lastName("ramesh")
				.mobileNumber("987654329")
				.build();
		
		
		AuthService authService = new AuthService();
		 Response response = authService.signUp(signupRequest);
		 Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		 Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	

}
