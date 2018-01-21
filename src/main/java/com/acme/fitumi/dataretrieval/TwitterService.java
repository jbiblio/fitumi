package com.acme.fitumi.dataretrieval;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.acme.fitumi.model.User;
import com.acme.fitumi.model.UserProfile;
import com.acme.fitumi.repository.UserRepository;

@Service
public class TwitterService {

	@Autowired
	private UserRepository ur;

	@Scheduled(fixedRate = 60000)
	public void pullTwitterData() {

		List<User> users = ur.findAll();

		RestTemplate r = new RestTemplate();
		for (User user : users) {
			try {
				RequestEntity<?> request = new RequestEntity<>(HttpMethod.GET,
						URI.create("https://falcongw2.cfapps.eu10.hana.ondemand.com/twitter?userId="
								+ user.getTwitterUserID() + "&token=" + user.getTwitterAccessToken() + "&secret="
								+ user.getTwitterSecret() + "&lastTweetId=" + user.getLastPostedTweetId()));

				ResponseEntity<UserProfile> userProfiles = r.exchange(request, UserProfile.class);
				UserProfile twitterUser = userProfiles.getBody();

				User myUser = ur.findOne(user.getId());
				if (myUser != null) {
					myUser.setLastPostedTweetId(twitterUser.getLastPostedTweetId());
					myUser.setTotalRating(twitterUser.getTotalRating());
					myUser.setLastUpdate(new Date());
					System.out.println("Rated user " + user.getTwitterUserID() + " to " + twitterUser.getTotalRating());
				} else {
					System.err.println("Cannot find user by ID: " + user.getId());
				}
			} catch (Exception exc) {
				exc.printStackTrace(System.err);
			}
		}
	}
}
