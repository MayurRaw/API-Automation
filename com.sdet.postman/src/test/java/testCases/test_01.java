/*
*Author: Mayur Kumar
*Emp Id: MA20081559
*
*
*/
package testCases;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test_01 {

	static RequestSpecification httpRequest;
	static Response response;
	static JSONObject requestParams;

	static String responseBody;
	static int status;
	static String statusLine;

	@BeforeMethod
	void setUpMethod() {
		RestAssured.baseURI = "http://postman-echo.com";
		httpRequest = RestAssured.given();
		requestParams = new JSONObject();
	}

	@Test
	public void test_getResponse() {

		response = httpRequest.request(Method.GET, "/get?foo1=bar1&foo2=bar2");

		responseBody = response.getBody().asString();
		System.out.println("Response Body: " + responseBody);

		status = response.getStatusCode();
		System.out.println("Status Code; " + status);
		Assert.assertEquals(status, 200);

		statusLine = response.getStatusLine();
		System.out.println("Status Line: " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

	}

	@SuppressWarnings("unchecked")
	@Test
	public void test_postResponse() {

		requestParams.put("Test-text", "This is my first POST response test.");
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());

		response = httpRequest.request(Method.POST, "/post");

		responseBody = response.getBody().asString();
		System.out.println("Response Body: " + responseBody);

		status = response.getStatusCode();
		System.out.println("Status Code; " + status);
		Assert.assertEquals(status, 200);

		statusLine = response.getStatusLine();
		System.out.println("Status Line: " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

		String responseText = response.jsonPath().getString("json");
		responseText = responseText.substring(11, responseText.length() - 1);
		System.out.println("response Text: " + responseText);
		Assert.assertEquals(responseText, "This is my first POST response test.");
	}

	@SuppressWarnings("unchecked")
	@Test
	public void test_putResponse() {

		requestParams.put("Test-text", "This is my first PUT response test.");
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());

		response = httpRequest.request(Method.PUT, "/put");

		responseBody = response.getBody().asString();
		System.out.println("Response Body: " + responseBody);

		status = response.getStatusCode();
		System.out.println("Status Code; " + status);
		Assert.assertEquals(status, 200);

		statusLine = response.getStatusLine();
		System.out.println("Status Line: " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

		String responseText = response.jsonPath().getString("json");
		responseText = responseText.substring(11, responseText.length() - 1);
		System.out.println("response Text: " + responseText);
		Assert.assertEquals(responseText, "This is my first PUT response test.");
	}

	@SuppressWarnings("unchecked")
	@Test
	public void test_deleteResponse() {

		requestParams.put("Test-text", "This is my first DELETE response test.");
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());

		response = httpRequest.request(Method.DELETE, "/delete");

		responseBody = response.getBody().asString();
		System.out.println("Response Body: " + responseBody);

		status = response.getStatusCode();
		System.out.println("Status Code; " + status);
		Assert.assertEquals(status, 200);

		statusLine = response.getStatusLine();
		System.out.println("Status Line: " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

		String responseText = response.jsonPath().getString("json");
		responseText = responseText.substring(11, responseText.length() - 1);
		System.out.println("response Text: " + responseText);
		Assert.assertEquals(responseText, "This is my first DELETE response test.");
	}

	@AfterMethod
	void tearDownMethod() {

		requestParams.clear();
	}

}
