package com.acme.fitumi.controller;

import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acme.fitumi.model.User;
import com.acme.fitumi.repository.UserRepository;

@Controller
@Scope("session")
@RequestMapping("/register")
public class RegisterController {

	private Twitter twitter;

	private ConnectionRepository connectionRepository;

	private UserRepository ur;

	@Inject
	public RegisterController(Twitter twitter, ConnectionRepository connectionRepository, UserRepository userRepo) {
		this.twitter = twitter;
		this.connectionRepository = connectionRepository;
		this.ur = userRepo;
	}

	@RequestMapping
	public String register(Model model, @RequestParam(name = "homeTown", required = false) String homeTown,
			@RequestParam(name = "gender", required = false) String gender,
			@RequestParam(name = "matchFrequency", required = false) String matchFrequency) {
		if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
			return "redirect:/connect/twitter";
		}

		TwitterProfile userProfile = twitter.userOperations().getUserProfile();
		long twitterID = userProfile.getId();

		int followersCount = userProfile.getFollowersCount();
		int friendsCount = userProfile.getFriendsCount();
		String twitterName = userProfile.getName();
		String twitterScreenName = userProfile.getScreenName();
		ConnectionData authenticationData = connectionRepository.findPrimaryConnection(Twitter.class).createData();
		String twitterAccessToken = authenticationData.getAccessToken();
		String twitterSecret = authenticationData.getSecret();

		User user = ur.findByTwitterUserID(twitterID);
		if (user == null) {
			user = new User(twitterID, twitterName, twitterScreenName, twitterAccessToken, twitterSecret);
		}
		user.setTwitterAccessToken(twitterAccessToken);
		user.setTwitterSecret(twitterSecret);
		user.setTwitterName(twitterName);
		user.setTwitterScreenName(twitterScreenName);
		user.setNumberOfTwitterFollowers(followersCount);
		user.setNumberOfTwitterFollowing(friendsCount);
		user.setGender(gender);
		user.setMatchFrequency(matchFrequency);
		user.setHomeTown(homeTown);

		ur.save(user);

		long count = ur.count();

		model.addAttribute("user", user);
		model.addAttribute("registeredUsers", count);
		return "registered";
	}

}