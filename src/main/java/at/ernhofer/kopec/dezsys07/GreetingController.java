package at.ernhofer.kopec.dezsys07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	
	@Autowired
    private DataRepository datarepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html")
    public String redirectToDisplayDataRecords() {
        return "redirect:iknow/get";
    }

    @RequestMapping(value = {"/iknow","/iknow/get"}, method = RequestMethod.GET, produces = "text/html")
    public String displayiKnowGet(@RequestParam(value = "suchbegriff", defaultValue = "") String suchbegriff, Model model) {
        
    	if(suchbegriff.equals("")){
    		List<Data> dataRecords = datarepository.findAll();
        	model.addAttribute("suchbegriff", dataRecords);
    	}else{
    		List<Data> dataRecords = datarepository.findBySuchbegriff(suchbegriff);
            model.addAttribute("suchbegriff", dataRecords);
    	}

        return "iknow_get";
    }
    
    @RequestMapping(value = "/iknow/post", method = RequestMethod.GET, produces = "text/html")
    public String displayiKnowPost(@RequestParam(value = "suchbegriff", defaultValue = "") String suchbegriff, Model model) {
        
    	if(suchbegriff.equals("")){
    		List<Data> dataRecords = datarepository.findAll();
        	model.addAttribute("suchbegriff", dataRecords);
    	}else{
    		List<Data> dataRecords = datarepository.findBySuchbegriff(suchbegriff);
            model.addAttribute("suchbegriff", dataRecords);
    	}

        return "iknow_post";
    }
    
}
