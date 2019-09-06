package com.duliko.ppmtool.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duliko.ppmtool.domain.Backlog;
import com.duliko.ppmtool.domain.Project;
import com.duliko.ppmtool.exceptions.ProjectIdException;
import com.duliko.ppmtool.repositories.BacklogRepository;
import com.duliko.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private BacklogRepository backlogRepository;
	
	public Project saveOrUpdateProject(Project project) {
		
		try {
			
			String projectIdentifier = project.getProjectIdentifier().toUpperCase();
			
			project.setProjectIdentifier(projectIdentifier);
			
			if (project.getId() == null) {
				Backlog backlog = new Backlog();
				project.setBacklog(backlog);
				backlog.setProject(project);
				backlog.setProjectIdentifier(projectIdentifier);
			}
			
			if (project.getId() != null) {
				project.setBacklog(backlogRepository.findByProjectIdentifier(projectIdentifier));
			}
			
			return projectRepository.save(project);
		} catch (Exception e) {
			throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists");
		}
	}
	
	public Project findProjectByIdentifier(String projectId) {
		
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		
		if (project == null) {
			throw new ProjectIdException("Project ID '" + projectId + "' does not exist");
		}
		
		return project;
	}
	
	public List<Project> findAllProjects() {
		return projectRepository.findAll();
	}
	
	public void deleteProjectByIdentifier(String projectId) {
		
		Project project = projectRepository.findByProjectIdentifier(projectId);
		
		if (project == null) {
			throw new ProjectIdException("Cannot delete Project with ID '" + projectId + "'. This project does not exist");
		}
		
		projectRepository.delete(project);
	}
}
