package edu.study.service;

import java.util.List;

import edu.study.vo.UserVO;

public interface UserService {

	public List<UserVO> list();
	
	UserVO findUserByIdPass(UserVO vo);
	
	int joinNewUser(UserVO vo);
}
