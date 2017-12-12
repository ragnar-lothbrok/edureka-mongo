package com.edureka.mongo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edureka.mongo.api.BirdService;
import com.edureka.mongo.dao.BirdDAO;
import com.edureka.mongo.model.Bird;
import com.edureka.mongo.utility.PageSupportor;

@Service
public class BirdServiceImpl implements BirdService{

	private static final Logger logger = LoggerFactory.getLogger(BirdServiceImpl.class);

	@Autowired
	private BirdDAO birdDAO;

	/**
	 * Method will return Bird for a Given Bird Id
	 * 
	 * @param birdId
	 * @return Bird
	 */

	@SuppressWarnings("rawtypes")
	public ResponseEntity getBirdsById(String birdId) {
		logger.info("getBirdsById");
		PageSupportor<Bird> ps = birdDAO.getBirdById(birdId);
		if (ps.getErrors().size() > 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.ok(ps);
		}
	}

	/**
	 * Method will return all Birds present in database
	 * 
	 * @return List<Bird>
	 */

	public PageSupportor<Bird> getAllBirds() {
		return birdDAO.getBirds();
	}

	/**
	 * Method will save Bird and return Bird with Id.
	 * 
	 * @param bird
	 * @return Bird
	 */

	@SuppressWarnings("rawtypes")
	public ResponseEntity saveBird(Bird bird) {
		PageSupportor<Bird> ps = birdDAO.saveBird(bird);
		if (ps.getErrors().size() > 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(ps);
		}
	}

	/**
	 * Method will delete the bird if it is present in database.
	 * 
	 * @param birdId
	 * @return
	 */

	@SuppressWarnings("rawtypes")
	public ResponseEntity deleteBirdsById(String birdId) {
		int deleted = birdDAO.deleteBird(birdId);
		if (deleted == -1) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().build();
		}
	}

}
