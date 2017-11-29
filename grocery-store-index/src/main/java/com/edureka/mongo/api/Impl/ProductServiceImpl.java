package com.edureka.mongo.api.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edureka.mongo.api.services.ProductService;
import com.edureka.mongo.common.db.model.Product;
import com.edureka.mongo.db.services.CommonService;

@Service
public class ProductServiceImpl implements ProductService {

	final static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private CommonService commonService;

	@Override
	public Product save(Product product) {
		commonService.save(product);
		return product;
	}

	@Override
	public Product get(String id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		Product product = commonService.findOne(paramMap, Product.class);
		return product;
	}

	@Override
	public Product update(Product product) {
		commonService.save(product);
		return product;
	}

	@Override
	public Boolean delete(String id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		Boolean deleted = commonService.deleteOne(paramMap, Product.class);
		return deleted;
	}

	@Override
	public List<Product> getProductsByBrand(String brand) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("brand", brand);
		return commonService.findAll(paramMap, Product.class).get();
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("category", category);
		return commonService.findAll(paramMap, Product.class).get();
	}

}
