package edu.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.study.dao.UserDAO;
import edu.study.vo.UserVO;

@Service //�����ϰ� �ִ� �������̽��� ���� ���� ��ü ����
public class UserServiceImpl implements UserService{

	
	@Autowired 
	private UserDAO userDAO;
	
	
	@Override
	public List<UserVO> list() {
		
		return userDAO.list();
	}


	@Override
	public UserVO findUserByIdPass(UserVO vo) {
		// TODO Auto-generated method stub
		return userDAO.findUserByIdPass(vo);
	}

	
}
