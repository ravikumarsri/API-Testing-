package com.qa.ApiTesting.Resttesting;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.util.TestUtil;

import Base.BaseApi;
import data.Users;

public class ApiTestcase extends BaseApi {
	BaseApi base;
	String endpointurl;
	String Serviceurl;
	String URI;
	
	@BeforeMethod
	public void setup() {
	base = new BaseApi();
	 endpointurl = pro.getProperty("URL");
	
	 Serviceurl = pro.getProperty("ServiceURL");
			
			 URI = endpointurl+Serviceurl;
	
		
		
	}

	@Test(enabled =false)
	public void gettestcase() throws ClientProtocolException, IOException {
		
		App app =new App ();
		CloseableHttpResponse httpreponses = app.getmethod(URI);
		
		int Responses_Status_code = httpreponses.getStatusLine().getStatusCode();
		System.out.println("Responses_Status_code------>"+Responses_Status_code);
		
		Header[] header = httpreponses.getAllHeaders();
		Map <String,String> map = new HashMap<String,String>();
		for(Header head : header) {
			map.put(head.getName(), head.getValue());
		}
		System.out.println(map);
		
		String stringreponses = EntityUtils.toString( httpreponses.getEntity());
		
		System.out.println(stringreponses);
		JSONObject responsesjson = new JSONObject(stringreponses);
	String per_page = TestUtil.getValueByJPath(responsesjson, "/per_page");
	Assert.assertEquals(Integer.parseInt(per_page), 3);
		
		
	}
	
	@Test(enabled=false)
	public void getwithheadertestcase() throws ClientProtocolException, IOException {
		App app =new App ();
		Map<String,String>map = new HashMap<String,String>();
		map.put("Authorization", "Basic Og==");

		CloseableHttpResponse httpreponses = app.getmethodwithheaders(URI, map);

		System.out.println("Statuscode "+httpreponses.getStatusLine().getStatusCode());

		Header[] header = httpreponses.getAllHeaders(); 

		Map <String,String> head = new HashMap <String,String>();

		for (Header headerarray :  header) {

			head.put(headerarray.getName(), headerarray.getValue());
		}
		System.out.println("header ---------> "+head);

		String StringReponse = 	EntityUtils.toString(httpreponses.getEntity());

		JSONObject reponsesjson = new JSONObject(StringReponse);


		String Per_pagevalue = TestUtil.getValueByJPath(reponsesjson, "/per_page");

		Assert.assertEquals(Integer.parseInt(Per_pagevalue), 3);

		String Total_value = TestUtil.getValueByJPath(reponsesjson, "/total");
		Assert.assertEquals(Integer.parseInt(Total_value), 12);
		
		String first_name = TestUtil.getValueByJPath(reponsesjson, "/data[0]/first_name");
		Assert.assertEquals(first_name, "George");
		
	}
	@Test
	public void postwithheadertestcase() throws ClientProtocolException, IOException {
		
	
		App app =new App ();
		Map <String,String> header = new HashMap <String,String>();
		header.put("content-type", "application/json");
		
		
		ObjectMapper mapper = new ObjectMapper();
		Users user = new Users("sridhar","projectmanger");
		File file = new File("C:\\Users\\dssri\\eclipse-workspace\\Resttesting\\user.json");
		
		mapper.writeValue(file,user);
		
		String Stringjson = mapper.writeValueAsString(user);
		System.out.println("Stringjson---------->"+Stringjson);
		CloseableHttpResponse httpresponses =	app.postmethodwithheaders(URI, header, Stringjson);
		
		System.out.println(httpresponses.getStatusLine().getStatusCode());
		Header[] headerArray =	httpresponses.getAllHeaders();
		
		Map<String, String> map = new HashMap<String, String>();
		for (Header head :headerArray) {
			map.put(head.getName(), head.getValue());
		}
		System.out.println(map);
		
		String Stringresponses = EntityUtils.toString(httpresponses.getEntity(),"UTF-8");
		System.out.println(Stringresponses);
		JSONObject reponsesjson = new JSONObject(Stringresponses);
		
		System.out.println("reponsesjson-------->>"+reponsesjson);
		
		Users user1 = mapper.readValue(Stringresponses, Users.class);
		System.out.println(user1.getName().equals(user.getName()));
		System.out.println(user1.getJob().equals(user.getJob()));
	}
	
	
	
}
