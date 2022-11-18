package edu.study.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.study.vo.UserVO;

//IOC �����̳ʿ� UserDAO�� ��ü�� ����
@Repository //�ý��� �ܺη� �����ؼ� ������ ��û, ���� ���� ������ �ϴ� ��ü ������̼�
public class UserDAO {
	
	@Autowired 
	private SqlSession sqlSession;
	
	public List<UserVO> list()
	{
		//mybatis�� ����Ͽ� usertb ������ ��� ��ȸ�Ͽ� List Ÿ������ ��ȯ
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
