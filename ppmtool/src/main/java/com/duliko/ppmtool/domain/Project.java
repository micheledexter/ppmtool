package com.duliko.ppmtool.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Project name is required")
	private String projectName;
	
	@NotBlank(message = "Project Identifier is required")
	@Size(min = 4, max = 5, message = "Please use 4 to 5 characters")
	@Column(updatable = false, unique = true)
	private String projectIdentifier;
	
	@NotBlank(message = "Project description is required")
	private String description;
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date start_date;
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date end_date;
	
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	@Column(updatable = false)
	private Date created_At;
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date updated_At;
	
	@PrePersist
	protected void onCreate() {
		this.created_At = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updated_At = new Date();
	}
	
	// ECLIPSE CORSH

	public Project() {
		super();
	}

	public Project(Long id, @NotBlank(message = "Project name is required") String projectName,
			@NotBlank(message = "Project Identifier is required") @Size(min = 4, max = 5, message = "Please use 4 to 5 characters") String projectIdentifier,
			@NotBlank(message = "Project description is required") String description, Date start_date, Date end_date,
			Date created_At, Date updated_At) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.projectIdentifier = projectIdentifier;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.created_At = created_At;
		this.updated_At = updated_At;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	public Date getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", projectIdentifier=" + projectIdentifier
				+ ", description=" + description + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", created_At=" + created_At + ", updated_At=" + updated_At + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created_At == null) ? 0 : created_At.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((projectIdentifier == null) ? 0 : projectIdentifier.hashCode());
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
		result = prime * result + ((updated_At == null) ? 0 : updated_At.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (created_At == null) {
			if (other.created_At != null)
				return false;
		} else if (!created_At.equals(other.created_At))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (end_date == null) {
			if (other.end_date != null)
				return false;
		} else if (!end_date.equals(other.end_date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (projectIdentifier == null) {
			if (other.projectIdentifier != null)
				return false;
		} else if (!projectIdentifier.equals(other.projectIdentifier))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		if (start_date == null) {
			if (other.start_date != null)
				return false;
		} else if (!start_date.equals(other.start_date))
			return false;
		if (updated_At == null) {
			if (other.updated_At != null)
				return false;
		} else if (!updated_At.equals(other.updated_At))
			return false;
		return true;
	}
}
