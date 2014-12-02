package edu.fjnu.hrmis.utils;

import edu.fjnu.hrmis.exception.InvalidEmployeeInfoException;

public class DeleteEmpCheck{

	/**
	 * 单例模式
	 */
	private final static DeleteEmpCheck CHECK=new DeleteEmpCheck();
	public static DeleteEmpCheck getInstance(){
		return CHECK;
	}
	
	public void check(String text) {
		/**
		 * 删除员工号的异常处理
		 * @param text
		 */
			if (text.equals("")) {
				throw new InvalidEmployeeInfoException(
						"No payroll number entered – try again");
			}
			if(!text.matches("[\\d]{3}")){
				throw new InvalidEmployeeInfoException("Payroll number can contain only numerical characters");
			}
		}
	
	
	public void check() {
		// TODO Auto-generated method stub
		
	}
}
