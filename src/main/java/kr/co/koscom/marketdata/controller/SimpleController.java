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
    	return new ModelAndView("index", null);
    }
    
//    @RequestMapping("/Search/News")
//    public ModelAndView showNews() throws Exception {
//
//    	ApiHelper helper = new ApiHelper();
//    	String jsonString = helper.getNewsService("economy", "삼성전자", "1");
//    	JSONObject jo = new JSONObject(jsonString);
//    	ModelMap model = new ModelMap();
//    	model.addAttribute("data", jo.get("data"));
//    	
//    	
//    	return new ModelAndView("search_news", model);
//    }
    
    @RequestMapping("/test")
    public String test() {
        return "Hello World! ";
    }

    // *** TEST
//    @RequestMapping("/News")
//    String home3() throws IOException {
//    	ApiHelper helper = new ApiHelper();
//    	return helper.getNewsService("politics,economy", "삼성전자", "1");
//    }
    
    @RequestMapping(
    		value="/News2/{sections}/{query}/{pages}",
    		method={RequestMethod.GET, RequestMethod.POST} )
    public String getNewsList(
    		@PathVariable(value="sections") String sections, 
    		@PathVariable(value="query") String query, 
    		@PathVariable(value="pages", required=false) String pages) throws IOException, Exception {
    	ApiHelper helper = new ApiHelper();
    	
    	if(null == sections) {
    		return "Section is not specified";
    	}
    	else if(null == query) {
    		return "Section is not specified";
    	}
    	else if(null == pages) {
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
