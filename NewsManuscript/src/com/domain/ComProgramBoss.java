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
 * ComProgramBoss entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "com_program_boss", schema = "dbo", catalog = "NewsManuscript")
public class ComProgramBoss implements java.io.Serializable {

	// Fields

	private String programBossId;
	private ComProgram comProgram;
	private ComUser comUser;

	// Constructors

	/** default constructor */
	public ComProgramBoss() {
	}

	/** full constructor */
	public ComProgramBoss(ComProgram comProgram, ComUser comUser) {
		this.comProgram = comProgram;
		this.comUser = comUser;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "program_boss_id", unique = true, nullable = false, length = 32)
	public String getProgramBossId() {
		return this.programBossId;
	}

	public void setProgramBossId(String programBossId) {
		this.programBossId = programBossId;
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
	@JoinColumn(name = "boss_id", nullable = false)
	public ComUser getComUser() {
		return this.comUser;
	}

	public void setComUser(ComUser comUser) {
		this.comUser = comUser;
	}

}