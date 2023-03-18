package com.finalpj.backend;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalpj.backend.util.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class TokenTest {
	@Autowired
	JwtUtil util;
	
	@Test
	public void tokenGenTest() {
		String user_id = "srlee";
		// when
		String token = util.createAuthToken(user_id);
		System.out.println(token);
		// then
		assertNotNull(token);
		log.debug(token);
	}
	
	@Test
	public void contentTest() {
		// given
		String user_id = "srlee1";		
		// when
		String token = util.createAuthToken(user_id);
		Map<String, Object> content = util.checkAndGetClaims(token);
		// then
		assertEquals(content.get("sub"), "authToken");
		assertEquals(content.get("sub"), "authToken");
		assertEquals(content.get("user"), user_id);
	}
	
	 @Test
	 public void wrongTokenTest() {
	 	// givens
	 	String fakeToken = "fakeToken";
	 	// when-then
	 	assertThrows(MalformedJwtException.class, ()->{
	 		util.checkAndGetClaims(fakeToken);			
	 	});
	 }
	
	 @Test
	 public void expiredTest() {
	 	// given
	 	String fakeToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhdXRoVG9rZW4iLCJleHAiOjE2NTExMDExOTgsInVzZXIiOiJtZW1iZXJAcXVpZXRqdW4ueHl6In0.Xa6JuhxT93zIi2Num_CPej3NwsFrEMmhXu8sytdinNo";
	 	// when-then
	 	assertThrows(ExpiredJwtException.class, ()->{
	 		util.checkAndGetClaims(fakeToken);			
	 	});
	 }
}