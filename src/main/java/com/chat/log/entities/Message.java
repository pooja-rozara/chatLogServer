package com.chat.log.entities;

import java.security.Identity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/*
	 * @GeneratedValue(generator = "sequence-generator")
	 * 
	 * @GenericGenerator( name = "sequence-generator", strategy =
	 * "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
	 * 
	 * @Parameter(name = "sequence_name", value = "user_sequence"),
	 * 
	 * @Parameter(name = "initial_value", value = "1"),
	 * 
	 * @Parameter(name = "increment_size", value = "1") } )
	 */
	private int messageId;
	private int userId;
	private String message;
	private long timeStamp;
	private int isSent;

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getIsSent() {
		return isSent;
	}

	public void setIsSent(int isSent) {
		this.isSent = isSent;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
