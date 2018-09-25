package com.qa.api;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;



public class restapitestcase {
	@Test(enabled = false)
	public void gethttprepsonse() throws ParseException, IOException {
		
		Map<String,String>head = new HashMap<String,String>();
		head.put("content-type", "application/json");
		
	restapitest restapi = new restapitest();
	CloseableHttpResponse	httpresponses = restapi.gethttp(head);
	int status_code = httpresponses.getStatusLine().getStatusCode();
	System.out.println("status_code= "+status_code);
	Map<String,String > heads = new HashMap<String,String>();
	
	Header[]  header = httpresponses.getAllHeaders();
	for(Header head1: header) {
	heads.put(head1.getName(), head1.getValue());
	}
	
	System.out.println("Allheader = "+heads);
	String responses = EntityUtils.toString(httpresponses.getEntity());
	System.out.println("responses---->"+responses);
	JSONObject  object = new JSONObject(responses);

	}
	
	
public void posthttprepsonse() throws ParseException, IOException {
		
		Map<String,String>head = new HashMap<String,String>();
		head.put("content-type", "application/json");
		user1 use = new user1("krishna", "TestEngineer");
		ObjectMapper mapper = new ObjectMapper();
		File Ip = new File("C:\\Users\\dssri\\eclipse-workspace\\Resttesting\\user1.json");
		mapper.writeValue(Ip, use);
	String body = 	mapper.writeValueAsString(use);
	restapitest restapi = new restapitest();
	CloseableHttpResponse	httpresponses = restapi.posthttp(head, body);
	//status code
	int status_code = httpresponses.getStatusLine().getStatusCode();
	System.out.println("status_code= "+status_code);
	Map<String,String > heads = new HashMap<String,String>();
	
	Header[]  header = httpresponses.getAllHeaders();
	for(Header head1: header) {
	heads.put(head1.getName(), head1.getValue());
	}
	
	System.out.println("Allheader = "+heads);
	String responses = EntityUtils.toString(httpresponses.getEntity(),"UTF-8");
	
	//System.out.println("responses---->"+responses);
	JSONObject json = new JSONObject(responses);
	System.out.println(json);
	user1 userobject = mapper.readValue(responses, user1.class);
	System.err.println(userobject);
	

	}
	@Test(priority =1)
	public void restapiget() {
		
		RestAssured.baseURI ="http://restapi.demoqa.com/utilities/weather/city";
		
		
		RequestSpecification  request = RestAssured.given();
		
		
		org.json.simple.JSONObject jsonobject  = new org.json.simple.JSONObject();
		jsonobject.put("FirstName", "sridhar");
		jsonobject.put("LastName", "reddy");
		jsonobject.put("UserName", "sridh1");
		jsonobject.put("Password", "hello1231");
		jsonobject.put("Email", "sri@gmail1.com");
		request.body(jsonobject);
		Response responses=	request.get("/pune");
		int status_code = responses.getStatusCode();
		System.out.println("status_code"+status_code);
	Headers head =	responses.getHeaders();
	System.out.println(head);
	String Stringresponse = 	responses.getBody().asString();
System.out.println("Stringresponse"+Stringresponse);
		
		
		
		
		
	}
}
