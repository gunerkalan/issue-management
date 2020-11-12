package com.temelt.issuemanagement.service.impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.temelt.issuemanagement.dto.IssueHistoryDto;
import com.temelt.issuemanagement.entity.Issue;
import com.temelt.issuemanagement.entity.IssueHistory;
import com.temelt.issuemanagement.repository.IssueHistoryRepository;
import com.temelt.issuemanagement.service.IssueHistoryService;
import com.temelt.issuemanagement.util.TPage;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {
    
	private final IssueHistoryRepository issueHistoryRepository;
	private final ModelMapper modelMapper;
	
	public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository, ModelMapper modelMapper) {
	  this.issueHistoryRepository = issueHistoryRepository;
	  this.modelMapper = modelMapper;
	}

	@Override
	public IssueHistoryDto save(IssueHistoryDto issueHistory) {
		IssueHistory ih = modelMapper.map(issueHistory, IssueHistory.class);
		ih = issueHistoryRepository.save(ih);
		issueHistory.setId(ih.getId());
		return issueHistory;
	}

	@Override
	public IssueHistoryDto getById(Long id) {
		IssueHistory ih = issueHistoryRepository.getOne(id);
		return modelMapper.map(ih, IssueHistoryDto.class);
	}

	@Override
	public List<IssueHistoryDto> getByIssueId(Long id) {
		return Arrays.asList(modelMapper.map(issueHistoryRepository.getByIssueIdOrderById(id), IssueHistoryDto[].class));
		
	}

	@Override
	public TPage<IssueHistoryDto> getAllPageable(Pageable pageable) {
		Page<IssueHistory> data = issueHistoryRepository.findAll(pageable);
		TPage<IssueHistoryDto> response = new TPage<IssueHistoryDto>();
		response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), IssueHistoryDto[].class)));
		return response;
	}

	@Override
	public Boolean delete(Long id) {
		issueHistoryRepository.deleteById(id);
		return Boolean.TRUE;
	}

	@Override
	public void addHistory(Long id, Issue issue) {
		// TODO Auto-generated method stub
		
	}
	
	
}
