package edu.fjnu.hrmis.ui;
/**
 * @author zzp
 *修改员工信息
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;

import edu.fjnu.hrmis.dao.EmployeeDao;
import edu.fjnu.hrmis.dao.EmployeeDaoTxtImpl;
import edu.fjnu.hrmis.domain.Employee;
import edu.fjnu.hrmis.exception.InvalidEmployeeInfoException;
import edu.fjnu.hrmis.utils.CheckEmp;
import edu.fjnu.hrmis.utils.DeleteEmpCheck;
import edu.fjnu.hrmis.utils.EmpMISUtils;

public class AlterEmpUI implements BaseUI {

	private static String EmployeeImforType = null;
	@Override
	public void run() {
		
		Employee emp = new Employee();
		EmployeeMenu(emp);
		EmployeeDao empDao = new EmployeeDaoTxtImpl();
		empDao.saveEmp(emp);
	}
	/**
	 * 雇佣者主菜单 
	 */
	private void EmployeeMenu(Employee emp) {
		/*雇员编号录入 查询到的号*/
		EmployeeWrite("Enter three number to alter:", emp);
		/* 雇员电话录入*/
		EmployeeWrite("Enter Phone Number (02-12345678):", emp);
		/*雇员姓名录入*/
		EmployeeWrite("Enter Last Name:", emp);
		EmployeeWrite("Enter First Name:", emp);
		EmployeeWrite("Enter Middle Init:", emp);
		/* 雇员公寓录入*/
		EmployeeWrite("Enter Dept #:", emp);
		/*雇员职位录入*/
		EmployeeWrite("Enter Job Title:", emp);
		/*雇用时间录入*/
		EmployeeWrite("Enter Date Hired (dd-mm-yyyy):", emp);
	}
	private int SearchAterEmp() {
		boolean flag = true;
		boolean flag2 = true;
		int count = -1;// 索引
		do {
			try {
				EmployeeDao emp = new EmployeeDaoTxtImpl();
		
				for (Employee employee : emp.listEmps()) {
					// 检查不规范输入的异常
					DeleteEmpCheck.getInstance().check(EmployeeImforType);
					count++;
					if (EmployeeImforType.toUpperCase().equals(employee.getEmpNo().toUpperCase())) {
						return count;// 返回要删除的索引============================
					}
					else {
						flag = true;// 没有找到要求用户继续输入
						flag2 = true;// 没有找到关键字向外面发出信号表示抛出异常
					}
				}
				if (flag2 == true) {
					throw new InvalidEmployeeInfoException("Keyword – " + EmployeeImforType
							+ "- not found\n");
				}
			} catch (InvalidEmployeeInfoException e) {
				System.out.println(e.getMessage());
				EmpMISUtils.pause("Press Enter to continue... ");
			} catch (Exception ex) {
				System.out.println("发生异常。。。");
			}
		} while (flag == true);
		return -1;
	}

	/**
	 数据的写入
	 */
	private void EmployeeWrite(String text, Employee emp) {
		boolean isContinued = true;
		while (isContinued) {
			// 输入提示
			System.out.print(text);
			EmployeeImforType = EmpMISUtils.getEntry();
			CheckEmp f = new CheckEmp();
			try {
				if (text.equals("Enter three number to alter:")) {
					/*删除原来的号*/
					EmployeeDao empDao = new EmployeeDaoTxtImpl();
					// 删除对象SearchDeleteEmp
					empDao.deleteEmp2(SearchAterEmp());
					//设置新的值
					f.checkEmpNo(EmployeeImforType);
					emp.setEmpNo(EmployeeImforType);
				}
				
				if (text.equals("Enter Phone Number (02-12345678):")) {
					f.checkPhoneNum(EmployeeImforType);
					emp.setEmpPhonecode(EmployeeImforType);
				}
				if (text.equals("Enter Last Name:")) {
					f.checkEmpLastname(EmployeeImforType);
					emp.setLastName(EmployeeImforType);
				}
				if (text.equals("Enter First Name:")) {
					f.checkEmpFirstName(EmployeeImforType);
					emp.setFistName(EmployeeImforType);
				}
				if (text.equals("Enter Middle Init:")) {
					f.checkEmpInital(EmployeeImforType);
					emp.setInitial(EmployeeImforType);
				}
				if (text.equals("Enter Dept #:")) {
					f.checkDept(EmployeeImforType);
					emp.setDeptNo(Integer.parseInt(EmployeeImforType));
				}
				if (text.equals("Enter Job Title:")) {
					f.checkTitleJob(EmployeeImforType);
					emp.setJobTitle(EmployeeImforType);
				}
				if (text.equals("Enter Date Hired (dd-mm-yyyy):")) {
					f.checkDateHired(EmployeeImforType);
					// 格式转换成date型
					SimpleDateFormat fro = new SimpleDateFormat("dd-mm-yyyy");
					emp.setHiringDate(fro.parse(EmployeeImforType));
					break;
				}
				isContinued = false;
			} catch (InvalidEmployeeInfoException e) {
				EmpMISUtils.pause(e.getMessage());
				continue;
			} catch (ParseException e) {
				System.out.println("出现异常-----");
				isContinued = false;
			}
		}
	}

}
