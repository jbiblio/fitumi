package com.acme.fitumi.twitter;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterService {

	public void fetchHomeTimeline() throws TwitterException {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setOAuthConsumerKey("LC0J8w1IZKgtJtWvwMUXpVuZV");
		cb.setOAuthConsumerSecret("q4mbMRGgx2cnlVmLwsUkeTzXHoYWnhtE8yyJw4NWqoUmCCCt78");
		cb.setOAuthAccessToken("954446428843192320-vF1YvU2X84ErMyAPaxSqWN2MlaRQE1W");
		cb.setOAuthAccessTokenSecret("ElUTHfhsAiTbCjXjPVdh8EQvD5R3PLTbjArEw50S6ZWeY");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		ResponseList<Status> timeline = twitter.getHomeTimeline(new Paging(0, 20));
		timeline.stream().map(t -> t.getText()).forEach(System.out::print);

		timeline.stream().map(t -> {
			try {
				return twitter.showStatus(t.getId());
			} catch (TwitterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return t;
		}).forEach(s -> s.getText());
	}

}
