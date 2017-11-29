package com.edureka.mongo.api.services;

import java.util.List;

import com.edureka.mongo.common.db.model.Product;

public interface ProductService {

	Product save(Product product);

	Product get(String pogId);

	Product update(Product product);

	Boolean delete(String pogId);

	List<Product> getProductsByBrand(String brand);

	List<Product> getProductsByCategory(String category);

}
