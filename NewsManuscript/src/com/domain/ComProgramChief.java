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
 * ComProgramChief entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "com_program_chief", schema = "dbo", catalog = "NewsManuscript")
public class ComProgramChief implements java.io.Serializable {

	// Fields

	private String programChiefId;
	private ComProgram comProgram;
	private ComUser comUser;

	// Constructors

	/** default constructor */
	public ComProgramChief() {
	}

	/** full constructor */
	public ComProgramChief(ComProgram comProgram, ComUser comUser) {
		this.comProgram = comProgram;
		this.comUser = comUser;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "program_chief_id", unique = true, nullable = false, length = 32)
	public String getProgramChiefId() {
		return this.programChiefId;
	}

	public void setProgramChiefId(String programChiefId) {
		this.programChiefId = programChiefId;
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
	@JoinColumn(name = "chief_id", nullable = false)
	public ComUser getComUser() {
		return this.comUser;
	}

	public void setComUser(ComUser comUser) {
		this.comUser = comUser;
	}

}