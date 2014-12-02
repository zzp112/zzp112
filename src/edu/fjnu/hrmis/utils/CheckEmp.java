package edu.fjnu.hrmis.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import edu.fjnu.hrmis.dao.EmployeeDaoTxtImpl;
import edu.fjnu.hrmis.domain.Employee;
import edu.fjnu.hrmis.exception.InvalidEmployeeInfoException;
/**
 * @author zzp
 *
 */
public class CheckEmp {
	/**
	 * 对雇佣者号的规范检查
	 * 
	 * @param empNo
	 */
	public void checkEmpNo(String empNo) {
		EmployeeDaoTxtImpl data=new EmployeeDaoTxtImpl();
		if (EmpMISUtils.isEmpty(empNo)) {
			throw new InvalidEmployeeInfoException(
					"No payroll number entered – try again");
		}
		else if (!empNo.matches("[\\d]{3}")) {
			throw new InvalidEmployeeInfoException(
					"Payroll number can contain only numerical characters");
		}
		for(Employee emp:data.listEmps()){
			/**
			 * 如果用户号已经存在抛出异常
			 */
			if(emp.getEmpNo().toString().equals(empNo)){
				throw new InvalidEmployeeInfoException(
						"this employeeno has exists");
			}
		}
		try {
			Integer.parseInt(empNo.trim());// 移除空白
		} catch (NumberFormatException e) {
			throw new InvalidEmployeeInfoException(
					"Payroll number can contain only numerical characters");
		}
	}

	/**
	 * 对雇佣者的电话号码的检查
	 * 
	 * @param phone
	 */
	public void checkPhoneNum(String phone) {
		if (EmpMISUtils.isEmpty(phone)) {
			throw new InvalidEmployeeInfoException(
					"No phone number entered – try again");
		} else if (!phone.matches("^[0][2-8]-[0-9][0-9]{7}$")) {
			throw new InvalidEmployeeInfoException(
					"Invalid phone number – try again");
		}
		System.out.println("success!!!");
	}

	/**
	 * 对雇佣者姓名的检查
	 * 
	 * @param lastname
	 */
	public void checkEmpLastname(String lastname) {
		if (EmpMISUtils.isEmpty(lastname)) {
			throw new InvalidEmployeeInfoException(
					"No last name entered – try again");
			// \\s识别空格
		} else if (!lastname.matches("^[A-Z][a-z\\s]+$")) {
			throw new InvalidEmployeeInfoException(
					"Last name can contain only alphabetical characters and spaces ");
		}
		System.out.println("success!!!");
	}

	/**
	 * 对雇佣者姓名的检查
	 * 
	 * @param firstname
	 */
	public void checkEmpFirstName(String firstname) {
		if (EmpMISUtils.isEmpty(firstname)) {
			throw new InvalidEmployeeInfoException(
					"No first name entered – try again");
		} else if (!firstname.matches("^[A-Z][a-z\\s]+$")) {
			throw new InvalidEmployeeInfoException(
					"first name can contain only alphabetical characters and spaces ");
		}
		System.out.println("success!!!");
	}

	/**
	 * 对雇佣者职位的检查
	 * 
	 * @param inital
	 */
	public void checkEmpInital(String inital) {
		if (EmpMISUtils.isEmpty(inital)) {
			throw new InvalidEmployeeInfoException(
					"No Middle Init entered – try again");
		} else if (!inital.matches("[A-Z][a-z]*")) {
			throw new InvalidEmployeeInfoException(
					"Middle Init can contain only alphabetical characters and spaces ");
		}
		System.out.println("success!!!");
	}

	/**
	 * 对雇佣者公寓的检查
	 * 
	 * @param dept
	 */
	public void checkDept(String dept) {
		if (EmpMISUtils.isEmpty(dept)) {
			throw new InvalidEmployeeInfoException(
					"No Dept # entered – try again");
		} else if (!dept.matches("[\\d]*")) {
			throw new InvalidEmployeeInfoException(
					"Dept # can contain only digits with no spaces ");
		}
		System.out.println("success!!!");
	}

	/**
	 * 对雇佣者职称的检查
	 * 
	 * @param title
	 */
	public void checkTitleJob(String title) {
		if (EmpMISUtils.isEmpty(title)) {
			throw new InvalidEmployeeInfoException(
					"No Job title entered – try again");
		} else if (!title.matches("[A-Z][a-z]*")) {
			throw new InvalidEmployeeInfoException(
					"Job title can contain only alphabetical characters and spaces ");
		}
		System.out.println("success!!!");
	}

	/**
	 * 对雇佣时间检查
	 * 
	 * @param date
	 */
	@SuppressWarnings("unused")
	public void checkDateHired(String date) {
		/**
		 * 转换成规范，如果失败就抛出异常
		 */
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy",
				Locale.ENGLISH);
		dateFormat.setLenient(false);
		if (EmpMISUtils.isEmpty(date)) {
			throw new InvalidEmployeeInfoException(
					"No date hired entered – try again");// dd-mm-yyyy
		} 
//		else if (!date.matches("[0-3][\\d]-[0-24][\\d]-[\\d][\\d][\\d][\\d]")) {
//			throw new InvalidEmployeeInfoException("Invalid Date Hired");
//		}
		try {
			/**
			 * 将其停止自动转换
			 */
			dateFormat.setLenient(false);
			/**
			 * 如果转换失败就抛出异常
			 */
			java.util.Date timeDate = dateFormat.parse(date);
		} catch (ParseException e) {
			throw new InvalidEmployeeInfoException("Invalid Date Hired");
			// throw new Exception("Invalid Date Hired – try again");
		}
		catch(Exception ex){
			throw new InvalidEmployeeInfoException("Invalid Date Hired");
		}

		System.out.println("success!!!");
	}
	
}
