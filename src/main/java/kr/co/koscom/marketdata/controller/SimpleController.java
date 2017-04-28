package kr.co.koscom.marketdata.controller;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.co.koscom.marketdata.api.ApiHelper;

@RestController
public class SimpleController {
	
    @RequestMapping("/")
    public ModelAndView home() throws Exception {
//    	System.out.println("home");
    	return new ModelAndView("index", null);
    }
    
    @RequestMapping("/Search/News")
    public ModelAndView showNews(
    		@RequestParam(value = "politics", required=false) String cat1,
    		@RequestParam(value = "economy", required=false) String cat2,
    		@RequestParam(value = "society", required=false) String cat3,
    		@RequestParam(value = "culture", required=false) String cat4,
    		@RequestParam(value = "world", required=false) String cat5,
    		@RequestParam(value = "tech", required=false) String cat6,
    		@RequestParam(value = "opinion", required=false) String cat7,
    		@RequestParam(value = "query", required=false) String query
    		) throws Exception {
    	
    	StringBuilder sb = new StringBuilder();
    	if(null != cat1) {
    		sb.append(cat1);
    		sb.append(",");
    	}
    	if(null != cat2) {
    		sb.append(cat2);
    		sb.append(",");
    	}
    	if(null != cat3) {
    		sb.append(cat3);
    		sb.append(",");
    	}
    	if(null != cat4) {
    		sb.append(cat4);
    		sb.append(",");
    	}
    	if(null != cat5) {
    		sb.append(cat5);  
    		sb.append(",");
    	}  	
    	if(null != cat6) {
    		sb.append(cat6);   
    		sb.append(",");
    	} 	
    	if(null != cat7) {
    		sb.append(cat7);
    		sb.append(",");
    	}
    	
    	if(sb.length() <= 0) {
    		System.out.println("no params");
    		return new ModelAndView("search_news", null);
    	}
    	
    	if(',' == sb.charAt(sb.length()-1))
    		sb.setLength(sb.length()-1);
    	
    	String category = sb.toString();
    	System.out.println(category);
    	System.out.println(query);

    	ModelMap model = new ModelMap();
    	ApiHelper helper = new ApiHelper();
    	String jsonString = helper.getNewsService(category, query, "1");
    	JSONObject jo = new JSONObject(jsonString);
    	if(false == jo.getBoolean("found")) {
    		System.out.println("no data found");
    		return new ModelAndView("search_news", null);
    	}

		System.out.println("done");
    	model.addAttribute("docs", jo.getJSONObject("data").getJSONArray("docs"));
    	
    	return new ModelAndView("search_news", model);
    }
    
    @RequestMapping("/test")
    public String test() {
    	System.out.println("test");
        return "Hello World! ";
    }

    // *** TEST
//    @RequestMapping("/News")
//    String home3() throws IOException {
//    	ApiHelper helper = new ApiHelper();
//    	return helper.getNewsService("politics,economy", "삼성전자", "1");
//    }
    
    @RequestMapping(
    		value="/News/{sections}/{query}/{pages}",
    		method={RequestMethod.GET, RequestMethod.POST} )
    public String getNewsList(
    		@PathVariable(value="sections") String sections, 
    		@PathVariable(value="query") String query, 
    		@PathVariable(value="pages", required=false) String pages) throws IOException, Exception {
    	
    	System.out.println("getNewsList");
    	
    	ApiHelper helper = new ApiHelper();
    	
    	if(null == sections || sections.equals("")) {
    		return "Section is not specified";
    	}
    	else if(null == query || query.equals("")) {
    		return "query is not specified";
    	}
    	else if(null == pages || pages.equals("")) {
    		return "Pages is not specified";
    	} 
    		
    	// *** DEBUG
//    	return "sections:"+sections + " query:"+query+" pages:"+pages+"\n" + helper.getNewsService(sections, query, pages);
    	String jsonString = helper.getNewsService(sections, query, pages);
    	JSONObject jo = new JSONObject(jsonString);
    	ModelMap map = new ModelMap();
    	map.addAttribute("docs", jo.get("data"));
    	return jsonString;
    }
}
