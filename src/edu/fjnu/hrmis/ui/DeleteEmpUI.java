package edu.fjnu.hrmis.ui;
/**
 * @author zzp
 *
 */
import edu.fjnu.hrmis.dao.EmployeeDao;
import edu.fjnu.hrmis.dao.EmployeeDaoTxtImpl;
import edu.fjnu.hrmis.domain.Employee;
import edu.fjnu.hrmis.exception.InvalidEmployeeInfoException;
import edu.fjnu.hrmis.utils.DeleteEmpCheck;
import edu.fjnu.hrmis.utils.EmpMISUtils;

public class DeleteEmpUI implements BaseUI {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		EmployeeDao empDao = new EmployeeDaoTxtImpl();
		// ɾ������SearchDeleteEmp
		empDao.deleteEmp(SearchDeleteEmp());
	}

	/**
	 * ��ʾ
	 */
	private void watching() {
		System.out.println("\n�˰���Ѷ �C Employee Records:");
		System.out.println("======================================");
		System.out.println();
		System.out.println("Employee Record Deletion:");
	}

	/**
	 * �ҵ�Ҫɾ��������
	 */
	private int SearchDeleteEmp() {
		boolean flag = true;
		boolean flag2 = true;
		int count=-1;//����
		do {
			try {
				EmployeeDao emp = new EmployeeDaoTxtImpl();
				// ��ʾ
				watching();
				System.out.print("Enter employee��s 3 digit payroll number to enable record deletion:");
				// ����
				String input = EmpMISUtils.getEntry().toUpperCase();
				for (Employee employee : emp.listEmps()) {
					count++;
					// ��鲻�淶������쳣
					DeleteEmpCheck.getInstance().check(input);
					if (input.equals(employee.getEmpNo().toUpperCase())) {
						// �Ƿ������ɾ�����ж�
						System.out.println("Delete another? (y)es or (n)o, y");
						String choice = EmpMISUtils.getEntry();
						if (choice.equals("y")) {
							flag = true;
							flag2 = false;
						}
						else{
							
							flag = false;// �û�û������y����ֹ���У�����ѭ�������˵�
						}
						//System.out.println(emp.listEmps().get(count)+"============");
						return count;// ����Ҫɾ��������============================
					}

					else {
						flag = true;// û���ҵ�Ҫ���û���������
						flag2 = true;// û���ҵ��ؼ��������淢���źű�ʾ�׳��쳣
					}
				}
				if (flag2 == true) {
					watching();
					throw new InvalidEmployeeInfoException("Keyword �C " + input
							+ "- not found\n");
				}
			} catch (InvalidEmployeeInfoException e) {
				System.out.println(e.getMessage());
				EmpMISUtils.pause("Press Enter to continue... ");
			} catch (Exception ex) {
				System.out.println("�����쳣");
			}
		} while (flag == true);
		return -1;
	}
}
