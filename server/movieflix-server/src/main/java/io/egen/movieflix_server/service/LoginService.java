package io.egen.movieflix_server.service;

import java.util.List;

import io.egen.movieflix_server.entity.Login;

public interface LoginService {
	public List<Login> findAll();

	public Login findOne(String id);

	public Login create(Login login);

	public Login update(String id, Login login);

	public void delete(String id);
}
