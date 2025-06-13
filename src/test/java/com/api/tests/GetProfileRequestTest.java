package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {
	
	@Test
	public void getProfileInfoTest() {
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("uday1234", "uday12345"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		System.out.println("Login response: " + response.getBody().asString());
		System.out.println("Status code: " + response.getStatusCode());

		
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		 response = userProfileManagementService.getProfile(loginResponse.getToken());
		 
		   System.out.println("Profile Response Body: " + response.getBody().asString());
		    System.out.println("Profile Status Code: " + response.getStatusCode());
		    System.out.println("Profile Content-Type: " + response.getContentType());
		UserProfileResponse userProfileResponse= response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getUsername());
	}

}
