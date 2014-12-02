/**
 * 
 */
package edu.fjnu.hrmis.utils;
/**
 * @author zzp
 *
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.fjnu.hrmis.exception.EmpMISException;
import edu.fjnu.hrmis.ui.UIFactory;

/**
 * @author Administrator
 *  系统服务类
 */
public class EmpMISUtils {
	
	private static final String DATA_FILE="C:/Users/Administrator/Desktop/java面向对象/大作业1/records.TXT";
	
	public static void runUIComponent(String uiType){
		UIFactory.getInstance().getComponent(uiType).run();
	}
	
	public static void checkResource(){
		//record.txt是否存在
		File file=new File(DATA_FILE);
		if(!file.exists())
			throw new EmpMISException("Employee Information file named records.txt is not existed! Now Exit!");
	}
	
	/**
	 * 从控制读取一行输入
	 * @return
	 */
	public static String getEntry(){
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String entry=null;
		
		try {
			entry=reader.readLine();
		} catch (IOException e) {
			throw new EmpMISException("Read entry from console failed! please check!");
		}
		
		return entry;
	}
	
	/**
	 * 暂停
	 */
	public static void pause(){
		getEntry();
	}
	
	/**
	 * 带提示的屏幕操作暂停
	 * @param prompt
	 */
	public static void pause(String prompt){
		System.out.print(prompt);
		getEntry();
	}
	
	/**
	 * 检测字符串是否为null
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		return str==null||str.trim().length()==0;
	}
	
}
