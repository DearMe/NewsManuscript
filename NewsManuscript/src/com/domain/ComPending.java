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
 * ComPending entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "com_pending", schema = "dbo", catalog = "NewsManuscript")
public class ComPending implements java.io.Serializable {

	// Fields

	private String pendingId;
	private ComUser comUser;
	private ComManuscript comManuscript;

	// Constructors

	/** default constructor */
	public ComPending() {
	}

	/** full constructor */
	public ComPending(ComUser comUser, ComManuscript comManuscript) {
		this.comUser = comUser;
		this.comManuscript = comManuscript;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "pending_id", unique = true, nullable = false, length = 32)
	public String getPendingId() {
		return this.pendingId;
	}

	public void setPendingId(String pendingId) {
		this.pendingId = pendingId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "referee_person_id", nullable = false)
	public ComUser getComUser() {
		return this.comUser;
	}

	public void setComUser(ComUser comUser) {
		this.comUser = comUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manuscript_id", nullable = false)
	public ComManuscript getComManuscript() {
		return this.comManuscript;
	}

	public void setComManuscript(ComManuscript comManuscript) {
		this.comManuscript = comManuscript;
	}

}