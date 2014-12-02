package edu.fjnu.hrmis.ui;
/**
 * @author zzp
 *
 */
import edu.fjnu.hrmis.dao.EmployeeDao;
import edu.fjnu.hrmis.dao.EmployeeDaoTxtImpl;
import edu.fjnu.hrmis.domain.Employee;
import edu.fjnu.hrmis.utils.EmpMISUtils;

public class ShortEmpFormatUI implements BaseUI {
	@Override
	public void run() {
		EmployeeDao emp=new EmployeeDaoTxtImpl();
		for(Employee tree:emp.listSortedEmps()){
			tree.shortedFormattedOut();
		}
		EmpMISUtils.pause("Press Enter to continue...");
	}

}
