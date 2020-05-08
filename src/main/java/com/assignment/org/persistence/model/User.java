package com.assignment.org.persistence.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "users")
@SuppressWarnings("serial")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@NotEmpty
	@Column(name = "emailid")
	private String emailId;
	
	@NotEmpty
	@Column(name = "password")
	private String password;
	
	@NotEmpty
	@Column(name = "name")
	private String name;

	
	@OneToMany
	@JoinTable(name = "user_privilege",
	joinColumns = {@JoinColumn (name = "user_id", referencedColumnName = "id",
            nullable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "privilege_id", referencedColumnName = "id",
                    nullable = false, updatable = false)})
	private Set<Privilege> privileges;
	

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
