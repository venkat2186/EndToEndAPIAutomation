package com.api.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.api.listeners.TestListener;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter{
	private static final Logger logger = LogManager.getLogger(LoggingFilter.class);

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		logRequest(requestSpec);
		 Response response = ctx.next(requestSpec, responseSpec); //Request is going to be executed
        logResponse(response);
		return response; // test for assertion
	}

	public void logRequest(FilterableRequestSpecification requestSpec) {
		logger.info("Base URI: {}" + requestSpec.getBaseUri());
        logger.info("Base Header: {} " + requestSpec.getHeaders());
        logger.info("Base payload: {} " + requestSpec.getBody());

		
	}
	
	public void logResponse(Response response) {
        logger.info(" Status code: {}", response.getStatusCode());
        logger.info("Response Header: {} ", response.headers());
        logger.info("Response Body: {} ", response.getBody().prettyPrint());
    }

}
