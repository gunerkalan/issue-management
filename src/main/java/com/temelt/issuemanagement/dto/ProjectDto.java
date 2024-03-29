package com.temelt.issuemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Project Data Transfer Object")
public class ProjectDto {
	
	@ApiModelProperty(value = "Project ID")
	private Long id;
	
	@NotNull
	@ApiModelProperty(required = true, value = "Name Of Project")
	private String projectName;
	
	@NotNull
	@ApiModelProperty(required = true, value = "Code Of Project")
	private String projectCode;
	
	//private Long managerId;	
	
	//private UserDto manager;
}
