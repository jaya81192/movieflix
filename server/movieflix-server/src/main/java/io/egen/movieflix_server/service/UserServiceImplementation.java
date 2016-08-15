package io.egen.movieflix_server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix_server.entity.User;
import io.egen.movieflix_server.exception.AlreadyExistsException;
import io.egen.movieflix_server.exception.NotFoundException;
import io.egen.movieflix_server.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	UserRepository repository;

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findOne(String id) {
		User existing = repository.findOne(id);
		if (existing == null) {
			throw new NotFoundException("User with id:" + id + " not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public User create(User user) {
		User existing = repository.findByEmail(user.getEmail());
		if (existing != null) {
			throw new AlreadyExistsException("Email is already in use: " + user.getEmail());
		}
		return repository.create(user);
	}

	@Override
	@Transactional
	public User update(String id, User user) {
		User existing = repository.findOne(id);
		if (existing == null) {
			throw new NotFoundException("User with id:" + id + " not found");
		}
		return repository.update(user);
	}

	@Override
	@Transactional
	public void delete(String id) {
		User existing = repository.findOne(id);
		if (existing == null) {
			throw new NotFoundException("User with id:" + id + " not found");
		}
		repository.delete(existing);
	}
}
