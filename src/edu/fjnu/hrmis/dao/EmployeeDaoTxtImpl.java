/**
 * 
 */
package edu.fjnu.hrmis.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import edu.fjnu.hrmis.domain.Employee;
/**
 * @author zzp
 *
 */
/**
 * @author Administrator
 * 
 */
public class EmployeeDaoTxtImpl implements EmployeeDao {

	public static final String DATA_FILE = "E:/eclipse/112+郑震培+HrMIS/docs/records.TXT";
	private List<Employee> list = new ArrayList<Employee>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.fjnu.hrmis.dao.EmployeeDao#saveEmp(edu.fjnu.hrmis.domain.Employee)
	 */
	@Override
	public void saveEmp(Employee emp) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileOutputStream(DATA_FILE, true));
			writer.println(emp);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			writer.flush();
			writer.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.fjnu.hrmis.dao.EmployeeDao#listEmps()
	 */
	@Override
	public List<Employee> listEmps() {
		// TODO Auto-generated method stub
		BufferedReader buffer = null;
		try {
			buffer = new BufferedReader(new InputStreamReader(
					new FileInputStream(DATA_FILE)));

			
			
			do {
				String[] array = new String[] {};
				String text = buffer.readLine();
				// 以：分割开来获取每一个数据
				array = text.split(":");
				// 将String类型的转换成正规化后的时间类型
				SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
				/**
				 * 添加数据到集合
				 */
				list.add(new Employee(array[0], array[1], array[2], array[3],
						array[4], Integer.parseInt(array[5]), array[6], format
								.parse(array[7])));
			} while (buffer.ready());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception ex) {

		}

		return list;
	}

	/**
	 * 实现接口排序输出方法
	 */
	@Override
	public Set<Employee> listSortedEmps() {
		TreeSet<Employee> tree = new TreeSet<Employee>();
		tree.addAll(this.listEmps());
		return tree;
	}

	/**
	 * 实现接口删除数据的方法，用于删除
	 */
	@Override
	public void deleteEmp(int count) {
		PrintWriter writer = null;
		StringBuilder str = new StringBuilder();
		try {
			//如果传进对象到新集合里面是无法找到的，而索引可以
			List<Employee> list2 = new ArrayList<Employee>();
			list2.addAll(this.listEmps());
			// 打印出要删除的对象的内容
			System.out.println("已经删除的内容是：" + list2.get(count));
			list2.remove(count);

			// 如果集合里不含这个对象就表示删除成功
			if (!list2.contains(count)) {
				System.out.println("删除成功");
			}
			for (Employee employee : list2) {
				str.append(employee.toString() + "\r\n");
			}
			System.out.println(str);

			// 这个new的对象必须在append后面因为append是追加的意思而(new
			// FileOutputStream(DATA_FILE)没有true表示的不追加相矛盾会抛出异常
			writer = new PrintWriter(new FileOutputStream(DATA_FILE));
			writer.print(str);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			writer.flush();
			writer.close();
		}

	}
	/**
	 * 实现接口删除数据的方法2用于修改的时候删除以前的
	 */
	@Override
	public void deleteEmp2(int count) {
		PrintWriter writer = null;
		StringBuilder str = new StringBuilder();
		try {
			//如果传进对象到新集合里面是无法找到的，而索引可以
			List<Employee> list2 = new ArrayList<Employee>();
			list2.addAll(this.listEmps());
			list2.remove(count);

			for (Employee employee : list2) {
				str.append(employee.toString() + "\r\n");
			}

			// 这个new的对象必须在append后面因为append是追加的意思而(new
			// FileOutputStream(DATA_FILE)没有true表示的不追加相矛盾会抛出异常
			writer = new PrintWriter(new FileOutputStream(DATA_FILE));
			writer.print(str);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			writer.flush();
			writer.close();
		}

	}

}
