package com.acme.fitumi.controller;

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
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	private UserRepository ur;

	@RequestMapping(name = "dashboard", method = RequestMethod.GET)
	public String dashboard(Model model, @RequestParam("twitterUserID") Long twitterUserId) {
		User user = ur.findByTwitterUserID(twitterUserId);

		model.addAttribute("user", user);

		return "dashboard";
	}

}
