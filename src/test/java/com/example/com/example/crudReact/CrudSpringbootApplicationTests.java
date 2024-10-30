package com.example.com.example.crudReact;

import com.example.com.example.crudReact.auth.AuthController;
import com.example.com.example.crudReact.auth.LoginRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CrudSpringbootApplicationTests {

	@Test
	void testLogin() {

		LoginRequest loginRequest = new LoginRequest("admin", "demo");
		String userExpected = "admin";
		String passExpected = "demo";
		assertEquals(userExpected, loginRequest.getUsername());
		assertTrue(passExpected.equals(loginRequest.getPassword()));
	}

}
