package com.temelt.issuemanagement.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.temelt.issuemanagement.dto.ProjectDto;
import com.temelt.issuemanagement.service.impl.ProjectServiceImpl;

@RestController
@RequestMapping("/project")
public class ProjectController {
     
	private final ProjectServiceImpl projectServiceImpl;
	
	public ProjectController(ProjectServiceImpl projectServiceImpl) {
		this.projectServiceImpl = projectServiceImpl;
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id){
	    ProjectDto projectDto = projectServiceImpl.getById(id);
	    return ResponseEntity.ok(projectDto);
	}
	
	@PostMapping
	public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto project){
		return ResponseEntity.ok(projectServiceImpl.save(project));
	}
}
