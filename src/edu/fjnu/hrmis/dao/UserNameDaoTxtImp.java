package edu.fjnu.hrmis.dao;
/**
 * @author zzp
 *
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.activity.InvalidActivityException;

import edu.fjnu.hrmis.domain.Employee;
import edu.fjnu.hrmis.domain.User;
import edu.fjnu.hrmis.exception.InvalidEmployeeInfoException;

public class UserNameDaoTxtImp implements UserNameDao{
	public static final String DATA_FILE = "E:/eclipse/112+郑震培+HrMIS/docs/user.TXT";
	private List<User> list = new ArrayList<User>();
	@Override
	public void search_password() {
		// TODO Auto-generated method stub
		
	}


	/**
	 * 添加数据到集合
	 */

	@SuppressWarnings("resource")
	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		BufferedReader buffer = null;
		try {
			File file=new File(DATA_FILE);
			buffer = new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));
			if(!file.exists()){
				throw new InvalidEmployeeInfoException("File not found!!");
			}

			do {
				String[] array = new String[] {};
				String text = buffer.readLine();
				// 以：分割开来获取每一个数据
				array = text.split(":");
				/**
				 * 添加数据到集合
				 */
				list.add(new User(array[0], array[1]));
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
		} catch (Exception ex) {

		}

		return list;
	}

	/**
	 * 添加数据treeset集合
	 */
	@Override
	public Set<User> TreeUsers() {
		TreeSet<User> tree = new TreeSet<User>();
		tree.addAll(this.listUser());
		return tree;
	}


	@Override
	public void saveUser(User user) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileOutputStream(DATA_FILE, true));
			writer.println(user);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			writer.flush();
			writer.close();
		}
		
	}




}
