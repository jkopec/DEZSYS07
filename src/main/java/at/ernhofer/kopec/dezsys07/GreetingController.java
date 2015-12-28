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
        return "redirect:iknow";
    }

    @RequestMapping(value = {"/iknow","/iknow/get"}, method = RequestMethod.GET, produces = "text/html")
    public String displayiKnowGet(@RequestParam(value = "suchbegriff", defaultValue = "") String suchbegriff, Model model) {
    	
    	model.addAttribute("request",suchbegriff);
        
    	if(suchbegriff.equals("")){
    		List<Data> dataRecords = datarepository.findAll();
        	model.addAttribute("suchbegriff", dataRecords);
    	}else{
    		List<Data> dataRecords = datarepository.findBySuchbegriffContainingIgnoreCase(suchbegriff);
            model.addAttribute("suchbegriff", dataRecords);
    	}

        return "iknow";
    }
    
    @RequestMapping(value = "/iknow/edit", method = RequestMethod.GET, produces = "text/html")
    public String displayiKnowPut(@RequestParam(value = "id", defaultValue = "") String id, Model model) {
        
    	if(!id.equals("")){
    		Data dataRecord = datarepository.findById(id);
        	model.addAttribute("data", dataRecord);
    	}
    	
        return "edit";
    }
    
    @RequestMapping(value="/error",method = RequestMethod.GET,produces = "text/html")
    public String error(){
    	return "404";
    }
    
    
}
