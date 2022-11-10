package com.rahul.jwt.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rahul.jwt.api.entity.User;
import com.rahul.jwt.api.repo.UserRepo;

@SpringBootApplication
public class SpringSecurityJwtExampleApplication {

	
	@Autowired
	UserRepo repo;
	
	@PostConstruct
	public void initUser() {
		List<User> users=Stream.of(
				new User(101,"Rahul","password","rahul@abc.com"),
				new User(102,"user1","ped1","user1@abc.com"),
				new User(103,"user2","ped2","user2@abc.com")
				).collect(Collectors.toList());
		repo.saveAll(users);
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
	}

}
