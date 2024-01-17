package com.graceshop.ServiceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.graceshop.Dto.CategoryDto;
import com.graceshop.Dto.PageableResponse;
import com.graceshop.Entity.Category;
import com.graceshop.Repository.CategoryRepository;
import com.graceshop.Service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public CategoryDto create(CategoryDto categoryDto) {
	String Category = UUID.randomUUID().toString();
	categoryDto.setCategoryId(Category);
	Category category2 = dtoToEntity(categoryDto);
	Category saveCategory = categoryRepository.save(category2);
	CategoryDto categoryDto2 = entityToDto(saveCategory);
		return categoryDto2;
	}

	@Override
	public CategoryDto update(CategoryDto categoryDto, String categoryId) {
		Category category = categoryRepository.findById(categoryId).orElseThrow(()->new RuntimeException("Category not found with given id"));
		category.setTitle(categoryDto.getTitle());
		category.setDescription(categoryDto.getDescription());
		Category newCategory = categoryRepository.save(category);
		CategoryDto updatedDto = entityToDto(newCategory);
		return updatedDto;
	}

	@Override
	public void delete(String categoryId) {
		Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new RuntimeException("category not found with given id"));
		categoryRepository.delete(category);
	}

	@Override
	public PageableResponse<CategoryDto> getAll(int pageSize,int pageNumber,String sortBy,String sortDir) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		
		Page<Category> page = categoryRepository.findAll(pageable);
		
		return null;
	}

	@Override
	public CategoryDto getSingleCategory(String categoryId) {
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(()-> new RuntimeException("category not found with given id"));
		return entityToDto(category);
	}

	private CategoryDto entityToDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
	    categoryDto.setCategoryId(category.getCategoryId());
	    categoryDto.setTitle(category.getTitle());
	    categoryDto.setDescription(category.getDescription());
	    categoryDto.setCoverImage(category.getCoverImage());
	    return categoryDto;
		
	}
	private Category dtoToEntity(CategoryDto categoryDto) {
		Category category = new Category();
		category.setCategoryId(categoryDto.getCategoryId());
		category.setTitle(categoryDto.getTitle());
		category.setCoverImage(categoryDto.getCoverImage());
		category.setDescription(categoryDto.getDescription());
		return category;
	}
  
}
