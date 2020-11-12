package com.temelt.issuemanagement.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.temelt.issuemanagement.dto.IssueDto;
import com.temelt.issuemanagement.entity.Issue;
import com.temelt.issuemanagement.entity.IssueStatus;
import com.temelt.issuemanagement.repository.IssueRepository;
import com.temelt.issuemanagement.repository.ProjectRepository;
import com.temelt.issuemanagement.repository.UserRepository;
import com.temelt.issuemanagement.service.IssueService;
import com.temelt.issuemanagement.util.TPage;

@Service
public class IssueServiceImpl implements IssueService {

	private final IssueRepository issueRepository;
	private final ModelMapper modelMapper;
	private final UserRepository userRepository;
	private final ProjectRepository projectRepository;
	
	public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper, UserRepository userRepository, ProjectRepository projectRepository) {
		this.issueRepository = issueRepository;
		this.modelMapper = modelMapper;
		this.projectRepository = projectRepository;
		this.userRepository = userRepository;
	}

	@Override
	public IssueDto save(IssueDto issue) {
		
		issue.setDate(new Date());
		issue.setIssueStatus(IssueStatus.OPEN);
		
		Issue issueEntity = modelMapper.map(issue, Issue.class);
		
		issueEntity.setProject(projectRepository.getOne(issue.getProjectId()));
		issueEntity = issueRepository.save(issueEntity);
		
		issue.setId(issueEntity.getId());
		return issue;
	}

	@Override
	public IssueDto getById(Long id) {
		Issue issue = issueRepository.getOne(id);
		return modelMapper.map(issue, IssueDto.class);
	}

	@Override
	public TPage<IssueDto> getAllPageable(Pageable pageable) {
		Page<Issue> data = issueRepository.findAll(pageable);
		TPage<IssueDto> response = new TPage<IssueDto>();
		response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), IssueDto[].class)));
		return response;
	}

	@Override
	public Boolean delete(Long issueId) {
		issueRepository.deleteById(issueId);
		return Boolean.TRUE;
	}

	@Override
	public List<IssueDto> getAll() {
		List<Issue> data = issueRepository.findAll();
		return Arrays.asList(modelMapper.map(data, IssueDto[].class));
	}
		
}
