package com.flocondria.fridge.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flocondria.fridge.domain.Product;
import com.flocondria.fridge.web.request.ProductManagerRequest;
import com.flocondria.fridge.web.service.ProductManagerService;


@RestController
@RequestMapping(path="addProduct")
public class ProductController {
	
	
	 @Autowired
	private ProductManagerService productManagerService;
	
	//Create product
	@RequestMapping(method= RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody ProductManagerRequest request){
		
		productManagerService.createProduct(request);
	}
	
/*	//Update Product quantity when user 
	@RequestMapping(method = RequestMethod.PATCH)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateProduct(@RequestBody ProductManagerRequest request) {
		productManagerService.updateProductQuantity(request);
	}
	
	//Delete Product
	@RequestMapping(method= RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void removeProduct(@RequestBody Product product){
		
		System.out.println(product);
	}
	
	//Find Product by id
	@RequestMapping(method= RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void findProductbyId(@RequestBody Product product){
		
		System.out.println(product);
	}
	*/
	
}
