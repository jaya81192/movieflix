package io.egen.movieflix_server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix_server.entity.UserRatings;
import io.egen.movieflix_server.service.UserRatingsService;

@RestController
@RequestMapping(path = "userRatings")
public class UserRatingsController {
	
	@Autowired
	UserRatingsService service;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<UserRatings> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserRatings findOne(@PathVariable("id") String userRatingId) {
		return service.findOne(userRatingId);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserRatings create(@RequestBody UserRatings userRating) {
		return service.create(userRating);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserRatings update(@PathVariable("id") String userRatingId, @RequestBody UserRatings userRating) {
		return service.update(userRatingId, userRating);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	public void delete(@PathVariable("id") String userRatingId) {
		service.delete(userRatingId);
	}
}
