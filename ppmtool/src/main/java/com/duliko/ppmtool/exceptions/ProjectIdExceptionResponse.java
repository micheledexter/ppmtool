package com.duliko.ppmtool.exceptions;

public class ProjectIdExceptionResponse {

	private String projectIdentifier;
	
	// ECLIPSE CORSH

	public ProjectIdExceptionResponse() {
		super();
	}

	public ProjectIdExceptionResponse(String projectIdentifier) {
		super();
		this.projectIdentifier = projectIdentifier;
	}

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

	@Override
	public String toString() {
		return "ProjectIdExceptionResponse [projectIdentifier=" + projectIdentifier + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((projectIdentifier == null) ? 0 : projectIdentifier.hashCode());
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
		ProjectIdExceptionResponse other = (ProjectIdExceptionResponse) obj;
		if (projectIdentifier == null) {
			if (other.projectIdentifier != null)
				return false;
		} else if (!projectIdentifier.equals(other.projectIdentifier))
			return false;
		return true;
	}
}
