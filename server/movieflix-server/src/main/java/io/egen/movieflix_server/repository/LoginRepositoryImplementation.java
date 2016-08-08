package io.egen.movieflix_server.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix_server.entity.Login;

@Repository
public class LoginRepositoryImplementation implements LoginRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Login> findAll() {
		TypedQuery<Login> query = em.createNamedQuery("Login.findAll", Login.class);
		return query.getResultList();
	}

	@Override
	public Login findOne(String id) {
		return em.find(Login.class, id);
	}

	@Override
	public Login findByEmail(String email) {
		TypedQuery<Login> query = em.createNamedQuery("Login.findByEmail", Login.class);
		query.setParameter("pEmail", email);
		List<Login> login = query.getResultList();
		if (login != null && login.size() == 1) {
			return login.get(0);
		}
		return null;
	}

	@Override
	public Login create(Login login) {
		em.persist(login);
		return login;
	}

	@Override
	public Login update(Login login) {
		return em.merge(login);
	}

	@Override
	public void delete(Login login) {
		em.remove(login);
	}
}
