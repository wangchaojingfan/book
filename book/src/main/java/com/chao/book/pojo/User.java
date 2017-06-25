package com.chao.book.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户表
 * @author Administrator
 *
 */
@Entity
@Table(name="users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 4034999365723140702L;
	@Id
	@GeneratedValue
	private Integer id;
	private String email;
	private String password;
	private String nickName;
	private Date regdate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", nickName=" + nickName
				+ ", regdate=" + regdate + "]";
	}
	
	
	
}
