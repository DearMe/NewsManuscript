package com.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ComManuscriptForm entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "com_manuscript_form", schema = "dbo", catalog = "NewsManuscript")
public class ComManuscriptForm implements java.io.Serializable {

	// Fields

	private String manuscriptFormId;
	private ComManuscript comManuscript;
	private ComForm comForm;

	// Constructors

	/** default constructor */
	public ComManuscriptForm() {
	}

	/** full constructor */
	public ComManuscriptForm(ComManuscript comManuscript, ComForm comForm) {
		this.comManuscript = comManuscript;
		this.comForm = comForm;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "manuscript_form_id", unique = true, nullable = false, length = 32)
	public String getManuscriptFormId() {
		return this.manuscriptFormId;
	}

	public void setManuscriptFormId(String manuscriptFormId) {
		this.manuscriptFormId = manuscriptFormId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manuscript_id", nullable = false)
	public ComManuscript getComManuscript() {
		return this.comManuscript;
	}

	public void setComManuscript(ComManuscript comManuscript) {
		this.comManuscript = comManuscript;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "form_id", nullable = false)
	public ComForm getComForm() {
		return this.comForm;
	}

	public void setComForm(ComForm comForm) {
		this.comForm = comForm;
	}

}