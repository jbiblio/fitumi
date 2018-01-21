package com.acme.fitumi.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class User {

	private String gender;

	private String homeTown;
	private String id;
	private long lastPostedTweetId;
	private String matchFrequency;
	private int numberOfClubRelatedTweets;
	private int numberOfTwitterFollowers;
	private int numberOfTwitterFollowing;
	private long totalRating;
	private List<TweetRating> tweetRatings;
	private String twitterAccessToken;
	private String twitterName;
	private String twitterScreenName;
	private String twitterSecret;
	private long twitterUserID;
	private Date lastUpdate;

	public User() {
	}

	public User(long twitterUserID, String twitterName, String twitterScreenName, String twitterAccessToken,
			String twitterSecret) {
		super();
		this.twitterUserID = twitterUserID;
		this.twitterName = twitterName;
		this.twitterScreenName = twitterScreenName;
		this.twitterAccessToken = twitterAccessToken;
		this.twitterSecret = twitterSecret;
	}

	public String getGender() {
		return gender;
	}

	public String getHomeTown() {
		return homeTown;
	}

	@Id
	public String getId() {
		return id;
	}

	public long getLastPostedTweetId() {
		return lastPostedTweetId;
	}

	public String getMatchFrequency() {
		return matchFrequency;
	}

	public int getNumberOfClubRelatedTweets() {
		return numberOfClubRelatedTweets;
	}

	public int getNumberOfTwitterFollowers() {
		return numberOfTwitterFollowers;
	}

	public int getNumberOfTwitterFollowing() {
		return numberOfTwitterFollowing;
	}

	public long getTotalRating() {
		return totalRating;
	}

	public List<TweetRating> getTweetRatings() {
		return tweetRatings;
	}

	public String getTwitterAccessToken() {
		return twitterAccessToken;
	}

	public String getTwitterName() {
		return twitterName;
	}

	public String getTwitterScreenName() {
		return twitterScreenName;
	}

	public String getTwitterSecret() {
		return twitterSecret;
	}

	public long getTwitterUserID() {
		return twitterUserID;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	@SuppressWarnings("unused")
	private void setId(String id) {
		this.id = id;
	}

	public void setLastPostedTweetId(long lastPostedTweetId) {
		this.lastPostedTweetId = lastPostedTweetId;
	}

	public void setMatchFrequency(String matchFrequency) {
		this.matchFrequency = matchFrequency;
	}

	public void setNumberOfClubRelatedTweets(int numberOfClubRelatedTweets) {
		this.numberOfClubRelatedTweets = numberOfClubRelatedTweets;
	}

	public void setNumberOfTwitterFollowers(int numberOfFollowers) {
		this.numberOfTwitterFollowers = numberOfFollowers;
	}

	public void setNumberOfTwitterFollowing(int numberOfFollowing) {
		this.numberOfTwitterFollowing = numberOfFollowing;
	}

	public void setTotalRating(long totalRating) {
		this.totalRating = totalRating;
	}

	public void setTweetRatings(List<TweetRating> tweetRatings) {
		this.tweetRatings = tweetRatings;
	}

	public void setTwitterAccessToken(String twitterAccessToken) {
		this.twitterAccessToken = twitterAccessToken;
	}

	public void setTwitterName(String twitterName) {
		this.twitterName = twitterName;
	}

	public void setTwitterScreenName(String twitterScreenName) {
		this.twitterScreenName = twitterScreenName;
	}

	public void setTwitterSecret(String twitterSecret) {
		this.twitterSecret = twitterSecret;
	}

	@SuppressWarnings("unused")
	private void setTwitterUserID(long twitterUserID) {
		this.twitterUserID = twitterUserID;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}