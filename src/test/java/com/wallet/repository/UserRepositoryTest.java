package com.wallet.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

	
	@Autowired
	UserRepository userRepository;
	
	@Test
	
	public void testSave() {
		User u = new User();
		u.setName("test");
		u.setPassword("123456");
		u.setEmail("teste@gmail.com");
		
		User response = userRepository.save(u);
		
		assertNotNull(response);
	}
	
}
