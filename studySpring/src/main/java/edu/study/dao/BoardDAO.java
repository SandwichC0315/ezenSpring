package edu.study.dao;

import java.util.List;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.study.vo.BoardVO;


//IOC �����̳ʿ� BoardDAO�� ��ü�� ����
@Repository //�ý��� �ܺη� �����ؼ� ������ ��û, ���� ���� ������ �ϴ� ��ü ������̼�
public class BoardDAO {
	
	@Autowired //Ÿ���� ������� ���� ����
	private SqlSession sqlSession;

	public List<BoardVO> list()
	{
		//mybatis�� ����Ͽ� boardtb ������ ��� ��ȸ�Ͽ� ��ȯ
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
