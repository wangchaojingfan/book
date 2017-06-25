package com.chao.book.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pages")
public class Pages implements Serializable{

	
    private static final long serialVersionUID = 8910705521436970514L;
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private  Integer id;
	private String title;
	private String description;
	@ManyToOne
	@JoinColumn(name="surver_id")
	private Integer surverId;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getSurverId() {
		return surverId;
	}
	public void setSurverId(Integer surverId) {
		this.surverId = surverId;
	}
	
	

}
