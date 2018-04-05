/**
 * 
 */
package com.pkm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.LastModifiedBy;


/**
 * @author pkumar
 *
 */
@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String description;
	private String name;
	private boolean completed;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdDate", insertable = false, updatable = false)
	private Date createdDate;

	@LastModifiedBy
	private Date lastModifiedBy;
	
	public Todo(final String description,final String name) {
		super();
		this.description = description;
		this.name = name;
	}

	public Todo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Date lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
