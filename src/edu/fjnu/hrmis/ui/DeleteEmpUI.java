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
		// 删除对象SearchDeleteEmp
		empDao.deleteEmp(SearchDeleteEmp());
	}

	/**
	 * 提示
	 */
	private void watching() {
		System.out.println("\n兴邦资讯 – Employee Records:");
		System.out.println("======================================");
		System.out.println();
		System.out.println("Employee Record Deletion:");
	}

	/**
	 * 找到要删除的内容
	 */
	private int SearchDeleteEmp() {
		boolean flag = true;
		boolean flag2 = true;
		int count=-1;//索引
		do {
			try {
				EmployeeDao emp = new EmployeeDaoTxtImpl();
				// 提示
				watching();
				System.out.print("Enter employee’s 3 digit payroll number to enable record deletion:");
				// 输入
				String input = EmpMISUtils.getEntry().toUpperCase();
				for (Employee employee : emp.listEmps()) {
					count++;
					// 检查不规范输入的异常
					DeleteEmpCheck.getInstance().check(input);
					if (input.equals(employee.getEmpNo().toUpperCase())) {
						// 是否继续做删除的判断
						System.out.println("Delete another? (y)es or (n)o, y");
						String choice = EmpMISUtils.getEntry();
						if (choice.equals("y")) {
							flag = true;
							flag2 = false;
						}
						else{
							
							flag = false;// 用户没有输入y，终止运行，跳出循环到主菜单
						}
						//System.out.println(emp.listEmps().get(count)+"============");
						return count;// 返回要删除的索引============================
					}

					else {
						flag = true;// 没有找到要求用户继续输入
						flag2 = true;// 没有找到关键字向外面发出信号表示抛出异常
					}
				}
				if (flag2 == true) {
					watching();
					throw new InvalidEmployeeInfoException("Keyword – " + input
							+ "- not found\n");
				}
			} catch (InvalidEmployeeInfoException e) {
				System.out.println(e.getMessage());
				EmpMISUtils.pause("Press Enter to continue... ");
			} catch (Exception ex) {
				System.out.println("发生异常");
			}
		} while (flag == true);
		return -1;
	}
}
