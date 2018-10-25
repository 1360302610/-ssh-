package top.starcup.blog.service.impl;

import top.starcup.blog.dao.UserDao;
import top.starcup.blog.domain.User;
import top.starcup.blog.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	public void setUserDao(UserDao userDao){
		this.userDao=userDao;
	}
	public boolean registerUser(User user) {
		//用户注册
		User u = userDao.queryByID(user.getUsername());
		if(u==null){
			userDao.add(user);
			return true;
		}
		return false;
	}
	public User login(String username, String password) {
		return userDao.login(username,password);
	}

}
