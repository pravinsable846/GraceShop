package com.graceshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graceshop.Dto.ApiResponseMsg;
import com.graceshop.Dto.CategoryDto;
import com.graceshop.Service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto categoryDto){
		CategoryDto categoryDto1 = categoryService.create(categoryDto);
		return new ResponseEntity<>(categoryDto1,HttpStatus.CREATED);
	}
	
	@PatchMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> update(@PathVariable String categoryId
			,@RequestBody CategoryDto categoryDto){
		CategoryDto categoryDto1 = categoryService.update(categoryDto, categoryId);
		return new ResponseEntity<>(categoryDto1,HttpStatus.OK);
	}
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponseMsg> delete(@PathVariable String categoryId){
		categoryService.delete(categoryId);
		ApiResponseMsg message = ApiResponseMsg.builder()
				.message("category deleted successfully with given ID:"+categoryId)
				.success(true)
				.status(HttpStatus.OK)
				.build();
		return new ResponseEntity<>(message,HttpStatus.OK);
				
	}
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getById(@PathVariable String categoryId){
		CategoryDto categoryDto = categoryService.getSingleCategory(categoryId);
		return new ResponseEntity<>(categoryDto,HttpStatus.OK);
	}
}
