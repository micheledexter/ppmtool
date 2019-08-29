package com.duliko.ppmtool.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duliko.ppmtool.domain.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

	Project findByProjectIdentifier(String projectId);
}
