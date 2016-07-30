package io.egen.movieflix_server.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix_server.entity.Movie;
import io.egen.movieflix_server.entity.User;
import io.egen.movieflix_server.entity.UserRatings;
import io.egen.movieflix_server.exception.AlreadyExistsException;
import io.egen.movieflix_server.exception.NotFoundException;
import io.egen.movieflix_server.repository.UserRatingsRepository;

@Service
public class UserRatingsServiceImplementation implements UserRatingsService{

	@Autowired
	UserRatingsRepository repository;

	@Autowired
	MovieService mService;
	
	@Autowired
	UserService uService;
	
	@Override
	public List<UserRatings> findAll() {
		return repository.findAll();
	}

	@Override
	public UserRatings findOne(String id) {
		UserRatings existing = repository.findOne(id);
		if (existing == null) {
			throw new NotFoundException("User Rating with id:" + id + " not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public UserRatings create(UserRatings userRating) {
		String userId = userRating.getUser().getId();
		String movieId = userRating.getMovie().getId();
		UserRatings existing = repository.findByIdPair(userId, movieId);
		System.out.println(userId + " " +  movieId);
		if(existing!=null){
			throw new AlreadyExistsException("User has already rated the movie. UserId:" + userId +", MovieId:"+ movieId);
		}		
		Movie movie = mService.findOne(movieId);
		User user = uService.findOne(userId);
		userRating.setMovie(movie);
		userRating.setUser(user);
		return repository.create(userRating);
	}

	@Override
	@Transactional
	public UserRatings update(String id, UserRatings userRating) {
		UserRatings existing = repository.findOne(id);
		if (existing == null) {
			throw new NotFoundException("User Rating with id:" + id + " not found");
		}
		return repository.update(userRating);
	}
	
	@Override
	@Transactional
	public void delete(String id) {
		UserRatings existing = repository.findOne(id);
		if (existing == null) {
			throw new NotFoundException("User Rating with id:" + id + " not found");
		}
		repository.delete(existing);
	}
}
		

