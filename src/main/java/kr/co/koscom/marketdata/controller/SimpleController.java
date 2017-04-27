package kr.co.koscom.marketdata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @RequestMapping("/test")
    String home() {
        return "Hello World!";
    }
    
    @RequestMapping("/test2/")
    String home2() throws IOException {
    	
        StringBuilder urlBuilder = new StringBuilder("https://sandbox-apigw.koscom.co.kr/v1/haystack/news/{search_section}/_search".replace("{search_section}", URLEncoder.encode("politics,economy", "UTF-8")));
        urlBuilder.append("?");
        urlBuilder.append(URLEncoder.encode("query","UTF-8") + "=" + URLEncoder.encode("삼성전자", "UTF-8") + "&");
        urlBuilder.append(URLEncoder.encode("page","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("apikey", "l7xx5d2ed6ed45514f9ca9b583a76300a90f");
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
}
