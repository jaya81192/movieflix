package io.egen.movieflix_server.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix_server.entity.UserRatings;

@Repository
public class UserRatingsRepositoryImplementation implements UserRatingsRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<UserRatings> findAll() {
		TypedQuery<UserRatings> query = em.createNamedQuery("UserRatings.findAll", UserRatings.class);
		return query.getResultList();
	}

	@Override
	public UserRatings findOne(String id) {
		return em.find(UserRatings.class, id);
	}
	
	@Override
	public UserRatings findByIdPair(String userId, String movieId){
		TypedQuery<UserRatings> query = em.createNamedQuery("UserRatings.findByIds", UserRatings.class);
		query.setParameter("pUserId", userId);
		query.setParameter("pMovieId", movieId);
		List<UserRatings> userRatings= query.getResultList();
		if (userRatings != null && userRatings.size() == 1) {
			return userRatings.get(0);
		}
		return null;
	}

	@Override
	public UserRatings create(UserRatings userRating) {
		em.persist(userRating);
		return userRating;
	}

	@Override
	public UserRatings update(UserRatings userRating) {
		return em.merge(userRating);
	}

	@Override
	public void delete(UserRatings userRating) {
		em.remove(userRating);
	}
}
