package com.acme.fitumi.controller;

import javax.inject.Inject;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.acme.fitumi.model.User;
import com.acme.fitumi.repository.UserRepository;

@Controller
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

	@RequestMapping(method = RequestMethod.GET)
	public String helloTwitter(Model model) {
		if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
			return "redirect:/connect/twitter";
		}

		TwitterProfile userProfile = twitter.userOperations().getUserProfile();
		long twitterID = userProfile.getId();

		int followersCount = userProfile.getFollowersCount();
		int friendsCount = userProfile.getFriendsCount();
		String twitterName = userProfile.getName();
		String twitterScreenName = userProfile.getScreenName();
		String twitterAccessToken = connectionRepository.findPrimaryConnection(Twitter.class).createData()
				.getAccessToken();

		User user = ur.findByTwitterUserID(twitterID);
		if (user == null) {
			user = new User(twitterID, twitterName, twitterScreenName, twitterAccessToken);
		}
		user.setTwitterName(twitterName);
		user.setTwitterScreenName(twitterScreenName);
		user.setNumberOfTwitterFollowers(Long.valueOf(followersCount));
		user.setNumberOfTwitterFollowing(Long.valueOf(friendsCount));

		ur.save(user);

		model.addAttribute("user", user);
		return "registered";
	}

}