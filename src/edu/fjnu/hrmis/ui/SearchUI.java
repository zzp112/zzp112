package edu.fjnu.hrmis.ui;

/**
 * @author zzp
 *
 */
import edu.fjnu.hrmis.dao.EmployeeDao;
import edu.fjnu.hrmis.dao.EmployeeDaoTxtImpl;
import edu.fjnu.hrmis.domain.Employee;
import edu.fjnu.hrmis.exception.InvalidEmployeeInfoException;
import edu.fjnu.hrmis.utils.EmpMISUtils;

public class SearchUI implements BaseUI {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			EmployeeDao emp = new EmployeeDaoTxtImpl();
			System.out.print("Enter keyword:");
			String input = EmpMISUtils.getEntry().toUpperCase();
			boolean flag = true;
			for (Employee employee : emp.listEmps()) {
				if (input.equals("")) {
					throw new InvalidEmployeeInfoException(
							"No keyword entered ¨C try again¡­");
				}
				if (input.toUpperCase().equals(
						employee.getEmpNo().toUpperCase())
						|| input.toUpperCase().equals(
								employee.getEmpPhonecode().toUpperCase())
						|| input.toUpperCase().equals(
								employee.getFistName().toUpperCase())
						|| input.toUpperCase().equals(
								employee.getInitial().toUpperCase())
						|| input.toUpperCase().equals(
								employee.getJobTitle().toUpperCase())
						|| input.toUpperCase().equals(
								employee.getLastName().toUpperCase())
						|| input.toUpperCase().equals(
								String.valueOf(employee.getDeptNo())
										.toUpperCase())
						|| input.toUpperCase().equals(
								String.valueOf(employee.getHiringDate())
										.toUpperCase())) {
					employee.formattedOut();
					flag = true;
					break;
				} else {
					flag = false;
				}
			}
			if (flag == false) {
				throw new InvalidEmployeeInfoException("Keyword ¨C " + input
						+ "- not found");
			}
		} catch (InvalidEmployeeInfoException e) {
			System.out.println(e.getMessage());
			EmpMISUtils.pause("Press Enter to continue... ");
		}
		EmpMISUtils.pause("Press Enter to continue...");
	}
}
