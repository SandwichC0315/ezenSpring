package edu.study.service;

import java.util.List;

import edu.study.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> list();
	
	BoardVO view(int bidx);
}
