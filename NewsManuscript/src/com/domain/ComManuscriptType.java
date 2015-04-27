package com.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ComManuscriptType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "com_manuscript_type", schema = "dbo", catalog = "NewsManuscript")
public class ComManuscriptType implements java.io.Serializable {

	// Fields

	private String manuscriptTypeId;
	private String manuscripterTypeName;
	private Set<ComManuscript> comManuscripts = new HashSet<ComManuscript>(0);

	// Constructors

	/** default constructor */
	public ComManuscriptType() {
	}

	/** minimal constructor */
	public ComManuscriptType(String manuscripterTypeName) {
		this.manuscripterTypeName = manuscripterTypeName;
	}

	/** full constructor */
	public ComManuscriptType(String manuscripterTypeName,
			Set<ComManuscript> comManuscripts) {
		this.manuscripterTypeName = manuscripterTypeName;
		this.comManuscripts = comManuscripts;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "manuscript_type_id", unique = true, nullable = false, length = 32)
	public String getManuscriptTypeId() {
		return this.manuscriptTypeId;
	}

	public void setManuscriptTypeId(String manuscriptTypeId) {
		this.manuscriptTypeId = manuscriptTypeId;
	}

	@Column(name = "manuscripter_type_name", nullable = false, length = 32)
	public String getManuscripterTypeName() {
		return this.manuscripterTypeName;
	}

	public void setManuscripterTypeName(String manuscripterTypeName) {
		this.manuscripterTypeName = manuscripterTypeName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comManuscriptType")
	public Set<ComManuscript> getComManuscripts() {
		return this.comManuscripts;
	}

	public void setComManuscripts(Set<ComManuscript> comManuscripts) {
		this.comManuscripts = comManuscripts;
	}

}