/**
 * 
 */
package edu.fjnu.hrmis.ui;
/**
 * @author zzp
 *
 */
import edu.fjnu.hrmis.dao.EmployeeDao;
import edu.fjnu.hrmis.dao.EmployeeDaoTxtImpl;
import edu.fjnu.hrmis.domain.Employee;
import edu.fjnu.hrmis.utils.EmpMISUtils;

public class ListsSortedEmpsUI implements BaseUI {
	@Override
	public void run() {

		EmployeeDao empDao = new EmployeeDaoTxtImpl();

		for (Employee emp : empDao.listSortedEmps()) {
			emp.formattedOut();
		}
		EmpMISUtils.pause("Press Enter to continue...");
	}
}
