package com.graceshop.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.graceshop.Dto.ProductDto;
import com.graceshop.Entity.Product;
import com.graceshop.Repository.ProductRepository;
import com.graceshop.Service.ProductService;

public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	ModelMapper mapper;

	@Override
	public ProductDto createProduct(ProductDto productDto) {
		Product product =mapper.map(productDto, Product.class);
		String productId = UUID.randomUUID().toString();
		product.setProductId(productId);
		product.setAddedDate(new Date());
		Product saveProduct = productRepository.save(product);
		return mapper.map(saveProduct, ProductDto.class);
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto, String productId) {
		Product product = productRepository.findById(productId)
				.orElseThrow(()-> new RuntimeException("product not found with given ID"));
		product.setDescription(productDto.getDescription());
		product.setDiscountedPrice(productDto.getDiscountedPrice());
		product.setTitle(productDto.getTitle());
		product.setPrice(productDto.getPrice());
		product.setQuantity(productDto.getQuantity());
		product.setLive(productDto.isLive());
		product.setStock(productDto.isStock());
		Product updatedProduct = productRepository.save(product);
		return mapper.map(updatedProduct, ProductDto.class);
	}

	@Override
	public void delete(String productId) {
		Product product = productRepository.findById(productId)
				.orElseThrow(()-> new RuntimeException("product not found with given id"));
		productRepository.delete(product);
	}

	@Override
	public ProductDto getSingleProduct(String productId) {
	Product product = productRepository.findById(productId)
    .orElseThrow(()-> new RuntimeException("product not found with given ID"));
			return mapper.map(product, ProductDto.class);
	}

	@Override
	public List<ProductDto> getAll() {
		
		return null;
	}

	@Override
	public List<ProductDto> getLive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> searchByTitle(String subTitle) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	private ProductDto entityToDto(Product product) {
//		ProductDto productDto = new ProductDto();
//		productDto.setAddedDate(product.getAddedDate());
//		productDto.setDescription(product.getDescription());
//		productDto.setDiscountedPrice(product.getDiscountedPrice());
//		productDto.setPrice(product.getPrice());
//		productDto.setProductId(product.getProductId());
//		productDto.setQuantity(product.getQuantity());
//		productDto.setTitle(product.getTitle());
//		return productDto;
//	
//	}
//	private Product dtoToEntity(ProductDto productDto) {
//		Product product = new Product();
//		product.setTitle(productDto.getTitle());
//		product.setQuantity(productDto.getQuantity());
//		product.setProductId(productDto.getProductId());
//		product.setPrice(productDto.getPrice());
//		product.setDiscountedPrice(productDto.getDiscountedPrice());
//		product.setDescription(productDto.getDescription());
//		product.setAddedDate(productDto.getAddedDate());
//		return product;
//	}

}
