package edu.study.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "main/home";
	}
	
	@RequestMapping(value = "/sample01.do", method = RequestMethod.GET)
	public String sample01(Locale locale, Model model) {

		return "main/sample01";
	}
	
	
	@RequestMapping(value = "/sample01.do", method = RequestMethod.POST)
	public String sample01(String t1, String t2) {
		/*
		int num = 0;
		
		if (t2!=null && !t2.contentEquals(""))
		{
			In
		}
		*/
		
		System.out.println("t1::"+t1);
		System.out.println("t2::"+t2);

		return "redirect:/";
	}
	
}