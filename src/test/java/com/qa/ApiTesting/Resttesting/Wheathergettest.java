package com.qa.ApiTesting.Resttesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;


public class Wheathergettest {
	
	
	@Test
	public void getrestapi() {
		
		RestAssured.baseURI= "http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httprequest =	RestAssured.given();
		
		Response response = 	httprequest.request(Method.GET,"/pune");
		
		String Stringresponses = response.getBody().asString();
		System.out.println(Stringresponses);
		
	Headers header =	response.getHeaders();
	
	System.out.println(header);
	
	int Status_code = response.getStatusCode();
	
	System.out.println("Status_code------------>"+Status_code);
	Assert.assertEquals(200, Status_code);
	
	JsonPath jsonpathvalue =	response.jsonPath();
	String city = jsonpathvalue.get("city");
		System.out.println(city);
	}
	
	
	@Test
	public void postrestapi() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		RequestSpecification request  = 	RestAssured.given();
		request.headers("Content-Type", "application/json");
	org.json.simple.JSONObject jsonobject = new org.json.simple.JSONObject();
	jsonobject.put("FirstName", "sridhar");
	jsonobject.put("LastName", "reddy");
	jsonobject.put("UserName", "sridh1");
	jsonobject.put("Password", "hello1231");
	jsonobject.put("Email", "sri@gmail1.com");
	
	request.body(jsonobject.toString());
	Response  resp = request.post("/register");
	String StringResponses = resp.asString();
	
	int status_code = resp.getStatusCode();
	System.out.println("status_code"+status_code);
	
Headers header =	resp.getHeaders();
System.out.println("Headers---------->");

System.out.println(StringResponses);
	
	
		
	}
	@Test
	public void putrestapi() {
		RestAssured.baseURI= "https://reqres.in/api/users";
		RequestSpecification Request = RestAssured.given();
		
		Request.header("Content-Type", "application/json");
		
		org.json.simple.JSONObject jasonobject = new org.json.simple.JSONObject();
		jasonobject.put("name", "ammaji");
		jasonobject.put("srinivas", "principle");
		
		String stringjason = jasonobject.toString();
		Response Reponses = Request.put(stringjason, "/api/users/2");
		int post_Req_statuscode = Reponses.getStatusCode();
		
		Assert.assertEquals(post_Req_statuscode, 200);
		Headers header = Reponses.getHeaders();
		System.out.println(header);
		
	String StringResponse = 	Reponses.body().asString();
	System.out.println("StringResponse------>"+StringResponse);
	
		
		
	}
	
	
	}
				

