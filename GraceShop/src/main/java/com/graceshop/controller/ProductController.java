package com.graceshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graceshop.Dto.ApiResponseMsg;
import com.graceshop.Dto.ProductDto;
import com.graceshop.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	@PostMapping()
	public ResponseEntity<ProductDto> Create(@RequestBody ProductDto productDto){
		ProductDto productDto1 = productService.createProduct(productDto);
		return new ResponseEntity<>(productDto1,HttpStatus.CREATED);
	}
	
	@PatchMapping("{/productId}")
	public ResponseEntity<ProductDto>update(@PathVariable String productId
			,@RequestBody ProductDto productDto){
		ProductDto productDto1 = productService.updateProduct(productDto, productId);
		return new ResponseEntity<>(productDto1,HttpStatus.OK);
		
	}
	
	@DeleteMapping("{/productId}")
	public ResponseEntity<ApiResponseMsg> delete(@PathVariable String productId){
		productService.delete(productId);
		ApiResponseMsg message = ApiResponseMsg.builder()
				.message("Product deleted successfully with given Id")
				.status(HttpStatus.OK)
				.success(true)
				.build();
		return new ResponseEntity<>(message,HttpStatus.OK);
	}
}
