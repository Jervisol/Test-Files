package com.API.cases;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class API_TC01 {
//create http client
//http post
//args:setEntity();
//execute(httppost)
	@Test
	public void testreg() throws Exception{
		//api addr
		String regAPI = "...";
		//request method
		HttpPost regPost = new HttpPost(regAPI);
		//http client
		CloseableHttpClient testClient = HttpClients.createDefault();
		//args
		BasicNameValuePair arg1 = new BasicNameValuePair(regAPI, regAPI);
		BasicNameValuePair arg2 = new BasicNameValuePair(regAPI, regAPI);
		List<BasicNameValuePair> args = new ArrayList<BasicNameValuePair>();
		args.add(arg1);
		args.add(arg2);
		regPost.setEntity(new UrlEncodedFormEntity(args));
		//send request
		CloseableHttpResponse regResponse = testClient.execute(regPost);
		//analysis respond
		String regResult = EntityUtils.toString(regResponse.getEntity());
		System.out.println(regResult);
	}
	
}
