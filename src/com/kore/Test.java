package com.kore;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.sql.Connection;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.params.HttpParams;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.ultimatix.bot.exception.ChatBotException;

public class Test {
	
	   private static HttpsURLConnection httpConn = null;
	   private static String url = null;
	   private static URL url1 = null;
	   private static SSLContext ctx = null;
	   
	/*public String processInput() throws ChatBotException {
		//Map<String, String> globalParamMap = CacheDataServiceImpl.getInstance().getGlobalParamMap();
		//JSONObject jsonResponse = new JSONObject();
		ObjectMapper objMapper = new ObjectMapper();
		HttpClient httpclient = new DefaultHttpClient();
		String dialogFlowResponse = null;
		long gotResponse=0;
		//Map<String, Object> responseMap = new HashMap<String, Object>();
		//IntentVO intent = null;
		//System.out.println("Request coming from getReply function :"+req.toString());
		//String str = req.getParameter("data");
		//System.out.println("Value of Data is :"+str);
		//BotResponseBean botResponseInput = null;
		String workingURL = "https://api.dialogflow.com/v1/query?v=20150910";
		//String  webServerIP = req.getRemoteAddr();
		
			//String appServerIp = InetAddress.getLocalHost() .getHostAddress(); 
			//BotResponseBean response = null;
			try {
				botResponseInput = objMapper.readValue(str, BotResponseBean.class);
				String modQuery = botResponseInput.getQuery();
				//modQuery = filterString(modQuery);
				//LOG.info("After filtering query for special characters::::" + modQuery);
				botResponseInput.setQuery(modQuery);
				HttpPost httpPost = new HttpPost(workingURL);
				
				StringEntity params =new StringEntity("details={\"id\":\"123456\",\"query\":\"Hi\",\"sessionId\":\"e9b16b5e8c2b462fb4eb3d43160a43b5\",\"lang\":\"en-US\"} ");
				httpPost.setHeader("content-type","application/json");
				httpPost.setHeader("Authorization","bearer e9b16b5e8c2b462fb4eb3d43160a43b5");
				httpPost.setEntity(params);
				HttpResponse response = httpclient.execute(httpPost);
				HttpEntity resEntity = response.getEntity();
				gotResponse=response.getEntity().getContentLength();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					httpclient.getConnectionManager().shutdown();
				} catch (EnumConstantNotPresentException e2){
					//LOG.info("In catch block : while calling httpclient .shutdown method in WithAttachment",e2);
				}
				catch (Exception e2) {
					//LOG.info("In catch block : while calling httpclient .shutdown method in WithAttachment",e2);
				}
				
			}
			
			//String applicationName = botResponseInput.getApplicationName();
			//UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication()
			//		.getDetails();
			//System.out.println("User details coming from Framework :"+userDetails);
			//Map<String, String> userDetialsMap = userDetails.getUserInfo();
			//if (userDetialsMap != null && userDetialsMap.get("ID") != null && userDetialsMap.get("ID").length() > 0) {
			//	if (checkQuery(botResponseInput.getQuery())) {

					
		return String.valueOf(gotResponse);
	}*/
	
    private static void createHTTPConnection() {
        try {
            httpConn = (HttpsURLConnection) url1.openConnection();
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String arg0, SSLSession arg1) {
                    return false;
                }
            });

            httpConn.setRequestMethod("POST");
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);
            httpConn.setUseCaches(false);
            httpConn.setReadTimeout(10000);
        } catch (IOException e) {
            //LOG.error(EntSrchDataTrnsfrConstants.EXCEPTION_CONTEXT, e);
            e.getMessage();
        }
    }
    
    private static class DefaultTrustManager implements X509TrustManager {

        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
            // return if it can be validated and is trusted for client SSL
        }

        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
            // return if it can be validated and is trusted for server SSL
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }
	
    public void testFunction() throws IOException {
    	url = "https://api.dialogflow.com/v1/query?v=20150910";
        url1 = new URL(url.trim());
        createHTTPConnection();
        String status = httpConn.getResponseMessage();
        if ("OK".equalsIgnoreCase(status)) {
        	System.out.println("success");
        }
    }
    
    public void test2() throws ClientProtocolException, IOException {
    	
    	HttpHost proxy = new HttpHost("proxy.tcs.com", 8080);
    	DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
    	CloseableHttpClient httpclient = HttpClients.custom()
    	        .setRoutePlanner(routePlanner)
    	        .build();
    	
    	//HttpClient httpClient = new DefaultHttpClient();
        HttpPost getRequest = new HttpPost("https://api.dialogflow.com/v1/query?v=20150910");
        //httpClient.getParams().setParameter(ConnRouteParams.DEFAULT_PROXY, proxy);
        //getRequest.addHeader("accept", "application/xml");
        getRequest.addHeader("Authorization","bearer e9b16b5e8c2b462fb4eb3d43160a43b5");
        getRequest.addHeader("content-type","application/json");
        StringEntity params = new StringEntity("{'id':'123456','query':'Hi','sessionId':'e9b16b5e8c2b462fb4eb3d43160a43b5','lang':'en-US'}");
        getRequest.setEntity(params);
        /*HttpParams params =new HttpsParams("details={\"id\":\"123456\",\"query\":\"Hi\",\"sessionId\":\"e9b16b5e8c2b462fb4eb3d43160a43b5\",\"lang\":\"en-US\"} ");
        getRequest.setParams(params);*/
        HttpResponse response = httpclient.execute(getRequest);

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
               + response.getStatusLine().getStatusCode());
        }

        BufferedReader br = new BufferedReader(
                         new InputStreamReader((response.getEntity().getContent())));

        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }

        //httpClient.getConnectionManager().shutdown();
    }
    
	public static void main(String args[]) {
		Test obj = new Test();
		try {
			/*ctx = SSLContext.getInstance("TLSv1.2");
            ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
            SSLContext.setDefault(ctx);*/
			//obj.processInput();
            
            obj.test2();
		} /*catch (ChatBotException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} *//*catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
