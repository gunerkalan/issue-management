package com.temelt.issuemanagement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.temelt.issuemanagement.dto.IssueHistoryDto;
import com.temelt.issuemanagement.entity.Issue;
import com.temelt.issuemanagement.entity.IssueHistory;
import com.temelt.issuemanagement.util.TPage;

public interface IssueHistoryService {
	
    IssueHistoryDto save(IssueHistoryDto issueHistory);
	
	IssueHistoryDto getById(Long id);
	
	List<IssueHistoryDto> getByIssueId(Long id);	
	
	TPage<IssueHistoryDto>getAllPageable(Pageable pageable);
	
	Boolean delete(Long id);
	
	void addHistory(Long id, Issue issue);

}
