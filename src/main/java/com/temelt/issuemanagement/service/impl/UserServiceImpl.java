package com.temelt.issuemanagement.service.impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.temelt.issuemanagement.dto.UserDto;
import com.temelt.issuemanagement.entity.User;
import com.temelt.issuemanagement.repository.UserRepository;
import com.temelt.issuemanagement.service.UserService;
import com.temelt.issuemanagement.util.TPage;

@Service
public class UserServiceImpl implements UserService {
   
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	
	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public UserDto save(UserDto user) {
		User us = modelMapper.map(user, User.class);
	    us = userRepository.save(us);
		user.setId(us.getId());
		return user;
	}

	@Override
	public UserDto getById(Long id) {
		User us = userRepository.getOne(id);
		return modelMapper.map(us, UserDto.class);
	}

	@Override
	public TPage<UserDto> getAllPageable(Pageable pageable) {
		Page<User> data = userRepository.findAll(pageable);
		TPage<UserDto> response = new TPage<UserDto>();
		response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), UserDto[].class)));
		return response;
	}

	@Override
	public UserDto getByUsername(String username) {
		User us = userRepository.findByUsername(username);
		return modelMapper.map(us, UserDto.class);
	}

	@Override
	public List<UserDto> getAll() {
		List<User> data = userRepository.findAll();
		return Arrays.asList(modelMapper.map(data, UserDto[].class));
	}
	
	
}
