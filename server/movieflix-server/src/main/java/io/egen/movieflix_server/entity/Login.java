package io.egen.movieflix_server.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({ 
		@NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l ORDER BY l.user.email ASC"),
		@NamedQuery(name = "Login.findByEmail", query = "SELECT l FROM Login l WHERE l.user.email=:pEmail") 
})
public class Login {
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	
	@OneToOne
	private User user;
	
	private String password;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
