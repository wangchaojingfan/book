package com.chao.book.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 调查表
 * @author Administrator
 *
 */
@Entity
@Table(name="survers")
public class Surveys implements Serializable {

	
	private static final long serialVersionUID = -4928243933533944427L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String title;
	private String pretext;
	private String nexttext;
	private String exittext;
	private String donetext;
	@Column(name = "create_time")
	private Date createTime;
	@Column(name="user_id")
	@ManyToOne
	@JoinColumn(name="user_id")
	private Integer userId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPretext() {
		return pretext;
	}
	public void setPretext(String pretext) {
		this.pretext = pretext;
	}
	public String getNexttext() {
		return nexttext;
	}
	public void setNexttext(String nexttext) {
		this.nexttext = nexttext;
	}
	public String getExittext() {
		return exittext;
	}
	public void setExittext(String exittext) {
		this.exittext = exittext;
	}
	public String getDonetext() {
		return donetext;
	}
	public void setDonetext(String donetext) {
		this.donetext = donetext;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	
	
}
