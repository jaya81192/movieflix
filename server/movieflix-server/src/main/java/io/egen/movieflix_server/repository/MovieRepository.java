package io.egen.movieflix_server.repository;

import java.util.List;
import io.egen.movieflix_server.entity.Movie;

public interface MovieRepository {
	
	public List<Movie> findAll();

	public Movie findOne(String id);

	public Movie findByTitle(String title);

	public Movie create(Movie Movie);

	public Movie update(Movie Movie);

	public void delete(Movie Movie);
	
}

