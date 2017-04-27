package kr.co.koscom.marketdata.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.co.koscom.marketdata.api.ApiHelper;

@RestController
public class SimpleController {
	
    @RequestMapping("/")
    public ModelAndView home5() throws Exception {
    	return new ModelAndView("index", null);
    }

    @RequestMapping("/test")
    String home() {
        return "Hello World! ";
    }
    

    @RequestMapping("/News")
    String home3() throws IOException {
    	ApiHelper helper = new ApiHelper();
    	return helper.getNewsService("politics,economy", "삼성전자", "1");
    }
    
    @RequestMapping("/News2/{sections}/{query}/{pages}")
    String home2(@PathVariable(value="sections") String sections, @PathVariable(value="query") String query, @RequestParam(value="pages", required=false) String pages) 
    		throws IOException, Exception {
    	ApiHelper helper = new ApiHelper();
    	
    	if(null == sections) {
    		return "Section is not specified";
    	}
    	else if(null == query) {
    		return "Section is not specified";
    	}
    	else if(null == pages) {
//    		return "Section is not specified";
    		pages = "1";
    	} 
    		
    	// *** DEBUG
//    	return "sections:"+sections + " query:"+query+" pages:"+pages+"\n" + helper.getNewsService(sections, query, pages);
    	String jsonString = helper.getNewsService(sections, query, pages);
//    	JSONObject jsonObject = new JSONObject(jsonString);
    	return jsonString;
    }
}
