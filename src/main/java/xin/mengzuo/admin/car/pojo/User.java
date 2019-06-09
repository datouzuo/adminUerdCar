package xin.mengzuo.admin.car.pojo;

import java.io.Serializable;


public class User implements Serializable{
 
	private Integer userid;
	
	
    private String username;
   
	
    private String email;
	
	
    private String phone;
	

    private String password;
	

	private Integer active;
	
	private String activecode;

	public String getActivecode() {
		return activecode;
	}

	public void setActivecode(String activecode) {
		this.activecode = activecode;
	}


	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}



}