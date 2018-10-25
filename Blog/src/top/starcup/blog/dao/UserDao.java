package top.starcup.blog.dao;
import java.util.List;
import top.starcup.blog.domain.User;
public interface UserDao {
	//����û�
		public void add(User user);
		//ɾ���û�
		public void delete(User user);
		//�����û�
		public void update(User user);
		//��ѯ�����û�
		public List<User> queryAll();
		//��id��ѯ�û�
		public User queryByID(String username);
		//��¼
		public User login(String username, String password);
}
