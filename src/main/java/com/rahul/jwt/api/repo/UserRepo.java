package com.rahul.jwt.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.jwt.api.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByUserName(String username);
}
