package com.temelt.issuemanagement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.temelt.issuemanagement.dto.IssueDto;
import com.temelt.issuemanagement.entity.Issue;
import com.temelt.issuemanagement.util.TPage;

public interface IssueService {
	
	IssueDto save(IssueDto issue);
	
	IssueDto getById(Long id);
	
	TPage<IssueDto>getAllPageable(Pageable pageable);
	
	Boolean delete(Long issueId);
   
	List<IssueDto> getAll();
}
