package io.egen.movieflix_server.service;

import java.util.List;

import io.egen.movieflix_server.entity.UserRatings;

public interface UserRatingsService {

	public List<UserRatings> findAll();

	public UserRatings findOne(String id);

	public UserRatings create(UserRatings userRating);

	public UserRatings update(String id, UserRatings userRating);

	public void delete(String id);

	public UserRatings findOneByIdPair(String userid, String movieid);
}
