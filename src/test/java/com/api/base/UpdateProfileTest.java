package com.api.base;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.models.request.LoginRequest;
import com.api.models.request.UserProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {
	
	@Test
	public void updateProfileTest() {
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("uday1234", "uday12345"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
        System.out.println("--------------------------------------------------------------------------");
        
        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(loginResponse.getToken());
        System.out.println(response.asPrettyString());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        System.out.println(userProfileResponse.getUsername());
        Assert.assertEquals(userProfileResponse.getUsername(), "uday1234");
        System.out.println("--------------------------------------------------------------------------");
        
        UserProfileRequest userProfileRequest = new UserProfileRequest.Builder()
        		.firstName("virat")
        		.lastName("kohli")
        		.email("abc@gmail.com")
        		.mobileNumber("657800000")
        		.Builder();
        
        response = userProfileManagementService.updateProfile(loginResponse.getToken(), userProfileRequest);
        System.out.println(response.asPrettyString());
	}

}
