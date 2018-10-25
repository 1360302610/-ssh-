package top.starcup.blog.dao;
import java.util.List;
import top.starcup.blog.domain.User;
public interface UserDao {
	//添加用户
		public void add(User user);
		//删除用户
		public void delete(User user);
		//更新用户
		public void update(User user);
		//查询所有用户
		public List<User> queryAll();
		//按id查询用户
		public User queryByID(String username);
		//登录
		public User login(String username, String password);
}
