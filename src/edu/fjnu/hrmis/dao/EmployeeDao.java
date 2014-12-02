/**
 * 
 */
package edu.fjnu.hrmis.dao;

import java.util.List;
import java.util.Set;

import edu.fjnu.hrmis.domain.Employee;
/**
 * @author zzp
 *
 */
/**
 * @author Administrator
 * DAO: Data Access Object  是一种常见的设计模式
 * 一个DAO负责一个对象的持久化操作，管理所有的CRUD行为
 */
public interface EmployeeDao {
	
	void saveEmp(Employee emp);
	void deleteEmp(int count);
	List<Employee> listEmps();
	Set<Employee> listSortedEmps();
	void deleteEmp2(int count);

}
