package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class ForgotPassword {
	
	@Test
	public void forgotPassword() {
		
		AuthService authService = new AuthService();
		 Response response = authService.forgotPassword("venkatbalasundaram3@gmail.com");
		 Assert.assertEquals(response.asPrettyString(), "If your email exists in our system, you will receive reset instructions.");
	}
	
	

}
