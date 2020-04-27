package com.wallet.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wallet.entity.User;

public interface UserService {

	User save(User u);
	
	Optional<User> findByEmail(String email);
}
