package me.aoa4eva.demo.models;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}
