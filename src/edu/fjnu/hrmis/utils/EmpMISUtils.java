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
 *  ϵͳ������
 */
public class EmpMISUtils {
	
	private static final String DATA_FILE="C:/Users/Administrator/Desktop/java�������/����ҵ1/records.TXT";
	
	public static void runUIComponent(String uiType){
		UIFactory.getInstance().getComponent(uiType).run();
	}
	
	public static void checkResource(){
		//record.txt�Ƿ����
		File file=new File(DATA_FILE);
		if(!file.exists())
			throw new EmpMISException("Employee Information file named records.txt is not existed! Now Exit!");
	}
	
	/**
	 * �ӿ��ƶ�ȡһ������
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
	 * ��ͣ
	 */
	public static void pause(){
		getEntry();
	}
	
	/**
	 * ����ʾ����Ļ������ͣ
	 * @param prompt
	 */
	public static void pause(String prompt){
		System.out.print(prompt);
		getEntry();
	}
	
	/**
	 * ����ַ����Ƿ�Ϊnull
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		return str==null||str.trim().length()==0;
	}
	
}
