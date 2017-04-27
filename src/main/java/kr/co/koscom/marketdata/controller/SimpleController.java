package kr.co.koscom.marketdata.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.koscom.marketdata.api.ApiHelper;

@RestController
public class SimpleController {

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
    String home2(@PathVariable(value="sections") String sections, @PathVariable(value="query") String query, @RequestParam(value="pages", required=false) String pages) throws IOException {
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
    	return "sections:"+sections + " query:"+query+" pages:"+pages+"\n" + helper.getNewsService(sections, query, pages);
//    	return helper.getNewsService(sections, query, pages);
    }
}
