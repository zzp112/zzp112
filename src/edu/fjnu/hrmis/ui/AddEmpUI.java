/**
 * 
 */
package edu.fjnu.hrmis.ui;
/**
 * @author zzp
 *ʵ������Ա������
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
	 	���˵�
	 */
	private void EmployeeMenu(Employee emp) {
		/* ��Ա���¼�� */
		EmployeeWrite("Enter employee 3 digit payroll number:", emp);
		/* ��Ա�绰¼�� */
		EmployeeWrite("Enter Phone Number (02-12345678):", emp);
		/* ��Ա����¼�� */
		EmployeeWrite("Enter Last Name:", emp);
		EmployeeWrite("Enter First Name:", emp);
		EmployeeWrite("Enter Middle Init:", emp);
		/* ��Ա��Ԣ¼�� */
		EmployeeWrite("Enter Dept #:", emp);
		/* ��Աְλ¼�� */
		EmployeeWrite("Enter Job Title:", emp);
		/* ����ʱ��¼�� */
		EmployeeWrite("Enter Date Hired (dd-mm-yyyy):", emp);
	}

	// --------------------------------------------------------------------------------------------------
	/**
	 * ���ݵ�д��
	 */
	private void EmployeeWrite(String text, Employee emp) {
		boolean isContinued = true;
		while (isContinued) {
			// ������ʾ
			System.out.print(text);
			String EmployeeImforType = EmpMISUtils.getEntry();
			CheckEmp f = new CheckEmp();
			try {
				if (text.equals("Enter employee 3 digit payroll number:")) {
					f.checkEmpNo(EmployeeImforType);// ���
					emp.setEmpNo(EmployeeImforType);// ��ֵ��employee��
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
					// ��ʽת����date��
					SimpleDateFormat fro = new SimpleDateFormat("dd-mm-yyyy");
					emp.setHiringDate(fro.parse(EmployeeImforType));
					break;
				}
				isContinued = false;
			} catch (InvalidEmployeeInfoException e) {
				EmpMISUtils.pause(e.getMessage());
				continue;
			} catch (ParseException e) {
				System.out.println("�����쳣-----");
				isContinued = false;
			}
		}
	}

	// -------------------------------------------------------------------------------------------------

}
