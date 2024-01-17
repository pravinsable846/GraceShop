package com.graceshop.Service;

import org.springframework.stereotype.Service;

import com.graceshop.Dto.CategoryDto;
import com.graceshop.Dto.PageableResponse;

public interface CategoryService {

	CategoryDto create (CategoryDto categoryDto);
	
	CategoryDto update(CategoryDto categoryDto,String categoryId);
	
	void delete(String categoryId);
	
	PageableResponse<CategoryDto>getAll(int pageNumber,int pageSize,String sortBy,String sortDir);
	
	CategoryDto getSingleCategory(String categoryId);
	
	
}
