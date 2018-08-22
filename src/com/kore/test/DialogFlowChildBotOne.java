package com.kore.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.json.JSONException;
import org.json.JSONObject;

public class DialogFlowChildBotOne implements Runnable {
	
	//private int number;
	private String clientAccessToken;
	private String query;
	private String botName;
	
	public DialogFlowChildBotOne(String clientAccessToken, String query, String botName) {
		this.clientAccessToken = clientAccessToken;
		this.query = query;
		this.botName = botName;
	}
	
	@Override
	public void run() {
		/*for (int i = number; i < number + 10000; i++)
			System.out.println("Child Bot One Called: " + i);*/
		HttpHost proxy = new HttpHost("proxy.tcs.com", 8080);
		DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
		CloseableHttpClient httpclient = HttpClients.custom()
		        .setRoutePlanner(routePlanner)
		        .build();
		
		String authToken = "bearer " + clientAccessToken;
		HttpPost postRequest = new HttpPost("https://api.dialogflow.com/v1/query?v=20150910");
		postRequest.addHeader("Authorization", authToken);
		postRequest.addHeader("content-type","application/json");
		 
		try {
			JSONObject jObject = new JSONObject();
			jObject.put("id", "123456");
		    jObject.put("query", query);
		    jObject.put("sessionId", clientAccessToken);
		    jObject.put("lang", "en-US");
			StringEntity params = new StringEntity(jObject.toString());
			postRequest.setEntity(params);
			HttpResponse response = httpclient.execute(postRequest);
			
			if (response.getStatusLine().getStatusCode() != 200) {
			    throw new RuntimeException("Failed : HTTP error code : "
			       + response.getStatusLine().getStatusCode());
			}
			BufferedReader br = new BufferedReader(
			                 new InputStreamReader((response.getEntity().getContent())));
			
			String output;
			String response2 = "";
			System.out.println("Output from Server ....");
			while ((output = br.readLine()) != null) {
				//System.out.println(output);
				response2 += output;
			}
			JSONObject jsonResponse = new JSONObject(response2);
			String finalResponse = jsonResponse.getJSONObject("result").getJSONObject("fulfillment").get("speech").toString();
			String score = jsonResponse.getJSONObject("result").get("score").toString();
			System.out.println("botName: " + botName + "\nQuery: " + query + "\nfinalResponse: " + finalResponse +"\nscore: " + score);
			System.out.println("\n");
			//httpClient.getConnectionManager().shutdown();
		} catch (JSONException e) {
			 e.printStackTrace();
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
}
