package top.starcup.blog.service;

import top.starcup.blog.domain.User;

public interface UserService {

	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	public boolean registerUser(User user);

	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username, String password);
}
