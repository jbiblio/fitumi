package com.acme.fitumi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.acme.fitumi.dataretrieval.TwitterProfileService;
import com.acme.fitumi.model.User;
import com.acme.fitumi.repository.UserRepository;

@Controller
@Scope("session")
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	private UserRepository ur;

	@Autowired
	private TwitterProfileService tps;

	@RequestMapping(method = RequestMethod.GET)
	public String dashboard(Model model, @RequestParam("twitterUserID") Long twitterUserId) {
		User user = ur.findByTwitterUserID(twitterUserId);

		model.addAttribute("user", user);

		return "Rewards";
	}

	@RequestMapping(path = "refresh", method = RequestMethod.GET)
	public String refresh(Model model, @RequestParam("twitterUserID") Long twitterUserId) {

		User updatedUser = tps.updateTwitterProfile(twitterUserId);

		if (updatedUser == null) {
			updatedUser = ur.findByTwitterUserID(twitterUserId);
		}

		model.addAttribute("user", updatedUser);

		return "Rewards";
	}

	@RequestMapping(path = "reset", method = RequestMethod.GET)
	public String reset(Model model, @RequestParam("twitterUserID") Long twitterUserId) {

		User user = ur.findByTwitterUserID(twitterUserId);
		user.setLastPostedTweetId(0);
		ur.save(user);

		model.addAttribute("user", user);

		return "redirect:refresh?twitterUserID=" + twitterUserId;
	}

}
