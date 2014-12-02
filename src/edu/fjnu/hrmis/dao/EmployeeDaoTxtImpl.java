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

	public static final String DATA_FILE = "E:/eclipse/112+֣����+HrMIS/docs/records.TXT";
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
				// �ԣ��ָ����ȡÿһ������
				array = text.split(":");
				// ��String���͵�ת�������滯���ʱ������
				SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
				/**
				 * ������ݵ�����
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
	 * ʵ�ֽӿ������������
	 */
	@Override
	public Set<Employee> listSortedEmps() {
		TreeSet<Employee> tree = new TreeSet<Employee>();
		tree.addAll(this.listEmps());
		return tree;
	}

	/**
	 * ʵ�ֽӿ�ɾ�����ݵķ���������ɾ��
	 */
	@Override
	public void deleteEmp(int count) {
		PrintWriter writer = null;
		StringBuilder str = new StringBuilder();
		try {
			//������������¼����������޷��ҵ��ģ�����������
			List<Employee> list2 = new ArrayList<Employee>();
			list2.addAll(this.listEmps());
			// ��ӡ��Ҫɾ���Ķ��������
			System.out.println("�Ѿ�ɾ���������ǣ�" + list2.get(count));
			list2.remove(count);

			// ��������ﲻ���������ͱ�ʾɾ���ɹ�
			if (!list2.contains(count)) {
				System.out.println("ɾ���ɹ�");
			}
			for (Employee employee : list2) {
				str.append(employee.toString() + "\r\n");
			}
			System.out.println(str);

			// ���new�Ķ��������append������Ϊappend��׷�ӵ���˼��(new
			// FileOutputStream(DATA_FILE)û��true��ʾ�Ĳ�׷����ì�ܻ��׳��쳣
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
	 * ʵ�ֽӿ�ɾ�����ݵķ���2�����޸ĵ�ʱ��ɾ����ǰ��
	 */
	@Override
	public void deleteEmp2(int count) {
		PrintWriter writer = null;
		StringBuilder str = new StringBuilder();
		try {
			//������������¼����������޷��ҵ��ģ�����������
			List<Employee> list2 = new ArrayList<Employee>();
			list2.addAll(this.listEmps());
			list2.remove(count);

			for (Employee employee : list2) {
				str.append(employee.toString() + "\r\n");
			}

			// ���new�Ķ��������append������Ϊappend��׷�ӵ���˼��(new
			// FileOutputStream(DATA_FILE)û��true��ʾ�Ĳ�׷����ì�ܻ��׳��쳣
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
