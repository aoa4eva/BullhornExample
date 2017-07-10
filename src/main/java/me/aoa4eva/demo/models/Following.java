package me.aoa4eva.demo.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity 
public class Following {
	
	@Id
	private long id; 
	
	@ManyToOne
	private User following;  
	
	@ManyToOne 
	private User followed; 
	
	@CreationTimestamp 
	Date startedfollowing;

	/**
	 * @return the following
	 */
	public User getFollowing() {
		return following;
	}

	/**
	 * @param following the following to set
	 */
	public void setFollowing(User following) {
		this.following = following;
	}

	/**
	 * @return the followed
	 */
	public User getFollowed() {
		return followed;
	}

	/**
	 * @param followed the followed to set
	 */
	public void setFollowed(User followed) {
		this.followed = followed;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	} 

}
