package com.redis.app;

import java.text.DateFormat; 
import java.util.Date;
import java.util.Locale;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.redis.service.SpringRedisExample;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@GetMapping(value = "/")
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		SpringRedisExample ex = new SpringRedisExample();
		ex.exam();
		
		return "home";
	}
	
	
	@GetMapping(value = "/{name}/{age}")
	public String home2(@PathVariable String name, @PathVariable String age) {
		
		SpringRedisExample ex = new SpringRedisExample();
		ex.string("people", name, age);
		
		return "home";
	}
	@GetMapping(value = "/{name}/{value}/{value2}")
	public String home3(@PathVariable String name, @PathVariable String value, @PathVariable String value2) {
		
		SpringRedisExample ex = new SpringRedisExample();
		ex.list(name, value);
		ex.sort(name, value2);
		return "home";
	}
	@GetMapping(value = "/delete/list/{number}")
	public String home4(@PathVariable String number) {
		
		if(number.equals("1")) {
			
		}
		else if(number.equals("2")) {
			
		}
		return "home";
	}
	
}
