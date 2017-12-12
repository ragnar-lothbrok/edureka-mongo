package com.edureka.mongo.api;

import org.springframework.http.ResponseEntity;

import com.edureka.mongo.model.Bird;
import com.edureka.mongo.utility.PageSupportor;

@SuppressWarnings("rawtypes")
public interface BirdService {

	public ResponseEntity getBirdsById(String birdId);

	public PageSupportor<Bird> getAllBirds();

	public ResponseEntity saveBird(Bird bird);

	public ResponseEntity deleteBirdsById(String birdId);
}
