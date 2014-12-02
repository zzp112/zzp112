/**
 * 
 */
package edu.fjnu.hrmis.exception;
/**
 * @author zzp
 *
 */
/**
 * @author Administrator
 * 系统基础异常
 */
public class EmpMISException extends RuntimeException {

	/**
	 * 
	 */
	public EmpMISException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public EmpMISException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public EmpMISException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public EmpMISException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
