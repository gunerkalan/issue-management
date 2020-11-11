package com.temelt.issuemanagement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.temelt.issuemanagement.dto.ProjectDto;
import com.temelt.issuemanagement.entity.Project;
import com.temelt.issuemanagement.util.TPage;

public interface ProjectService {
	
	ProjectDto save(ProjectDto project);
	
	ProjectDto getById(Long id);
	
	ProjectDto getByProjectCode(String projectCode);
	
	List<ProjectDto> getByProjectCodeContains(String projectCode);
	
	List<ProjectDto> getAll();
	
	TPage<ProjectDto>getAllPageable(Pageable pageable);
	
	Boolean delete(Long id);
}
