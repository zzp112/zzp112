package edu.fjnu.hrmis.dao;

import java.util.List;
import java.util.Set;

import edu.fjnu.hrmis.domain.*;
/**
 * @author zzp
 *
 */
/**
 * @author Administrator
 * DAO: Data Access Object  ��һ�ֳ��������ģʽ
 * һ��DAO����һ������ĳ־û��������������е�CRUD��Ϊ
 */
public interface UserNameDao {
	
	void saveUser(User user);
	List<User> listUser();
	void search_password();
	Set<User> TreeUsers();

}