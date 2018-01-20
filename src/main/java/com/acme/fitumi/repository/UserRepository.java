package com.acme.fitumi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.acme.fitumi.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	public User findByTwitterUserID(long twitterID);

}
