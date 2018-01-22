package com.acme.fitumi.model;

import java.util.List;

public class UserProfile {
	private long twitterUserID;
	private long lastPostedTweetId;
	private int totalRating;
	private List<TweetRating> allTweetsRating;

	public UserProfile() {
		super();
	}

	public UserProfile(long twitterUserID, long lastPostedTweetId, int totalRating) {
		super();
		this.twitterUserID = twitterUserID;
		this.lastPostedTweetId = lastPostedTweetId;
		this.totalRating = totalRating;
	}

	public UserProfile(long twitterUserID, long lastPostedTweetId, int totalRating, List<TweetRating> tweetRatings) {
		super();
		this.twitterUserID = twitterUserID;
		this.lastPostedTweetId = lastPostedTweetId;
		this.totalRating = totalRating;
		this.allTweetsRating = tweetRatings;
	}

	public long getTwitterUserID() {
		return twitterUserID;
	}

	public void setTwitterUserID(long twitterUserID) {
		this.twitterUserID = twitterUserID;
	}

	public long getLastPostedTweetId() {
		return lastPostedTweetId;
	}

	public void setLastPostedTweetId(long lastPostedTweetId) {
		this.lastPostedTweetId = lastPostedTweetId;
	}

	public int getTotalRating() {
		return totalRating;
	}

	public void setTotalRating(int totalRating) {
		this.totalRating = totalRating;
	}

	public List<TweetRating> getAllTweetsRating() {
		return allTweetsRating;
	}

	public void setAllTweetsRating(List<TweetRating> ratings) {
		this.allTweetsRating = ratings;
	}

}
