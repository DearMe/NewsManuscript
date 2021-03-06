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
 * ComProgramEditorCharge entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "com_program_editor_charge", schema = "dbo", catalog = "NewsManuscript")
public class ComProgramEditorCharge implements java.io.Serializable {

	// Fields

	private String programEditorChargeId;
	private ComProgram comProgram;
	private ComUser comUser;

	// Constructors

	/** default constructor */
	public ComProgramEditorCharge() {
	}

	/** full constructor */
	public ComProgramEditorCharge(ComProgram comProgram, ComUser comUser) {
		this.comProgram = comProgram;
		this.comUser = comUser;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "program_editor_charge_id", unique = true, nullable = false, length = 32)
	public String getProgramEditorChargeId() {
		return this.programEditorChargeId;
	}

	public void setProgramEditorChargeId(String programEditorChargeId) {
		this.programEditorChargeId = programEditorChargeId;
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
	@JoinColumn(name = "editor_charge_id", nullable = false)
	public ComUser getComUser() {
		return this.comUser;
	}

	public void setComUser(ComUser comUser) {
		this.comUser = comUser;
	}

}