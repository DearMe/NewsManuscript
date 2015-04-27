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
 * ComDepartment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "com_department", schema = "dbo", catalog = "NewsManuscript")
public class ComDepartment implements java.io.Serializable {

	// Fields

	private String departmentId;
	private String departmentName;
	private String parentDepartment;
	private Set<ComUser> comUsers = new HashSet<ComUser>(0);

	// Constructors

	/** default constructor */
	public ComDepartment() {
	}

	/** minimal constructor */
	public ComDepartment(String departmentName) {
		this.departmentName = departmentName;
	}

	/** full constructor */
	public ComDepartment(String departmentName, String parentDepartment,
			Set<ComUser> comUsers) {
		this.departmentName = departmentName;
		this.parentDepartment = parentDepartment;
		this.comUsers = comUsers;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "department_id", unique = true, nullable = false, length = 32)
	public String getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	@Column(name = "department_name", nullable = false, length = 32)
	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Column(name = "parent_department", length = 32)
	public String getParentDepartment() {
		return this.parentDepartment;
	}

	public void setParentDepartment(String parentDepartment) {
		this.parentDepartment = parentDepartment;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "comDepartment")
	public Set<ComUser> getComUsers() {
		return this.comUsers;
	}

	public void setComUsers(Set<ComUser> comUsers) {
		this.comUsers = comUsers;
	}

}