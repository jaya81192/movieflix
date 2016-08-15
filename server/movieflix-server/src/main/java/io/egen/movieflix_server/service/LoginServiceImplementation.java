package io.egen.movieflix_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix_server.entity.Login;
import io.egen.movieflix_server.exception.AlreadyExistsException;
import io.egen.movieflix_server.exception.NotFoundException;
import io.egen.movieflix_server.repository.LoginRepository;

@Service
public class LoginServiceImplementation implements LoginService {
	@Autowired
	LoginRepository repository;

	@Override
	public List<Login> findAll() {
		return repository.findAll();
	}

	@Override
	public Login findOne(String id) {
		Login existing = repository.findOne(id);
		if (existing == null) {
			throw new NotFoundException("Login with id:" + id + " not found");
		}
		return existing;
	}
	
	@Override
	public Login findOneByUsername(String username) {
		Login existing = repository.findByUsername(username);
		if (existing == null) {
			throw new NotFoundException("Login with username:" + username + " not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public Login create(Login login) {
		Login existing = repository.findByEmail(login.getUser().getEmail());
		if (existing != null) {
			throw new AlreadyExistsException("Email is already in use: " + login.getUser().getEmail());
		}
		return repository.create(login);
	}

	@Override
	@Transactional
	public Login update(String id, Login login) {
		Login existing = repository.findOne(id);
		if (existing == null) {
			throw new NotFoundException("Login with id:" + id + " not found");
		}
		return repository.update(login);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Login existing = repository.findOne(id);
		if (existing == null) {
			throw new NotFoundException("Login with id:" + id + " not found");
		}
		repository.delete(existing);
	}

	@Override
	public Login findOneByEmail(String email) {
		Login existing = repository.findByEmail(email);
		if (existing == null) {
			throw new NotFoundException("Login with email:" + email + " not found");
		}
		return existing;
	}
}
