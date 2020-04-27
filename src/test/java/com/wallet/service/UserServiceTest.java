package com.wallet.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.wallet.entity.User;
import com.wallet.repository.UserRepository;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {

	@MockBean
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@BeforeEach
	public void setUp() {
		BDDMockito.given(userRepository.findByEmailEquals(Mockito.anyString())).willReturn(Optional.of(new User()));
	}
	
	@Test
	@DisplayName("UserService: find by email")
	public void testFindByEmail() {
		Optional<User> user = userService.findByEmail("email@teste.com");
		
		assertTrue(user.isPresent());
	}
}
