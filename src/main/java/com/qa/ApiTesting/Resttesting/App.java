package com.qa.ApiTesting.Resttesting;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public CloseableHttpResponse getmethod(String url) throws ClientProtocolException, IOException{
    
    	CloseableHttpClient httpclient =  HttpClients.createDefault();
    	
    	HttpGet httpget = new HttpGet(url);
    	CloseableHttpResponse httpResponses = httpclient.execute(httpget);
    	
    	return httpResponses;
    }
    
    public CloseableHttpResponse getmethodwithheaders(String url, Map<String,String> head) throws ClientProtocolException, IOException{
        
    	CloseableHttpClient httpclient =  HttpClients.createDefault();
    	    	  	
    	HttpGet httpget = new HttpGet(url);
    	  	
    	for(Map.Entry<String, String> header : head.entrySet()) {
    		httpget.addHeader(header.getKey(), header.getValue());
    	
    	}
    	
    	
    	CloseableHttpResponse httpResponses = httpclient.execute(httpget);
    	
    	return httpResponses;
    }
 public CloseableHttpResponse postmethodwithheaders(String url, Map<String,String> head,String Stringjson) throws ClientProtocolException, IOException{
        
    	CloseableHttpClient httpclient =  HttpClients.createDefault();
    	    	  	
    	HttpPost httppost = new HttpPost(url);
    	  	
    	for(Map.Entry<String, String> header : head.entrySet()) {
    		httppost.addHeader(header.getKey(), header.getValue());
    	
    	}
    	httppost.setEntity(new StringEntity(Stringjson));   	
    	CloseableHttpResponse httpResponses = httpclient.execute(httppost);
    	
    	return httpResponses;
    
}
}