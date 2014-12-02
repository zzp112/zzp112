package edu.fjnu.hrmis.ui;
/**
 * @author zzp
 *�޸�Ա����Ϣ
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
	 * ��Ӷ�����˵� 
	 */
	private void EmployeeMenu(Employee emp) {
		/*��Ա���¼�� ��ѯ���ĺ�*/
		EmployeeWrite("Enter three number to alter:", emp);
		/* ��Ա�绰¼��*/
		EmployeeWrite("Enter Phone Number (02-12345678):", emp);
		/*��Ա����¼��*/
		EmployeeWrite("Enter Last Name:", emp);
		EmployeeWrite("Enter First Name:", emp);
		EmployeeWrite("Enter Middle Init:", emp);
		/* ��Ա��Ԣ¼��*/
		EmployeeWrite("Enter Dept #:", emp);
		/*��Աְλ¼��*/
		EmployeeWrite("Enter Job Title:", emp);
		/*����ʱ��¼��*/
		EmployeeWrite("Enter Date Hired (dd-mm-yyyy):", emp);
	}
	private int SearchAterEmp() {
		boolean flag = true;
		boolean flag2 = true;
		int count = -1;// ����
		do {
			try {
				EmployeeDao emp = new EmployeeDaoTxtImpl();
		
				for (Employee employee : emp.listEmps()) {
					// ��鲻�淶������쳣
					DeleteEmpCheck.getInstance().check(EmployeeImforType);
					count++;
					if (EmployeeImforType.toUpperCase().equals(employee.getEmpNo().toUpperCase())) {
						return count;// ����Ҫɾ��������============================
					}
					else {
						flag = true;// û���ҵ�Ҫ���û���������
						flag2 = true;// û���ҵ��ؼ��������淢���źű�ʾ�׳��쳣
					}
				}
				if (flag2 == true) {
					throw new InvalidEmployeeInfoException("Keyword �C " + EmployeeImforType
							+ "- not found\n");
				}
			} catch (InvalidEmployeeInfoException e) {
				System.out.println(e.getMessage());
				EmpMISUtils.pause("Press Enter to continue... ");
			} catch (Exception ex) {
				System.out.println("�����쳣������");
			}
		} while (flag == true);
		return -1;
	}

	/**
	 ���ݵ�д��
	 */
	private void EmployeeWrite(String text, Employee emp) {
		boolean isContinued = true;
		while (isContinued) {
			// ������ʾ
			System.out.print(text);
			EmployeeImforType = EmpMISUtils.getEntry();
			CheckEmp f = new CheckEmp();
			try {
				if (text.equals("Enter three number to alter:")) {
					/*ɾ��ԭ���ĺ�*/
					EmployeeDao empDao = new EmployeeDaoTxtImpl();
					// ɾ������SearchDeleteEmp
					empDao.deleteEmp2(SearchAterEmp());
					//�����µ�ֵ
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

}
