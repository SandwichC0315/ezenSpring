package edu.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.study.dao.BoardDAO;
import edu.study.vo.BoardVO;

//@Service - 구현하고 있는 인터페이스에 대한 구현 객체를 만드는 어노테이션
@Service
public class BoardServiceImpl implements BoardService{
	
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<BoardVO> list() {

		return boardDAO.list();
		
	}

	@Override
	public BoardVO view(int bidx) {
		// TODO Auto-generated method stub
		return boardDAO.selectOne(bidx);
	}

	@Override
	public int update(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.update(vo);
	}

	@Override
	public int delete(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.delete(vo);
	}

	
}
