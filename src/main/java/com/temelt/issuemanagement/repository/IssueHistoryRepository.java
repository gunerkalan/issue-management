package com.temelt.issuemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temelt.issuemanagement.entity.IssueHistory;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long> {
	
	List<IssueHistory> getByIssueIdOrderById(Long id);

}
