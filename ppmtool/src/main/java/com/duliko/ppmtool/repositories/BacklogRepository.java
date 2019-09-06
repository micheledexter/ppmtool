package com.duliko.ppmtool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duliko.ppmtool.domain.Backlog;

@Repository
public interface BacklogRepository extends JpaRepository<Backlog, Long> {

	Backlog findByProjectIdentifier(String identifier);
}
