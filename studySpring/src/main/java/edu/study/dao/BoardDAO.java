package edu.study.dao;

import java.util.List;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.study.vo.BoardVO;


//IOC 컨테이너에 BoardDAO를 객체로 생성
@Repository //시스템 외부로 연결해서 데이터 요청, 응답 관리 역할을 하는 객체 어노테이션
public class BoardDAO {
	
	@Autowired //타입을 기반으로 의존 주입
	private SqlSession sqlSession;

	public List<BoardVO> list()
	{
		//mybatis를 사용하여 boardtb 데이터 목록 조회하여 반환
		return sqlSession.selectList("edu.study.mapper.boardMapper.selectList");
	}
	
	public BoardVO selectOne(int bidx)
	{
		
		return sqlSession.selectOne("edu.study.mapper.boardMapper.selectOne", bidx);
	}
	
	
	public int update(BoardVO vo)
	{
		return sqlSession.update("edu.study.mapper.boardMapper.update", vo);
	}
	
	public int delete(BoardVO vo)
	{
		return sqlSession.delete("edu.study.mapper.boardMapper.delete", vo);
	}
}
