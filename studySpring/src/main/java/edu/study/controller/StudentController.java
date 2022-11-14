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

import edu.study.vo.Student1;
import edu.study.vo.Student2;
import edu.study.vo.Student3;

/**
 * Handles requests for the application home page.
 */
@RequestMapping(value="/student")
@Controller
public class StudentController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insert(Locale locale, Model model)
	{
			
		return "student/insert";
	}
	
	/*
	
	@RequestMapping(value = "/result.do", method = RequestMethod.POST)
	public String result(String s1math, String s2math, String s3math, String s1kor, String s2kor, String s3kor, String s1english, String s2english, String s3english, Model model)
	{
		double s11math = 0, s22math = 0, s33math = 0, s11kor = 0, s22kor = 0, s33kor = 0, s11english = 0, s22english = 0, s33english = 0;
		
		if (s1math != null && !s1math.equals(""))
		{
			s11math = Double.parseDouble(s1math);
		}  
		
		if (s2math != null && !s2math.equals(""))
		{
			s22math = Double.parseDouble(s2math);
		}
		
		if (s3math != null && !s3math.equals(""))
		{
			s33math = Double.parseDouble(s3math);
		}
		
		if (s1kor != null && !s1kor.equals(""))
		{
			s11kor = Double.parseDouble(s1kor);
		}
		
		if (s2kor != null && !s2kor.equals(""))
		{
			s22kor = Double.parseDouble(s2kor);
		}
		
		if (s3kor != null && !s3kor.equals(""))
		{
			s33kor = Double.parseDouble(s3kor);
		}
		
		if (s1english != null && !s1english.equals(""))
		{
			s11english = Double.parseDouble(s1english);
		}
		
		if (s2english != null && !s2english.equals(""))
		{
			s22english = Double.parseDouble(s2english);
		}
		
		if (s3english != null && !s3english.equals(""))
		{
			s33english = Double.parseDouble(s3english);
		}
		
		double s1aver = (s11math + s11kor + s11english)/3;
		double s2aver = (s22math + s22kor + s22english)/3;
		double s3aver = (s33math + s33kor + s33english)/3;
		
		double mathaver = (s11math + s22math + s33math)/3;
		double korever = (s11kor + s22kor + s33kor)/3;
		double engaver = (s11english + s22english + s33english)/3;
		
		model.addAttribute("s1aver", s1aver);
		model.addAttribute("s2aver", s2aver);
		model.addAttribute("s3aver", s3aver);
		model.addAttribute("mathaver", mathaver);
		model.addAttribute("korever", korever);
		model.addAttribute("engaver", engaver);

		return "student/result";
	}
	*/
	
	
	@RequestMapping(value = "/result.do", method = RequestMethod.POST)
	public String insert(Model model, Student1 s1, Student2 s2, Student3 s3)
	{
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		System.out.println(s3.toString());
		
		double r1 = 0.0;
		double r2 = 0.0;
		double r3 = 0.0;
		double r4 = 0.0;
		double r5 = 0.0;
		double r6 = 0.0;
		
		r1 = (s1.getS1math()+s1.getS1english()+s1.getS1kor())/3;
		r2 = (s2.getS2math()+s2.getS2english()+s2.getS2kor())/3;
		r4 = (s1.getS1math()+s2.getS2math()+s3.getS3math())/3;
		r5 = (s1.getS1english()+s2.getS2english()+s3.getS3english())/3;
		r6 = (s1.getS1kor()+s2.getS2kor()+s3.getS3kor())/3;
		
		model.addAttribute("r1", r1);
		model.addAttribute("r2", r2);
		model.addAttribute("r3", r3);
		model.addAttribute("r4", r4);
		model.addAttribute("r5", r5);
		
		
		return "student/result";
	}
}
