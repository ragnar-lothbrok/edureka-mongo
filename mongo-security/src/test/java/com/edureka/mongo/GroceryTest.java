package com.edureka.mongo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.edureka.mongo.api.services.ProductService;
import com.edureka.mongo.common.db.model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = GroceryApp.class, loader = SpringApplicationContextLoader.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class GroceryTest {

	@Autowired
	private ProductService productService;

	@Test
	public void save() {
		try {
			List<String> brands = new ArrayList<String>();
			File f = new File("/Users/raghugupta/Documents/Mongo/products.csv");
			BufferedReader b = new BufferedReader(new FileReader(f));
			String readLine = "";
			System.out.println("Reading file using Buffered Reader");
			readLine = b.readLine();
			while ((readLine = b.readLine()) != null) {
				String split[] = readLine.split(",");
				if (!brands.contains(split[2])) {
					productService.save(new Product(Long.parseLong(split[0]), split[1], split[2], split[3], split[4],
							split[5], split[6], Float.parseFloat(split[7]), Long.parseLong(split[8]), split[9],
							split[10], split[11]));
					brands.add(split[2]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	@Test
	public void getByBrand() {
		List<Product> product = productService.getProductsByBrand("Advice");
		Assert.assertEquals(true, product.size() > 0);
	}

	// @Test
	public void getByCategory() {
		List<Product> product = productService.getProductsByCategory("FOOTWEAR");
		Assert.assertEquals(true, product.size() > 0);
	}
}
