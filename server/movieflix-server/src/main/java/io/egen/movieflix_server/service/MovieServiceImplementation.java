package io.egen.movieflix_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix_server.entity.Movie;
import io.egen.movieflix_server.exception.AlreadyExistsException;
import io.egen.movieflix_server.exception.NotFoundException;
import io.egen.movieflix_server.repository.MovieRepository;

@Service
public class MovieServiceImplementation implements MovieService {

	@Autowired
	MovieRepository repository;
	
	
	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public Movie findOne(String id) {
		Movie existing = repository.findOne(id);
		if (existing == null) {
			throw new NotFoundException("Movie with id:" + id + " not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public Movie create(Movie movie) {
		Movie existing = repository.findByTitle(movie.getTitle());
		if (existing != null) {
			throw new AlreadyExistsException("Title is already in use: " + movie.getTitle());
		}
		return repository.create(movie);
	}

	@Override
	@Transactional
	public Movie update(String id, Movie movie) {
		Movie existing = repository.findOne(id);
		if (existing == null) {
			throw new NotFoundException("Movie with id:" + id + " not found");
		}
		return repository.update(movie);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Movie existing = repository.findOne(id);
		if (existing == null) {
			throw new NotFoundException("Movie with id:" + id + " not found");
		}
		repository.delete(existing);
	}
}
