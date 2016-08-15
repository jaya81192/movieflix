package io.egen.movieflix_server.repository;

import java.util.List;

import io.egen.movieflix_server.entity.UserRatings;

public interface UserRatingsRepository {

	public List<UserRatings> findAll();

	public UserRatings findOne(String id);

	public UserRatings findByIdPair(String userId, String movieId);

	public UserRatings create(UserRatings userRating);

	public UserRatings update(UserRatings userRating);

	public void delete(UserRatings userRating);

}
