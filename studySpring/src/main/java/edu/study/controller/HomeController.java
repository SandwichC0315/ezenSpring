package edu.study.controller;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

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
		
		
		System.out.println("t1::"+t1);
		System.out.println("t2::"+t2);

		return "redirect:/";
	}
	
	
	@RequestMapping(value = "fileupload.do", method = RequestMethod.GET)
	public String file()
	{
		return "file/upload";
	}
	
	@RequestMapping(value = "fileupload.do", method = RequestMethod.POST)
	public String file(MultipartFile file1, HttpServletRequest req) throws Exception
	{
		//String path = "D:\\KDH(230113)\\ezenSpring\\studySpring\\src\\main\\webapp\\resources\\upload";
		String path = req.getSession().getServletContext().getRealPath("/resources/upload");
		
		System.out.println(path);
		
		File dir = new File(path);
		if (!dir.exists())
		{
			dir.mkdirs();
		}
		
		if(!file1.getOriginalFilename().isEmpty())
		{
			file1.transferTo(new File(path, file1.getOriginalFilename()));
		}
		
		
		return "redirect:/";
	}
	
}