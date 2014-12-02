/**
 * 
 */
package edu.fjnu.hrmis.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author zzp
 *
 */
/**
 * @author Administrator 雇员
 */
public class Employee extends ValueObject implements Comparable<Employee> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6027162912918857656L;
	//用于格式化输出
	private static final SimpleDateFormat form=new SimpleDateFormat("dd-mm-yyyy");
	/** 雇员编号 */
	private String empNo;

	/** 电话号码 */
	private String empPhonecode;
	private String lastName;
	private String fistName;
	private String initial;
	private Integer deptNo;
	private String jobTitle;
	private Date hiringDate;

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpPhonecode() {
		return empPhonecode;
	}

	public void setEmpPhonecode(String empPhonecode) {
		this.empPhonecode = empPhonecode;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	public Integer getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getHiringDate() {
		return hiringDate;
	}

	public void setHiringDate(Date hiringDate) {
		this.hiringDate = hiringDate;
	}

	/**
	 * @param empNo
	 * @param empPhonecode
	 * @param lastName
	 * @param fistName
	 * @param initial
	 * @param deptNo
	 * @param jobTitle
	 * @param hiringDate
	 */
	public Employee(String empNo, String empPhonecode, String lastName,
			String fistName, String initial, Integer deptNo, String jobTitle,
			Date hiringDate) {
		this.empNo = empNo;
		this.empPhonecode = empPhonecode;
		this.lastName = lastName;
		this.fistName = fistName;
		this.initial = initial;
		this.deptNo = deptNo;
		this.jobTitle = jobTitle;
		this.hiringDate = hiringDate;
	}

	public Employee() {

	}

	/** 重写toString 用于普通输出 */
	@Override
	public String toString() {
		return this.empNo + ":" + this.empPhonecode + ":" + this.lastName + ":"
				+ this.fistName + ":" + this.initial + ":" + this.deptNo + ":"
				+ this.jobTitle + ":" + form.format(hiringDate);
	}

	/**
	 * 格式化输出
	 */
	public void formattedOut() {
		System.out.printf("%-10s%-10s%-10s%-20s%-10s%-20s%-20s\n", this.lastName,
				this.fistName, this.empNo, this.empPhonecode, this.deptNo,
				this.jobTitle, form.format(hiringDate));
	}

	/**
	 * 名字和电话号码的输出
	 */
	public void shortedOut() {
		System.out.printf(this.lastName+","+this.fistName+","+this.empPhonecode+"\n");
	}

	/**
	 * 名字和电话号码的格式化输出
	 */
	public void shortedFormattedOut() {
		System.out.printf("%-10s%-14s%-14s\n",this.lastName ,this.fistName,this.empPhonecode);
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		if (!this.lastName.equals(o.lastName)) {
			return this.lastName.compareTo(o.lastName);
		} else if (!this.fistName.equals(o.fistName)) {
			return this.fistName.compareTo(o.fistName);
		} else if (!this.initial.equals(o.initial)) {
			return this.initial.compareTo(o.initial);
		} else if (!this.empNo.equals(o.empNo)) {
			return this.empNo.compareTo(o.empNo);
		} else if (!this.empPhonecode.equals(o.empPhonecode)) {
			return this.empPhonecode.compareTo(o.empPhonecode);
		} else if (!this.deptNo.equals(o.deptNo)) {
			return this.empNo.compareTo(o.empNo);
		} else if (!this.jobTitle.equals(o.jobTitle)) {
			return this.jobTitle.compareTo(o.jobTitle);
		} else if (!this.hiringDate.equals(o.hiringDate)) {
			return this.hiringDate.compareTo(o.hiringDate);
		}
		return 0;
	}

}
