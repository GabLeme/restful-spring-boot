package com.wallet.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

// import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.wallet.entity.User;

@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

	private static final String EMAIL = "email@teste.com";
	
	@Autowired
	UserRepository userRepository;
	
	@BeforeEach
	public void setUp() {
		User u = new User();
		u.setName("SetupUser");
		u.setEmail(EMAIL);
		u.setPassword("123456");
		
		userRepository.save(u);
	}
	
	@AfterEach
	public void tearDown() {
		userRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Save user")
	public void testSave() {
		User u = new User();
		u.setName("test");
		u.setPassword("123456");
		u.setEmail("teste@gmail.com");
		
		User response = userRepository.save(u);
		
		assertNotNull(response);
	}
	
	@Test
	@DisplayName("Find user by e-mail")
	public void testFindByEmail() {
		Optional<User> response = userRepository.findByEmailEquals(EMAIL);
		
		assertTrue(response.isPresent());
		assertEquals(response.get().getEmail(), EMAIL);
	}
	
}
