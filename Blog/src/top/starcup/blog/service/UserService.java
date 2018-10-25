package top.starcup.blog.service;

import top.starcup.blog.domain.User;

public interface UserService {

	/**
	 * ע���û�
	 * @param user
	 * @return
	 */
	public boolean registerUser(User user);

	/**
	 * �û���¼
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username, String password);
}
