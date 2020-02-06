package com.booking.com.domain.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PagesController {
	
    @RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginPage(Model model)
	{
    	
     return "login";
	}
    
  
    
    
    
}
