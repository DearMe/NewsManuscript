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
 * ComProgramProducer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "com_program_producer", schema = "dbo", catalog = "NewsManuscript")
public class ComProgramProducer implements java.io.Serializable {

	// Fields

	private String programProducerId;
	private ComProgram comProgram;
	private ComUser comUser;

	// Constructors

	/** default constructor */
	public ComProgramProducer() {
	}

	/** full constructor */
	public ComProgramProducer(ComProgram comProgram, ComUser comUser) {
		this.comProgram = comProgram;
		this.comUser = comUser;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "program_producer_id", unique = true, nullable = false, length = 32)
	public String getProgramProducerId() {
		return this.programProducerId;
	}

	public void setProgramProducerId(String programProducerId) {
		this.programProducerId = programProducerId;
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
	@JoinColumn(name = "producer_id", nullable = false)
	public ComUser getComUser() {
		return this.comUser;
	}

	public void setComUser(ComUser comUser) {
		this.comUser = comUser;
	}

}