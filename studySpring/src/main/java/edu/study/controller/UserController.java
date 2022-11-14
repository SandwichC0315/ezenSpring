package edu.study.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.study.service.BoardService;
import edu.study.service.UserService;
import edu.study.vo.BoardVO;
import edu.study.vo.UserVO;

/**
 * Handles requests for the application home page.
 */

@RequestMapping(value="/user")
@Controller
public class UserController {
	
	@Autowired //
	private UserService userService;


	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String list(Locale locale, Model model)
	{
		
		//db에서 usertb 데이터 목록 가져오기
		List<UserVO> list = userService.list();
		
		model.addAttribute("list", list);
		
		return "user/list";
	}

}
