package edu.study.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.study.vo.UserVO;

//IOC 컨테이너에 UserDAO를 객체로 생성
@Repository //시스템 외부로 연결해서 데이터 요청, 응답 관리 역할을 하는 객체 어노테이션
public class UserDAO {
	
	@Autowired 
	private SqlSession sqlSession;
	
	public List<UserVO> list()
	{
		//mybatis를 사용하여 usertb 데이터 목록 조회하여 List 타입으로 반환
		return sqlSession.selectList("edu.study.mapper.userMapper.selectList");
	}
	
	public UserVO findUserByIdPass(UserVO vo)
	{
		return sqlSession.selectOne("edu.study.mapper.userMapper.findUserByIdPass", vo);
	}
	
	public int joinNewUser(UserVO vo)
	{
		return sqlSession.insert("edu.study.mapper.userMapper.joinNewUser", vo);
	}
}
