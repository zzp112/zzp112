package edu.fjnu.hrmis.domain;
/**
 * @author zzp
 *
 */

public class User implements Comparable<User> {
	private String username;
	private String password;
	/**
	 * @param username
	 * @param password
	 */
	public User(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}
	public User(){
		
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	//重写比较方法
	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		if(this.username.equals(o.username)){
			return this.username.compareTo(o.username);
		}
		return this.password.compareTo(o.password);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.username+":"+this.password;
	}
	
	
}
