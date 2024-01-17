package com.graceshop.Service;

import java.util.List;

import com.graceshop.Dto.ProductDto;

public interface ProductService {

	//create
	ProductDto createProduct(ProductDto productDto);
	
	//update
	ProductDto updateProduct(ProductDto productDto,String productId);
	
	//delete
	void delete(String productId);
	
	//getSingle
	ProductDto getSingleProduct(String productId);
	
	//getAll
	List<ProductDto> getAll();
	
	//get All:live
	List<ProductDto> getLive();
	
	//search product
	List<ProductDto> searchByTitle(String subTitle);
}
