package com.acme.fitumi.dataretrieval;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import com.acme.fitumi.repository.UserRepository;

//@Service
public class TwitterService {

	@Autowired
	UserRepository ur;

	// @PostConstruct
	@Scheduled(fixedRate = 10000)
	public void pullTwitterData() {
		RestTemplate r = new RestTemplate();
		ResponseEntity<Object[]> response = r.getForEntity("https://falcongw2.cfapps.eu10.hana.ondemand.com/twitter",
				Object[].class);
		// Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(new Runnable() {
		//
		// @Override
		// public void run() {
		// System.out.println("Polling!");
		// }
		// }, 10, 60, TimeUnit.SECONDS);
		System.out.println(response.getBody());
	}
}
