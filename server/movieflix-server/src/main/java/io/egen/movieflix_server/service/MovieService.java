package io.egen.movieflix_server.service;

import java.util.List;

import io.egen.movieflix_server.entity.Movie;

public interface MovieService {

	public List<Movie> findAll();

	public Movie findOne(String id);

	public Movie create(Movie user);

	public Movie update(String id, Movie user);

	public void delete(String id);
}
