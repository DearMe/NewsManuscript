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
 * ComPosition entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "com_position", schema = "dbo", catalog = "NewsManuscript")
public class ComPosition implements java.io.Serializable {

	// Fields

	private String positionId;
	private ComUser comUser;
	private String positionName;

	// Constructors

	/** default constructor */
	public ComPosition() {
	}

	/** full constructor */
	public ComPosition(ComUser comUser, String positionName) {
		this.comUser = comUser;
		this.positionName = positionName;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "position_id", unique = true, nullable = false, length = 32)
	public String getPositionId() {
		return this.positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public ComUser getComUser() {
		return this.comUser;
	}

	public void setComUser(ComUser comUser) {
		this.comUser = comUser;
	}

	@Column(name = "position_name", nullable = false, length = 32)
	public String getPositionName() {
		return this.positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

}