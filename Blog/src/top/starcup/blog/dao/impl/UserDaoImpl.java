package top.starcup.blog.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import top.starcup.blog.dao.UserDao;
import top.starcup.blog.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {


	public void add(User user) {
		getHibernateTemplate().save(user);

	}

	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	public void update(User user) {
		// TODO Auto-generated method stub

	}

	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public User queryByID(String username) {
		List lists = getHibernateTemplate().find("from User user where user.username='"+username+"'");
		if(lists!=null && lists.size()!=0){
			return (User)lists.get(0);
		}else{
			return null;
		}
	}

	public User login(String username, String password) {
		List lists= getHibernateTemplate().find("from User user where user.username=? and user.password=?", username,password);
		if(lists!=null && lists.size()!=0){
			return (User)lists.get(0);
		}
		return null;
	}

}
