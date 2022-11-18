package edu.study.controller;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.study.service.BoardService;
import edu.study.vo.BoardVO;
import edu.study.vo.UserVO;

/**
 * Handles requests for the application home page.
 */

@RequestMapping(value = "/board")
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String list(Locale locale, Model model) {
		model.addAttribute("data1", "�ȳ��ϼ���"); // request�� set ��û�ϴ� �Ͱ� ����

		// db���� boardtb ������ ��� ��������
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

	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String modify(Locale locale, int bidx, Model model) {
		BoardVO vo = boardService.view(bidx);

		model.addAttribute("vo", vo);

		return "board/modify";
	}

	/*
	 * @RequestMapping(value="/modify.do", method = RequestMethod.POST) public
	 * String modify(BoardVO vo) { //db ����ó��
	 * 
	 * int result = boardService.update(vo);
	 * 
	 * return "redirect:view.do?bidx="+vo.getBidx(); }
	 */

	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public void modify(BoardVO vo, HttpServletResponse res) throws Exception {
		// db ����ó��

		int result = boardService.update(vo);
		
		res.setContentType("text/html; charset=UTF-8");

		PrintWriter pw = res.getWriter();
		if (result > 0) {
			// ���� ����

			pw.append("<script>alert('���� ����');location.href='view.do?bidx=" + vo.getBidx() + "'</script>");

			pw.flush();
			pw.close();
		} else {
			// ���� ����

			pw.append("<script>alert('���� ����');location.href='view.do?bidx=" + vo.getBidx() + "'</script>");

			pw.flush();
			pw.close();
		}
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public void delete(BoardVO vo, HttpServletResponse res) throws Exception
	{
		int result = boardService.delete(vo);
		
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter pw = res.getWriter();
		if (result > 0) {
			// ���� ����

			pw.append("<script>alert('�����Ͽ����ϴ�.');location.href='list.do'</script>");

			pw.flush();
			pw.close();
		} else {
			// ���� ����

			pw.append("<script>alert('���� ��û ó���� ������ �߻��Ͽ����ϴ�.');location.href='list.do'</script>");

			pw.flush();
			pw.close();
		}
	}
	
	@RequestMapping(value="/insert.do", method= RequestMethod.GET)
	public String insert(BoardVO vo)
	{
		return "board/insert";
	}
	
	
	@RequestMapping(value="/insert.do", method= RequestMethod.POST)
	public String insert(BoardVO vo, HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		
		UserVO login = (UserVO)session.getAttribute("login");
		
		vo.setUidx(login.getUidx());
		
		int result = boardService.insert(vo);
		
		return "redirect:view.do?bidx="+vo.getBidx();
	}

}
