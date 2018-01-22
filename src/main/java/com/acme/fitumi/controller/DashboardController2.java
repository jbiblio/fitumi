package com.acme.fitumi.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.acme.fitumi.model.User;
import com.acme.fitumi.repository.UserRepository;

@Controller
@Scope("session")
@RequestMapping("/dashboard2")
public class DashboardController2 {

	@Autowired
	private UserRepository ur;

	@RequestMapping(name = "dashboard", method = RequestMethod.GET)
	public String dashboard(Model model, @RequestParam("twitterUserID") Long twitterUserId) {
		User user = ur.findByTwitterUserID(twitterUserId);
		Random rnd = new Random();
		int nextRating = rnd.nextInt(40);
		int newFollowers = rnd.nextInt(3);
		int newFcbFeeds = rnd.nextInt(4);

		user.setTotalRating(user.getTotalRating() + nextRating);
		user.setNumberOfClubRelatedTweets(user.getNumberOfClubRelatedTweets() + newFcbFeeds);
		user.setNumberOfTwitterFollowers(user.getNumberOfTwitterFollowers() + newFollowers);

		ur.save(user);

		model.addAttribute("user", user);

		return "Rewards";
	}

}
