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
	
	@Autowired //������ �ڵ����� ���Թްڴٴ� ��
	private UserService userService;


	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String list(Locale locale, Model model)
	{
		
		//db���� usertb ������ ��� ��������
		List<UserVO> list = userService.list();
		
		model.addAttribute("list", list);
		
		return "user/list";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		
		//�α��� ó��
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
		
		//�α׾ƿ� ó��
		session.invalidate(); //���� �ʱ�ȭ
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
