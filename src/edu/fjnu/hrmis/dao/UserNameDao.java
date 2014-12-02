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
 * DAO: Data Access Object  是一种常见的设计模式
 * 一个DAO负责一个对象的持久化操作，管理所有的CRUD行为
 */
public interface UserNameDao {
	
	void saveUser(User user);
	List<User> listUser();
	void search_password();
	Set<User> TreeUsers();

}