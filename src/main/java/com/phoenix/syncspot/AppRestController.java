package com.phoenix.syncspot;

import com.phoenix.syncspot.entity.User;
import com.phoenix.syncspot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })

public class AppRestController {

	@Autowired
	private UserRepository userRepo;

	@PostMapping("/signup")
	public ResponseEntity<User> signup(@RequestBody User user) {
		if(userRepo.existsByUsername(user.getUsername())){
			return new ResponseEntity("Username Already Taken",HttpStatus.CONFLICT);
		}
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return new ResponseEntity(userRepo.save(user),HttpStatus.CREATED);
	}
	@PostMapping("/login")
	public ResponseEntity<?> login() {
		if(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString() != null) {
			System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
			return new ResponseEntity(SecurityContextHolder.getContext().getAuthentication(), HttpStatus.ACCEPTED);
		}
		else{
			return new ResponseEntity("Login Failed", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/users")
	public Authentication listUsers(Model model) {
		if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null) {
			System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
		}
		else{
			System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
		}

		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		return SecurityContextHolder.getContext().getAuthentication();
	}
}
