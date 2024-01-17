package com.graceshop.Dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private String categoryId;
	@NotBlank
	@Min(value=4,message="title must be of 4 characters !!")
	private String title;
	@NotBlank(message="description is required")
	private String description;
	private String coverImage;
	
}
