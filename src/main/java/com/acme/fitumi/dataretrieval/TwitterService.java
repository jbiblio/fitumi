package com.acme.fitumi.dataretrieval;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acme.fitumi.model.User;
import com.acme.fitumi.repository.UserRepository;

@Service
public class TwitterService {

	@Autowired
	private UserRepository ur;

	@Autowired
	private TwitterProfileService twitterProfileService;

	// @Scheduled(fixedRate = 60000)
	public void pullTwitterData() {

		List<User> users = ur.findAll();

		for (User user : users) {

			long twitterUserID = user.getTwitterUserID();
			twitterProfileService.updateTwitterProfile(twitterUserID);

		}
	}

}
