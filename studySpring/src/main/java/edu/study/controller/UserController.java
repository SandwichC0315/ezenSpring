package edu.study.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	@Autowired //의존을 자동으로 주입받겠다는 뜻
	private UserService userService;


	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String list(Locale locale, Model model)
	{
		
		//db에서 usertb 데이터 목록 가져오기
		List<UserVO> list = userService.list();
		
		model.addAttribute("list", list);
		
		return "user/list";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		
		//로그인 처리
		UserVO loginVO = userService.findUserByIdPass(vo);
		
		if(loginVO != null)
		{
			session.setAttribute("login", loginVO);
		}
		
		return "redirect:/board/list.do";
	}
	
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		
		//로그아웃 처리
		session.invalidate(); //세션 초기화
		return "redirect:/";		
	}
	
	@RequestMapping(value="/join.do", method = RequestMethod.GET)
	public String join()
	{
		return "user/join";
	}
	
	@RequestMapping (value="/join.do", method = RequestMethod.POST)
	public String join(UserVO vo)
	{
		int result = userService.joinNewUser(vo);

		return "redirect:/";
	}
}
