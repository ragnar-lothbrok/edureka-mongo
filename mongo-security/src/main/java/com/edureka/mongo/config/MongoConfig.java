package com.edureka.mongo.config;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

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
import com.mongodb.MongoCredential;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

@Configuration
@EnableMongoRepositories(basePackages = { "com.taskmanager.common.db.model" })
public class MongoConfig extends AbstractMongoConfiguration {

	@Value("${mongo.db.name:grocery_index}")
	private String dbName;

	@Value("${mongo.db.hosts}")
	private String dbHost;

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
		MongoClient mongoClient = null;
		List<ServerAddress> nodes = new ArrayList<ServerAddress>();
		try {
			if (dbHost != null && dbHost.trim().length() > 0) {
				String split[] = dbHost.trim().split(",");
				for (String node : split) {
					nodes.add(new ServerAddress(node.split(":")[0], Integer.parseInt(node.split(":")[1])));
				}
			}

			List<MongoCredential> credentials = new ArrayList<MongoCredential>();
			credentials.add(MongoCredential.createCredential(dbUsername, dbName, dbPassword.toCharArray()));

			mongoClient = new MongoClient(nodes, credentials);
			mongoClient.setReadPreference(ReadPreference.secondaryPreferred());
			mongoClient.setWriteConcern(WriteConcern.JOURNALED);
		} catch (NumberFormatException | UnknownHostException e) {
			logger.error("Couldn't connect mongo db host. Exception [" + e.getMessage() + "]");
			System.exit(-1);
		} catch (Exception e) {
			logger.error("Couldn't connect mongo db host. Exception [" + e.getMessage() + "]");
			System.exit(-1);
		}
		return mongoClient;
	}

	public MongoOperations mongoTemplate(@Qualifier("mongo") Mongo mongo) {
		return new MongoTemplate(mongo, getDatabaseName());
	}

}
