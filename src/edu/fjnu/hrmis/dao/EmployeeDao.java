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
 * DAO: Data Access Object  ��һ�ֳ��������ģʽ
 * һ��DAO����һ������ĳ־û��������������е�CRUD��Ϊ
 */
public interface EmployeeDao {
	
	void saveEmp(Employee emp);
	void deleteEmp(int count);
	List<Employee> listEmps();
	Set<Employee> listSortedEmps();
	void deleteEmp2(int count);

}
