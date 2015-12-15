package com.example;

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

    @RequestMapping(value = "/iknow", method = RequestMethod.GET, produces = "text/html")
    public String displayDataRecords(@RequestParam(value = "suchbegriff", defaultValue = "") String suchbegriff, Model model) {
        
    	//List<Person> dataRecords = datarepository.findByLastName(name);
    	List<Data> dataRecords = datarepository.findBySuchbegriff(suchbegriff);
        model.addAttribute("suchbegriff", dataRecords);

        return "datarecords";
    }
}
