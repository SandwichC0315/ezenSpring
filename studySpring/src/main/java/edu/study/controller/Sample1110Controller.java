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
@RequestMapping(value="/sample1110")
@Controller
public class Sample1110Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/paramex.do", method = RequestMethod.GET)
	public String param01(Locale locale, Model model)
	{
			
		return "sample1110/param01";
	}
	
	
	@RequestMapping(value = "/result.do", method = RequestMethod.POST)
	public String result(String num1, String num2, String oper, Model model)
	{
		double num11 = 0;
		double num22 = 0;
		
		
		if (num1 != null && !num1.equals(""))
		{
			num11 = Double.parseDouble(num1);
		}
		
		if (num2 != null && !num2.equals(""))
		{
			num22 = Double.parseDouble(num2);
		}
		
		double result = 0.0;	
		
		if (oper.equals("plus"))
		{
			result = num11+num22;
		}
		else if (oper.equals("minus"))
		{
			result = num11-num22;
			
		
		}
		else if (oper.equals("multi"))
		{
			result = num11*num22;
	
		}
		else if (oper.equals("divide"))
		{
			result = num11/num22;
		}
		
		model.addAttribute("result", result);
		
		return "sample1110/result";
	}
		
}
