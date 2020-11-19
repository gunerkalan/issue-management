package com.temelt.issuemanagement.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.temelt.issuemanagement.dto.ProjectDto;
import com.temelt.issuemanagement.service.impl.ProjectServiceImpl;
import com.temelt.issuemanagement.util.ApiPaths;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api(value = ApiPaths.ProjectCtrl.CTRL, description = "Project APIs")
@Slf4j
public class ProjectController {
     
	private final ProjectServiceImpl projectServiceImpl;
	
	public ProjectController(ProjectServiceImpl projectServiceImpl) {
		this.projectServiceImpl = projectServiceImpl;
		
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Get By Id Operation", response = ProjectDto.class)
	public ResponseEntity<ProjectDto> getById(@PathVariable(value="id", required = true) Long id){
	    log.info("ProjectController-> GetByID ");
	    log.debug("ProjectController-> GetByID -> PARAM:" + id);
	    ProjectDto projectDto = projectServiceImpl.getById(id);
	    return ResponseEntity.ok(projectDto);
	}
	
	@PostMapping
	@ApiOperation(value = "Create Operation", response = ProjectDto.class)
	public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project){
		return ResponseEntity.ok(projectServiceImpl.save(project));
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Update Operation", response = ProjectDto.class)
	public ResponseEntity<ProjectDto> updateProject(@PathVariable(value="id", required = true) Long id, @Valid @RequestBody ProjectDto project){
		return ResponseEntity.ok(projectServiceImpl.update(id,project));
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete Operation", response = Boolean.class)
	public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id){
		return ResponseEntity.ok(projectServiceImpl.delete(id));
	}
}
