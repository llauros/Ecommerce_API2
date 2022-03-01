package com.easymart.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.easymart.entities.UserEntity;
import com.easymart.repositories.UserRepository;

@Component
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner  {

	@Autowired
	 private UserRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// DATABASE SEEDING FOR USER
		UserEntity user1 = new UserEntity("Maria Brown", "maria@gmail.com", "123456");
		UserEntity user2 = new UserEntity("Alex Green", "alex@gmail.com", "123456");
		repo.saveAll(Arrays.asList(user1, user2));
		
	}

}
