/**
 * 
 */
package edu.fjnu.hrmis;




import edu.fjnu.hrmis.exception.EmpMISException;
import edu.fjnu.hrmis.utils.EmpMISUtils;

/**
 * @author zzp
 *
 */
public class SysLoader {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
	    try{
			Login l=new Login();
			l.show();
		   //»·¾³¼ì²â	
		   EmpMISUtils.checkResource();
		   
		}catch(EmpMISException e){
		   System.out.println("EmpMis exited! cause: "+e.getMessage());
		}finally{
			
		}
	}
}
