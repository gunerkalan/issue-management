package com.temelt.issuemanagement.dto;

import java.util.Date;

import com.temelt.issuemanagement.entity.Issue;
import com.temelt.issuemanagement.entity.IssueStatus;
import com.temelt.issuemanagement.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueHistoryDto {
	private Long id;
	private Issue issue;
	private String description;
	private Date date;
	private IssueStatus issueStatus;
	private String details;
	private User assignee;
}
