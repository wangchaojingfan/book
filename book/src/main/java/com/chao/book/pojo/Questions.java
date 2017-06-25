package com.chao.book.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 问题表
 * @author Administrator
 *
 */
@Entity
@Table(name="questions")
public class Questions implements Serializable {

	
	private static final long serialVersionUID = -6147406664414958712L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer id;
	@Column(name="question_type")
	private Integer questionType;
	private String title;
	private String options;
	private Boolean other;
	@Column(name="other_style")
	private Integer otherStyle;
	@Column(name="other_select_options")
	private String otherSelectOptions;
	@Column(name="matrix_row_titles")
	private String matrixRowTitles;
	@Column(name="matrix_col_titles")
	private String matrixColTitles;
	@Column(name="matrix_select_options")
	private String matrixSelectOptions;
	@ManyToOne
	@JoinColumn(name="page_id")
	private Integer pageId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuestionType() {
		return questionType;
	}
	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public Boolean getOther() {
		return other;
	}
	public void setOther(Boolean other) {
		this.other = other;
	}
	public Integer getOtherStyle() {
		return otherStyle;
	}
	public void setOtherStyle(Integer otherStyle) {
		this.otherStyle = otherStyle;
	}
	public String getOtherSelectOptions() {
		return otherSelectOptions;
	}
	public void setOtherSelectOptions(String otherSelectOptions) {
		this.otherSelectOptions = otherSelectOptions;
	}
	public String getMatrixRowTitles() {
		return matrixRowTitles;
	}
	public void setMatrixRowTitles(String matrixRowTitles) {
		this.matrixRowTitles = matrixRowTitles;
	}
	public String getMatrixColTitles() {
		return matrixColTitles;
	}
	public void setMatrixColTitles(String matrixColTitles) {
		this.matrixColTitles = matrixColTitles;
	}
	public String getMatrixSelectOptions() {
		return matrixSelectOptions;
	}
	public void setMatrixSelectOptions(String matrixSelectOptions) {
		this.matrixSelectOptions = matrixSelectOptions;
	}
	public Integer getPageId() {
		return pageId;
	}
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
	@Override
	public String toString() {
		return "Questions [id=" + id + ", questionType=" + questionType + ", title=" + title + ", options=" + options
				+ ", other=" + other + ", otherStyle=" + otherStyle + ", otherSelectOptions=" + otherSelectOptions
				+ ", matrixRowTitles=" + matrixRowTitles + ", matrixColTitles=" + matrixColTitles
				+ ", matrixSelectOptions=" + matrixSelectOptions + ", pageId=" + pageId + "]";
	}
	
	
	
}
