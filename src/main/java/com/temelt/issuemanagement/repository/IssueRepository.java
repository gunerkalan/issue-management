package com.temelt.issuemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temelt.issuemanagement.entity.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {
	
	

}
