package edu.fjnu.hrmis.ui;
/**
 * @author zzp
 *
 */
import edu.fjnu.hrmis.dao.EmployeeDao;
import edu.fjnu.hrmis.dao.EmployeeDaoTxtImpl;
import edu.fjnu.hrmis.domain.Employee;
import edu.fjnu.hrmis.utils.EmpMISUtils;
public class ShortEmpUI implements BaseUI{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		EmployeeDao emp=new EmployeeDaoTxtImpl();
		for(Employee tree:emp.listEmps()){
			tree.shortedOut();
		}
		EmpMISUtils.pause("Press Enter to continue...");
	}

}
