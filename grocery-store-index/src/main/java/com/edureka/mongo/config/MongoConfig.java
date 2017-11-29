package com.edureka.mongo.config;

import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = { "com.taskmanager.common.db.model" })
public class MongoConfig extends AbstractMongoConfiguration {

	@Value("${mongo.db.name:grocery_index}")
	private String dbName;

	@Value("${mongo.db.host:localhost}")
	private String dbHost;

	@Value("${mongo.db.port:27017}")
	private String dbPort;

	@Value("${mongo.db.username:}")
	private String dbUsername;

	@Value("${mongo.db.password:}")
	private String dbPassword;

	Logger logger = LoggerFactory.getLogger(MongoConfig.class);

	@Override
	protected String getDatabaseName() {
		return dbName;
	}

	@Override
	@Bean(name = "mongo")
	public Mongo mongo() {
		try {
			return new MongoClient(dbHost + ":" + dbPort);
		} catch (NumberFormatException | UnknownHostException e) {
			logger.error("Couldn't connect mongo db host. Exception [" + e.getMessage() + "]");
			System.exit(-1);
		} catch (Exception e) {
			logger.error("Couldn't connect mongo db host. Exception [" + e.getMessage() + "]");
			System.exit(-1);
		}
		return null;
	}

	public MongoOperations mongoTemplate(@Qualifier("mongo") Mongo mongo) {
		return new MongoTemplate(mongo, getDatabaseName());
	}

}
