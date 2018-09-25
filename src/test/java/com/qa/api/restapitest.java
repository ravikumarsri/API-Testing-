package com.qa.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class restapitest {
	
	String url ="https://reqres.in/api/users?page=2";

	public CloseableHttpResponse gethttp(Map<String,String>head) throws ClientProtocolException, IOException {
		
		CloseableHttpClient  closeablehttpclient = HttpClients.createDefault();
		HttpGet request = new HttpGet(url);
		for (Map.Entry<String, String> heads :head.entrySet())
		{
		request.addHeader(heads.getValue(), heads.getValue());
		}
		CloseableHttpResponse httpresponses = closeablehttpclient.execute(request);
		
		return httpresponses;
}
	

	public CloseableHttpResponse posthttp(Map<String,String>head,String body) throws ClientProtocolException, IOException {
		
		CloseableHttpClient  closeablehttpclient = HttpClients.createDefault();
		HttpPost request = new HttpPost(url);
		for (Map.Entry<String, String> heads :head.entrySet())
		{
		request.addHeader(heads.getValue(), heads.getValue());
		}
		CloseableHttpResponse httpresponses = closeablehttpclient.execute(request);
		
		return httpresponses;
}
	
}
