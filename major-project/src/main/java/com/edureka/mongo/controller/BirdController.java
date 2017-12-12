package com.edureka.mongo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edureka.mongo.api.BirdService;
import com.edureka.mongo.model.Bird;
import com.edureka.mongo.utility.PageSupportor;

@RestController
@SuppressWarnings("rawtypes")
public class BirdController {

	private final static Logger logger = LoggerFactory.getLogger(BirdController.class);

	@Autowired
	private BirdService birdService;

	@RequestMapping(value = "/birds/{id}", method = RequestMethod.GET)
	public ResponseEntity getBirdsById(@PathVariable("id") String id) {
		logger.info("inside getBirdsById");
		return birdService.getBirdsById(id);
	}

	@RequestMapping(value = "/birds", method = RequestMethod.POST)
	public ResponseEntity saveBird(@RequestBody Bird bird) {
		logger.info("inside saveBird");
		return birdService.saveBird(bird);
	}

	@RequestMapping(value = "/birds", method = RequestMethod.GET)
	public PageSupportor<Bird> getAllBirds() {
		logger.info("inside getAllBirds");
		return birdService.getAllBirds();
	}

	@RequestMapping(value = "/birds/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteAddons(@PathVariable("id") String id) {
		logger.info("inside deleteAddons");
		return birdService.deleteBirdsById(id);
	}

}
