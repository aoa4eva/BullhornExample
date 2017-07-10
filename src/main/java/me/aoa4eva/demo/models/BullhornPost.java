package me.aoa4eva.demo.models;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity 
public class BullhornPost {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id; 
	
	@NotEmpty
	private String message; 
	

	@Temporal(TemporalType.TIMESTAMP)
	private Date xtime;
	
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "userid")
	 private User bhUser;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the xtime
	 */
	public Date getXtime() {
		return xtime;
	}

	/**
	 * @param xtime the xtime to set
	 */
	public void setXtime(Date xtime) {
		this.xtime = xtime;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the bhUser
	 */
	public User getBhUser() {
		return bhUser;
	}

	/**
	 * @param bhUser the bhUser to set
	 */
	public void setBhUser(User bhUser) {
		this.bhUser = bhUser;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BullhornPost [id=" + id + ", message=" + message + ", xtime=" + xtime + ", bhUser=" + bhUser
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	/**
	 * @return the user
	 */
	
}
