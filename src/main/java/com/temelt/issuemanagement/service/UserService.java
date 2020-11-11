package com.temelt.issuemanagement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.temelt.issuemanagement.dto.UserDto;
import com.temelt.issuemanagement.entity.User;
import com.temelt.issuemanagement.util.TPage;

public interface UserService {
	
	UserDto save(UserDto user);
	
	UserDto getById(Long id);
	
	TPage<UserDto>getAllPageable(Pageable pageable);
    
	UserDto getByUsername(String username);
	
	List<UserDto> getAll();
}
