package com.edureka.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Starting point of task manager application.
 * 
 * @author raghunandan.gupta
 *
 */

@ComponentScan(basePackages = { "com.edureka" })
@EnableAutoConfiguration(exclude = {
		org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class })
public class GroceryApp {

	public static void main(String[] args) {
		SpringApplication.run(GroceryApp.class, args);
	}

}
