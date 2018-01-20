package com.acme.fitumi.model;

import org.springframework.data.annotation.Id;

public class User {

	private String id;

	private long twitterUserID;
	private String twitterName;
	private String twitterScreenName;
	private long lastPostedTweetId;
	private Long numberOfTwitterFollowers;
	private Long numberOfTwitterFollowing;
	private String twitterAccessToken;

	public User() {
	}

	public User(long twitterUserID, String twitterName, String twitterScreenName, String twitterAccessToken) {
		super();
		this.twitterUserID = twitterUserID;
		this.twitterName = twitterName;
		this.twitterScreenName = twitterScreenName;
		this.twitterAccessToken = twitterAccessToken;
	}

	@Id
	public String getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(String id) {
		this.id = id;
	}

	public long getTwitterUserID() {
		return twitterUserID;
	}

	@SuppressWarnings("unused")
	private void setTwitterUserID(long twitterUserID) {
		this.twitterUserID = twitterUserID;
	}

	public String getTwitterName() {
		return twitterName;
	}

	public void setTwitterName(String twitterName) {
		this.twitterName = twitterName;
	}

	public String getTwitterScreenName() {
		return twitterScreenName;
	}

	public void setTwitterScreenName(String twitterScreenName) {
		this.twitterScreenName = twitterScreenName;
	}

	public long getLastPostedTweetId() {
		return lastPostedTweetId;
	}

	public void setLastPostedTweetId(long lastPostedTweetId) {
		this.lastPostedTweetId = lastPostedTweetId;
	}

	public Long getNumberOfTwitterFollowers() {
		return numberOfTwitterFollowers;
	}

	public void setNumberOfTwitterFollowers(Long numberOfFollowers) {
		this.numberOfTwitterFollowers = numberOfFollowers;
	}

	public Long getNumberOfTwitterFollowing() {
		return numberOfTwitterFollowing;
	}

	public void setNumberOfTwitterFollowing(Long numberOfFollowing) {
		this.numberOfTwitterFollowing = numberOfFollowing;
	}

	public String getTwitterAccessToken() {
		return twitterAccessToken;
	}

	public void setTwitterAccessToken(String twitterAccessToken) {
		this.twitterAccessToken = twitterAccessToken;
	}

}