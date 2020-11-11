package com.temelt.issuemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temelt.issuemanagement.entity.Issue;
import com.temelt.issuemanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

}
