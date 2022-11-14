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
import edu.study.vo.BoardVO;

/**
 * Handles requests for the application home page.
 */

@RequestMapping(value="/board")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;


	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String list(Locale locale, Model model) {
		model.addAttribute("data1", "�ȳ��ϼ���");	//request�� set ��û�ϴ� �Ͱ� ����
		
		
		//db���� boardtb ������ ��� ��������
		List<BoardVO> list = boardService.list();
		
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping(value = "/view.do", method = RequestMethod.GET)
	public String view(Locale locale, int bidx, Model model) {

		BoardVO vo = boardService.view(bidx);
		
		model.addAttribute("vo", vo);
		
		
		return "board/view";
	}
	
	@RequestMapping(value="/modify.do", method = RequestMethod.GET)
	public String modify(Locale locale, int bidx, Model model)
	{
		BoardVO vo = boardService.view(bidx);
		
		model.addAttribute("vo", vo);
		
		return "board/modify";
	}
	
	
}
