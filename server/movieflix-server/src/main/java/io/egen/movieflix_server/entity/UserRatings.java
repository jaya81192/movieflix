package io.egen.movieflix_server.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(uniqueConstraints={
	    @UniqueConstraint(columnNames = {"user_id", "movie_id"})
}) 
@NamedQueries({ 
		@NamedQuery(name = "UserRatings.findAll", query = "SELECT ur FROM UserRatings ur"),
		@NamedQuery(name = "UserRatings.findByIds", query="SELECT ur FROM UserRatings ur WHERE ur.user.id=:pUserId AND ur.movie.id=:pMovieId")
})
public class UserRatings {
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	
	private float rating;
	
	private String comment;
	
	@ManyToOne
	@LazyCollection(LazyCollectionOption.FALSE)
	private User user;
	
	@ManyToOne
	@LazyCollection(LazyCollectionOption.FALSE)
	private Movie movie;
	
	public float getUserRating() {
		return rating;
	}
	public void setUserRating(float userRating) {
		this.rating = userRating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdPair(){
		String idPair = user.getId() + ", " + movie.getId();
		return  idPair;
	}
}