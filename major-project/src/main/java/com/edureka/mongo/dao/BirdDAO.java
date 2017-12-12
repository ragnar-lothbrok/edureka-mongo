package com.edureka.mongo.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.edureka.mongo.model.Bird;
import com.edureka.mongo.utility.PageSupportor;

/**
 * Class will communicate with database.
 * 
 */

@Service
public class BirdDAO {

	private static final Logger logger = LoggerFactory.getLogger(BirdDAO.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * Method will return all Birds present in database
	 * 
	 * @return PageSupportor<Bird>
	 */
	public PageSupportor<Bird> getBirds() {
		logger.info("fetching all birds");
		PageSupportor<Bird> pageSupportor = new PageSupportor<Bird>();
		List<Bird> birdList = null;
		try {
			birdList = mongoTemplate.findAll(Bird.class);
			pageSupportor.setItems(birdList);
			pageSupportor.setStartIndex(0);
			pageSupportor.setTotalRecords((birdList == null ? 0 : birdList.size()));
			pageSupportor.setEndIndex((birdList == null ? 0 : birdList.size() - 1));
			logger.info("All bird fetched : " + pageSupportor);
		} catch (Exception exception) {
			logger.error("Exception occured while fetching all birds : " + exception.getMessage());
			pageSupportor.getErrors().add("Error occured while fetching Birds.");
		}
		return pageSupportor;
	}

	/**
	 * Method will return Bird for a Given Bird Id
	 * 
	 * @param birdId
	 * @return PageSupportor<Bird>
	 */
	public PageSupportor<Bird> getBirdById(String birdId) {
		logger.info("fetching bird : " + birdId);
		Bird bird = null;
		PageSupportor<Bird> pageSupportor = new PageSupportor<Bird>();
		try {
			Query searchUserQuery = new Query(Criteria.where("id").is(birdId));
			bird = mongoTemplate.findOne(searchUserQuery, Bird.class);
			if (bird != null) {
				List<Bird> birdList = new ArrayList<Bird>();
				birdList.add(bird);
				pageSupportor.setItems(birdList);
				pageSupportor.setStartIndex(0);
				pageSupportor.setTotalRecords((bird == null ? 0 : 1));
				pageSupportor.setEndIndex(0);
			} else {
				pageSupportor.getErrors().add("No Bird found for Id :" + birdId);
			}
			logger.info("bird fetched : " + pageSupportor);
		} catch (Exception exception) {
			logger.error("Exception occured while fetching bird : " + birdId + " " + exception.getMessage());
			pageSupportor.getErrors().add("Error occured while fetching Bird with id : " + birdId);
		}
		return pageSupportor;
	}

	/**
	 * Method will save Bird and return Bird with Id.
	 * 
	 * @param bird
	 * @return Bird
	 */
	public PageSupportor<Bird> saveBird(Bird bird) {
		logger.info("Saving bird : " + bird);
		PageSupportor<Bird> pageSupportor = new PageSupportor<Bird>();
		if (bird != null && bird.getName() != null && bird.getName().length() > 0 && bird.getAge() != null) {
			try {
				bird.setId(null);
				Query searchUserQuery = new Query(Criteria.where("name").is(bird.getName()));
				if (mongoTemplate.findOne(searchUserQuery, Bird.class) == null) {
					mongoTemplate.save(bird);
					if (bird != null) {
						List<Bird> birdList = new ArrayList<Bird>();
						birdList.add(bird);
						pageSupportor.setItems(birdList);
						pageSupportor.setStartIndex(0);
						pageSupportor.setTotalRecords((bird == null ? 0 : 1));
						pageSupportor.setEndIndex(0);
					}
				} else {
					pageSupportor.getErrors().add("Name you provided already exists.");
				}
			} catch (Exception exception) {
				logger.error("Exception occured while saving bird : " + exception.getMessage());
				pageSupportor.getErrors().add("Error occured while saving Bird");
			}
		} else {
			pageSupportor.getErrors().add("Please provide valid bird details.");
		}
		logger.info("Bird status : " + pageSupportor);
		return pageSupportor;
	}

	/**
	 * Method will delete the bird if it is present in database.
	 * 
	 * @param birdId
	 * @return
	 */
	public int deleteBird(String birdId) {
		logger.info("deleting bird : " + birdId);
		try {
			if (getBirdById(birdId).getItems() != null && getBirdById(birdId).getItems().size() > 0) {
				Query searchUserQuery = new Query(Criteria.where("id").is(birdId));
				mongoTemplate.remove(searchUserQuery, Bird.class);
				logger.info("bird deleted : " + birdId);
				return 1;
			} else {
				return -1;
			}
		} catch (Exception exception) {
			logger.error("Exception occured while deleting bird : " + exception.getMessage());
		}
		return -1;
	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

}
