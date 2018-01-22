package com.acme.fitumi.model;

import org.springframework.data.annotation.Id;

public class TweetRating {
	private String id;
	private String notification;
	private String tweet;
	private double value;

	public TweetRating() {
		super();
	}

	@Id
	public String getId() {
		return id;
	}

	public String getNotification() {
		return notification;
	}

	public String getTweet() {
		return tweet;
	}

	public double getValue() {
		return value;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
