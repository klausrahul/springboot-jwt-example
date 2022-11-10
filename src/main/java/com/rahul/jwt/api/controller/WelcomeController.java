package com.rahul.jwt.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.jwt.api.dto.AuthRequest;
import com.rahul.jwt.api.dto.AuthResponce;
import com.rahul.jwt.api.util.JWTUtil;

@RestController
public class WelcomeController {

	@Autowired
	private JWTUtil util;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/")
	public String welcome() {
		return "Hi.............";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthResponce> genrateTocken(@RequestBody AuthRequest request) throws Exception {
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPass()));
		} catch (Exception ex) {
			throw new Exception("inavalid username/password");
		}

		String jwt= util.generateToken(request.getUserName());
		
		return ResponseEntity.ok(new AuthResponce(jwt));
	}

}
