package com.tristan3fish;

import java.io.BufferedReader;
//import java.io.IOException;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



//https://www.mkyong.com/java/how-to-automate-login-a-website-java-example/
public class HttpUrlConnection {
	
	  //private List<String> cookies;
	  private HttpsURLConnection conn;

	  private final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36";//"Mozilla/5.0";
	
	
	String url0 = "https://www.charles-stanley-direct.co.uk/Account";
	String url1 = "https://www.charles-stanley-direct.co.uk/Account/CheckMemorableWord";
	
	public static void main(String[] args) throws Exception {
		
		HttpUrlConnection httpUrlConnection = new HttpUrlConnection();
		
		httpUrlConnection.start();

	}
	
	private void start() throws Exception {
		// make sure cookies is turn on
		CookieHandler.setDefault(new CookieManager());
		
		
		// 1. Send a "GET" request, so that you can extract the form's data.
		String page = this.GetPageContent(url0);
		System.out.println(page);
		System.out.println();
		
		String postParams = this.getFormParams(page, "tristan3fish", "lWibble1066");
		System.out.println(postParams);
		System.out.println();
		
		// 2. Construct above post's content and then send a POST request for authentication
		//this.sendPost(url0, postParams);
	}

	  private String GetPageContent(String url) throws Exception {

		  /*
		  GET /Account HTTP/1.1
		  Host: www.charles-stanley-direct.co.uk
		  Connection: keep-alive
		  Upgrade-Insecure-Requests: 1
		  User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36
		  Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*//*;q=0.8
		  Accept-Encoding: gzip, deflate, sdch, br
		  Accept-Language: en-US,en;q=0.8
		  Cookie: __cfduid=d366ee9835d8ecd9d409efa225dafb1351477177743; __RequestVerificationToken=L2eESLvm3NFx9mxI9fPl3UmnL859zdMF-mL2pW3Y3oOtfT9E8_P3f8-MbjuoZnZ86Wuv4PqrTPdeNq37jN5U_Iy5Kb1kJSAqgMBqYfPpNfghJLDzLRCTiOelRUEIeYHmFpLdrvgh4pNBfsmNSZIExQ2; ASP.NET_SessionId=jwm3a0ayqpypw13bzlqrthnl; _dc_gtm_UA-36370981-1=1; _ga=GA1.3.530499133.1477177765
		  */
		  
			URL obj = new URL(url);
			conn = (HttpsURLConnection) obj.openConnection();

			// default is GET
			conn.setRequestMethod("GET");

			conn.setUseCaches(false);

			// act like a browser
			//User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36
			conn.setRequestProperty("User-Agent", USER_AGENT);
			conn.setRequestProperty("Host", "www.charles-stanley-direct.co.uk");
			
			  //Connection: keep-alive
			conn.setRequestProperty("Connection","keep-alive");
			  //Upgrade-Insecure-Requests: 1
			conn.setRequestProperty("Upgrade-Insecure-Requests","1");
			  //                     Accept:  text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*//*;q=0.8
			conn.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*//*;q=0.8");
			  ///Accept-Encoding: gzip, deflate, sdch, br
			//conn.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch, br");//"gzip, deflate, sdch, br");
			  //Accept-Language: en-US,en;q=0.8
			conn.setRequestProperty("Accept-Language","en-US,en;q=0.8");
			  //Cookie: __cfduid=d366ee9835d8ecd9d409efa225dafb1351477177743; __RequestVerificationToken=L2eESLvm3NFx9mxI9fPl3UmnL859zdMF-mL2pW3Y3oOtfT9E8_P3f8-MbjuoZnZ86Wuv4PqrTPdeNq37jN5U_Iy5Kb1kJSAqgMBqYfPpNfghJLDzLRCTiOelRUEIeYHmFpLdrvgh4pNBfsmNSZIExQ2; ASP.NET_SessionId=jwm3a0ayqpypw13bzlqrthnl; _dc_gtm_UA-36370981-1=1; _ga=GA1.3.530499133.1477177765
			conn.setRequestProperty("Cookie","__cfduid=d366ee9835d8ecd9d409efa225dafb1351477177743; __RequestVerificationToken=L2eESLvm3NFx9mxI9fPl3UmnL859zdMF-mL2pW3Y3oOtfT9E8_P3f8-MbjuoZnZ86Wuv4PqrTPdeNq37jN5U_Iy5Kb1kJSAqgMBqYfPpNfghJLDzLRCTiOelRUEIeYHmFpLdrvgh4pNBfsmNSZIExQ2; ASP.NET_SessionId=jwm3a0ayqpypw13bzlqrthnl; _dc_gtm_UA-36370981-1=1; _ga=GA1.3.530499133.1477177765");

			
			//if (cookies != null) {
			//	for (String cookie : this.cookies) {
			//		conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
			//	}
			//}
			int responseCode = conn.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			Map<String, List<String>> hf = conn.getHeaderFields();
			for(String key : hf.keySet()){
				if(!(key==null)){
				System.out.print(key + ": ");
				
				int i=0;
				for(String val : hf.get(key)){
					if(i==0){
						System.out.print(val);
					}else{
						System.out.print(", "+val);
					}
					i++;
				}
				System.out.println("");
				}
			}
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// Get the response cookies
			//setCookie(conn.getHeaderFields().get("Set-Cookie"));

			
			
			return response.toString();

		  }
	
	 // public void setCookie(List<String> cookies) {
	//		this.cookies = cookies;
		//  }
	  
	  public String getFormParams(String html, String username, String password)
				throws UnsupportedEncodingException {

			System.out.println("Extracting form's data...");

			Document doc = Jsoup.parse(html);

			// Google form id
			Element loginform = doc.getElementById("login-form");
			Elements inputElements = loginform.getElementsByTag("input");
			List<String> paramList = new ArrayList<String>();
			for (Element inputElement : inputElements) {
				String key = inputElement.attr("name");
				String value = inputElement.attr("value");

				//System.out.println("input:" + key +", " + value);
				
/*				try {
					System.in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				if (key.equals("LoginId"))
					value = username;
				else if (key.equals("Password"))
					value = password;
				//__RequestVerificationToken
				if(!key.equals("login-submit"))
					paramList.add(key + "=" + URLEncoder.encode(value, "UTF-8"));
			}

			// build parameters list
			StringBuilder result = new StringBuilder();
			for (String param : paramList) {
				if (result.length() == 0) {
					result.append(param);
				} else {
					result.append("&" + param);
				}
			}
			return result.toString();
		  }
	
	  @SuppressWarnings("unused")
	private void sendPost(String url, String postParams) throws Exception {

			URL obj = new URL(url);
			conn = (HttpsURLConnection) obj.openConnection();

			// Acts like a browser
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Host", "www.charles-stanley-direct.co.uk");
			conn.setRequestProperty("User-Agent", USER_AGENT);
			conn.setRequestProperty("Accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			conn.setRequestProperty("Accept-Language", "en-US,en;q=0.8");
			conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
			
			
			String myCookie ="";
			/*
			for (String cookie : this.cookies) {
				if(!cookie.trim().equals("")){
					myCookie += cookie + "; ";
				}
			}
			
			System.out.println("cookie:" + myCookie);
			if(myCookie.length()>=2){
				myCookie = myCookie.substring(0, myCookie.length()-2).trim();
			}
			System.out.println("cookie:" + myCookie);
			*/
			myCookie = "__cfduid=d366ee9835d8ecd9d409efa225dafb1351477177743; __RequestVerificationToken=L2eESLvm3NFx9mxI9fPl3UmnL859zdMF-mL2pW3Y3oOtfT9E8_P3f8-MbjuoZnZ86Wuv4PqrTPdeNq37jN5U_Iy5Kb1kJSAqgMBqYfPpNfghJLDzLRCTiOelRUEIeYHmFpLdrvgh4pNBfsmNSZIExQ2; ASP.NET_SessionId=jwm3a0ayqpypw13bzlqrthnl; _ga=GA1.3.530499133.1477177765; _dc_gtm_UA-36370981-1=1";
			
			conn.addRequestProperty("Cookie", myCookie);
			conn.setRequestProperty("Connection", "keep-alive");
			conn.setRequestProperty("Referer", url);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length", Integer.toString(postParams.length()));
			conn.setRequestProperty("Origin", "https://www.charles-stanley-direct.co.uk");
			conn.setRequestProperty("Cache-Control","max-age=0");
			//conn.setRequestProperty("Upgrade-Insecure-Requests", 1);
			
			/*
			POST /Account HTTP/1.1
			Host: www.charles-stanley-direct.co.uk
			Connection: keep-alive
			Content-Length: 220
			Cache-Control: max-age=0
			Origin: https://www.charles-stanley-direct.co.uk
			Upgrade-Insecure-Requests: 1
			User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36
			Content-Type: application/x-www-form-urlencoded
			Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*//*;q=0.8
			Referer: https://www.charles-stanley-direct.co.uk/Account
			Accept-Encoding: gzip, deflate, br
			Accept-Language: en-US,en;q=0.8
			Cookie: __cfduid=d366ee9835d8ecd9d409efa225dafb1351477177743; __RequestVerificationToken=L2eESLvm3NFx9mxI9fPl3UmnL859zdMF-mL2pW3Y3oOtfT9E8_P3f8-MbjuoZnZ86Wuv4PqrTPdeNq37jN5U_Iy5Kb1kJSAqgMBqYfPpNfghJLDzLRCTiOelRUEIeYHmFpLdrvgh4pNBfsmNSZIExQ2; ASP.NET_SessionId=jwm3a0ayqpypw13bzlqrthnl; _ga=GA1.3.530499133.1477177765; _dc_gtm_UA-36370981-1=1
			
			*/
			
			
			
			
			
			conn.setDoOutput(true);
			conn.setDoInput(true);

			// Send post request
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.writeBytes(postParams);
			wr.flush();
			wr.close();

			int responseCode = conn.getResponseCode();
			// Get the response cookies
			//setCookie(conn.getHeaderFields().get("Set-Cookie"));
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + postParams);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in =
		             new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			 System.out.println(response.toString());

		  }
}
