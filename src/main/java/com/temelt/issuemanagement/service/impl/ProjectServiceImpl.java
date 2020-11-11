package com.temelt.issuemanagement.service.impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.temelt.issuemanagement.dto.ProjectDto;
import com.temelt.issuemanagement.entity.Project;
import com.temelt.issuemanagement.entity.User;
import com.temelt.issuemanagement.repository.ProjectRepository;
import com.temelt.issuemanagement.repository.UserRepository;
import com.temelt.issuemanagement.service.ProjectService;
import com.temelt.issuemanagement.util.TPage;

public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepository projectRepository;
	private final ModelMapper modelMapper;
	private final UserRepository userRepository;
	
	public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper, UserRepository userRepository) {
		this.projectRepository = projectRepository;
		this.modelMapper = modelMapper;
		this.userRepository = userRepository;
	}

	@Override
	public ProjectDto save(ProjectDto project) {
		Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
		
		if(projectCheck != null) {
			throw new IllegalArgumentException("Project Code Already Exist");
		}
		
		Project prj = modelMapper.map(project, Project.class);
		User user = userRepository.getOne(project.getManagerId());
		prj.setManager(user);
		
		prj = projectRepository.save(prj);
		project.setId(prj.getId());
		return project;
		
	}

	@Override
	public ProjectDto getById(Long id) {
		Project prj = projectRepository.getOne(id);
		return modelMapper.map(prj, ProjectDto.class);
	}

	@Override
	public ProjectDto getByProjectCode(String projectCode) {
		Project prj = projectRepository.getByProjectCode(projectCode);
		return modelMapper.map(prj, ProjectDto.class);
	}

	@Override
	public List<ProjectDto> getByProjectCodeContains(String projectCode) {
		List<Project> data = projectRepository.getByProjectCodeContains(projectCode);
		return Arrays.asList(modelMapper.map(data, ProjectDto.class));
	}

	@Override
	public TPage<ProjectDto> getAllPageable(Pageable pageable) {
		Page<Project> data = projectRepository.findAll(pageable);
		TPage<ProjectDto> response = new TPage<ProjectDto>();
		response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
		return response;
	}

	@Override
	public Boolean delete(Long id) {
		projectRepository.deleteById(id);
		return Boolean.TRUE;
	}

	@Override
	public List<ProjectDto> getAll() {
		List<Project> data = projectRepository.findAll();
		return Arrays.asList(modelMapper.map(data, ProjectDto[].class));
	}
		

}
