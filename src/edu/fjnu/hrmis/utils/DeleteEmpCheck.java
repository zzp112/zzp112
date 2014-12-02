package edu.fjnu.hrmis.utils;

import edu.fjnu.hrmis.exception.InvalidEmployeeInfoException;

public class DeleteEmpCheck{

	/**
	 * ����ģʽ
	 */
	private final static DeleteEmpCheck CHECK=new DeleteEmpCheck();
	public static DeleteEmpCheck getInstance(){
		return CHECK;
	}
	
	public void check(String text) {
		/**
		 * ɾ��Ա���ŵ��쳣����
		 * @param text
		 */
			if (text.equals("")) {
				throw new InvalidEmployeeInfoException(
						"No payroll number entered �C try again");
			}
			if(!text.matches("[\\d]{3}")){
				throw new InvalidEmployeeInfoException("Payroll number can contain only numerical characters");
			}
		}
	
	
	public void check() {
		// TODO Auto-generated method stub
		
	}
}
