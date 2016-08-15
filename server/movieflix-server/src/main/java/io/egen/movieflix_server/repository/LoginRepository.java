package io.egen.movieflix_server.repository;

import java.util.List;

import io.egen.movieflix_server.entity.Login;

public interface LoginRepository {
	public List<Login> findAll();

	public Login findOne(String id);

	public Login findByEmail(String email);
	
	public Login findByUsername(String username);

	public Login create(Login login);

	public Login update(Login login);

	public void delete(Login login);
}
