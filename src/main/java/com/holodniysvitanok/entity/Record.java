package com.holodniysvitanok.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "record_table")
public class Record {

	@Id
	@Column(name = "id_record")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "user_name_record")
	private String userName;

	@Column(name = "date_record")
	private Date date;

	@Column(name = "action_record")
	private String action;

	@Column(name = "string_object_record", columnDefinition="TEXT")
	private String stringObject;

	
	/*
	 * Constructor
	 */
	public Record() {
	}

	
	/*
	 * Getters and setters
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}


	public String getStringObject() {
		return stringObject;
	}


	public void setStringObject(String stringObject) {
		this.stringObject = stringObject;
	}

}
