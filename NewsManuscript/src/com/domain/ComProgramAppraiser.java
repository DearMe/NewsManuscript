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
 * ComProgramAppraiser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "com_program_appraiser", schema = "dbo", catalog = "NewsManuscript")
public class ComProgramAppraiser implements java.io.Serializable {

	// Fields

	private String programAppraiserId;
	private ComProgram comProgram;
	private ComUser comUser;

	// Constructors

	/** default constructor */
	public ComProgramAppraiser() {
	}

	/** full constructor */
	public ComProgramAppraiser(ComProgram comProgram, ComUser comUser) {
		this.comProgram = comProgram;
		this.comUser = comUser;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "program_appraiser_id", unique = true, nullable = false, length = 32)
	public String getProgramAppraiserId() {
		return this.programAppraiserId;
	}

	public void setProgramAppraiserId(String programAppraiserId) {
		this.programAppraiserId = programAppraiserId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "program_id", nullable = false)
	public ComProgram getComProgram() {
		return this.comProgram;
	}

	public void setComProgram(ComProgram comProgram) {
		this.comProgram = comProgram;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "appraiser_id", nullable = false)
	public ComUser getComUser() {
		return this.comUser;
	}

	public void setComUser(ComUser comUser) {
		this.comUser = comUser;
	}

}