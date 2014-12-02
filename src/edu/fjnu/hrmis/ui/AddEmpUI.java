/**
 * 
 */
package edu.fjnu.hrmis.ui;
/**
 * @author zzp
 *实现增加员工功能
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import edu.fjnu.hrmis.dao.EmployeeDao;
import edu.fjnu.hrmis.dao.EmployeeDaoTxtImpl;
import edu.fjnu.hrmis.domain.Employee;
import edu.fjnu.hrmis.exception.InvalidEmployeeInfoException;
import edu.fjnu.hrmis.utils.CheckEmp;
import edu.fjnu.hrmis.utils.EmpMISUtils;

public class AddEmpUI implements BaseUI {

	@Override
	public void run() {
		Employee emp = new Employee();
		String choice = null;
		boolean flag = true;
		do {
			EmployeeMenu(emp);
			System.out.println("Add another employee record? (y)es or (n)o, y");
			choice = EmpMISUtils.getEntry();
			if (choice.equals("y") || choice.equals("Y")) {
				flag = true;
			} else {
				flag = false;
			}
		} while (flag);
		EmployeeDao empDao = new EmployeeDaoTxtImpl();
		empDao.saveEmp(emp);

	}
	// -------------------------------------------------------------------
	/**
	 	主菜单
	 */
	private void EmployeeMenu(Employee emp) {
		/* 雇员编号录入 */
		EmployeeWrite("Enter employee 3 digit payroll number:", emp);
		/* 雇员电话录入 */
		EmployeeWrite("Enter Phone Number (02-12345678):", emp);
		/* 雇员姓名录入 */
		EmployeeWrite("Enter Last Name:", emp);
		EmployeeWrite("Enter First Name:", emp);
		EmployeeWrite("Enter Middle Init:", emp);
		/* 雇员公寓录入 */
		EmployeeWrite("Enter Dept #:", emp);
		/* 雇员职位录入 */
		EmployeeWrite("Enter Job Title:", emp);
		/* 雇用时间录入 */
		EmployeeWrite("Enter Date Hired (dd-mm-yyyy):", emp);
	}

	// --------------------------------------------------------------------------------------------------
	/**
	 * 数据的写入
	 */
	private void EmployeeWrite(String text, Employee emp) {
		boolean isContinued = true;
		while (isContinued) {
			// 输入提示
			System.out.print(text);
			String EmployeeImforType = EmpMISUtils.getEntry();
			CheckEmp f = new CheckEmp();
			try {
				if (text.equals("Enter employee 3 digit payroll number:")) {
					f.checkEmpNo(EmployeeImforType);// 检查
					emp.setEmpNo(EmployeeImforType);// 传值到employee类
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

	// -------------------------------------------------------------------------------------------------

}
