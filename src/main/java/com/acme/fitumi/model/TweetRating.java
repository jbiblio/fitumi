package com.acme.fitumi.model;

import org.springframework.data.annotation.Id;

public class TweetRating {
	private String id;

	private int rating;

	private String ratingMessage;

	private String text;

	private long tweetID;

	public TweetRating() {
		super();
	}

	public TweetRating(long tweetID, String text, int rating, String ratingMessage) {
		super();
		this.rating = rating;
		this.ratingMessage = ratingMessage;
		this.text = text;
		this.tweetID = tweetID;
	}

	@Id
	public String getId() {
		return id;
	}

	public long getRating() {
		return rating;
	}

	public String getRatingMessage() {
		return ratingMessage;
	}

	public String getText() {
		return text;
	}

	public long getTweetID() {
		return tweetID;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setRatingMessage(String ratingMessage) {
		this.ratingMessage = ratingMessage;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setTweetID(long tweetID) {
		this.tweetID = tweetID;
	}

}
