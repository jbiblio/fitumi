package com.acme.fitumi.dataretrieval;

import java.net.URI;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.acme.fitumi.model.User;
import com.acme.fitumi.model.UserProfile;
import com.acme.fitumi.repository.UserRepository;

@Service
public class TwitterProfileService {
	@Autowired
	private UserRepository ur;

	public User updateTwitterProfile(long twitterUserID) {

		User user = ur.findByTwitterUserID(twitterUserID);

		String twitterSecret = user.getTwitterSecret();
		String twitterAccessToken = user.getTwitterAccessToken();
		if (twitterSecret != null && twitterAccessToken != null) {
			RestTemplate r = new RestTemplate();
			try {
				RequestEntity<?> request = new RequestEntity<>(HttpMethod.GET,
						URI.create("https://falcongw2.cfapps.eu10.hana.ondemand.com/twitter?userId=" + twitterUserID
								+ "&token=" + twitterAccessToken + "&secret=" + twitterSecret + "&lastTweetId="
								+ user.getLastPostedTweetId()));

				ResponseEntity<UserProfile> userProfiles = r.exchange(request, UserProfile.class);
				UserProfile twitterUser = userProfiles.getBody();

				user.setLastPostedTweetId(twitterUser.getLastPostedTweetId());
				user.setTotalRating(twitterUser.getTotalRating());
				user.setLastUpdate(new Date());
				if (twitterUser.getAllTweetsRating() != null) {

					int tweets = twitterUser.getAllTweetsRating().size() - 4;
					user.setNumberOfClubRelatedTweets(tweets < 0 ? 0 : tweets);
					user.setTweetRatings(twitterUser.getAllTweetsRating());
				}

				ur.save(user);
				System.out.println("Rated user " + twitterUserID + " to " + twitterUser.getTotalRating());

				return user;
			} catch (Exception exc) {
				exc.printStackTrace(System.err);
				return null;
			}
		} else {
			System.err.println("Skip user without access_token/secret of ID: " + user.getId());
			return null;
		}

	}
}
