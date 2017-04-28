package kr.co.koscom.marketdata.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import kr.co.koscom.marketdata.common.CommonConfig;

public class ApiHelper {
	public String getNewsService(String sections, String query, String page) throws IOException {    	
        StringBuilder urlBuilder = new StringBuilder("https://sandbox-apigw.koscom.co.kr/v1/haystack/news/{search_section}/_search".replace("{search_section}", URLEncoder.encode(sections, "UTF-8")));
        urlBuilder.append("?");
        urlBuilder.append(URLEncoder.encode("query","UTF-8") + "=" + URLEncoder.encode(query, "UTF-8") + "&");
        urlBuilder.append(URLEncoder.encode("page","UTF-8") + "=" + URLEncoder.encode(page, "UTF-8"));
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("apikey", CommonConfig._APIKEY);
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        
        return sb.toString();
	}
	
	public String getMarketIssueMaster(String marketCode, String issueCode) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/{issuecode}/master".replace("{marketcode}", URLEncoder.encode("kospi", "UTF-8")).replace("{issuecode}", URLEncoder.encode("005930", "UTF-8")));
        urlBuilder.append("?");
        urlBuilder.append(URLEncoder.encode("apikey","UTF-8") + "=" + URLEncoder.encode(CommonConfig._APIKEY, "UTF-8"));
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        return sb.toString();
	}
	
	public String getStockInfo(String marketcode, String issuecode) throws IOException {
		StringBuilder urlBuilder = new StringBuilder("https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/{issuecode}/master".replace("{marketcode}", URLEncoder.encode(marketcode, "UTF-8")).replace("{issuecode}", URLEncoder.encode(issuecode, "UTF-8")));
		System.out.println(urlBuilder.toString());
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("apikey", CommonConfig._APIKEY);
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        
        return sb.toString();
	} 
	
}
