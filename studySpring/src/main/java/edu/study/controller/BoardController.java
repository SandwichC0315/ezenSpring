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
		model.addAttribute("data1", "안녕하세요"); // request에 set 요청하는 것과 같음

		// db에서 boardtb 데이터 목록 가져오기
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
	 * String modify(BoardVO vo) { //db 수정처리
	 * 
	 * int result = boardService.update(vo);
	 * 
	 * return "redirect:view.do?bidx="+vo.getBidx(); }
	 */

	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public void modify(BoardVO vo, HttpServletResponse res) throws Exception {
		// db 수정처리

		int result = boardService.update(vo);
		
		res.setContentType("text/html; charset=UTF-8");

		PrintWriter pw = res.getWriter();
		if (result > 0) {
			// 수정 성공

			pw.append("<script>alert('수정 성공');location.href='view.do?bidx=" + vo.getBidx() + "'</script>");

			pw.flush();
			pw.close();
		} else {
			// 수정 실패

			pw.append("<script>alert('수정 실패');location.href='view.do?bidx=" + vo.getBidx() + "'</script>");

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
			// 수정 성공

			pw.append("<script>alert('삭제하였습니다.');location.href='list.do'</script>");

			pw.flush();
			pw.close();
		} else {
			// 수정 실패

			pw.append("<script>alert('삭제 요청 처리중 문제가 발생하였습니다.');location.href='list.do'</script>");

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
