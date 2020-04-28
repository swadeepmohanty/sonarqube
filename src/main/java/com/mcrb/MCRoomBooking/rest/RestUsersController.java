package com.mcrb.MCRoomBooking.rest;


import com.mcrb.MCRoomBooking.data.UserRepository;
import com.mcrb.MCRoomBooking.model.AngularUser;
import com.mcrb.MCRoomBooking.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class RestUsersController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping()
	public List<AngularUser> getAllUsers(){
		return userRepository.findAll().parallelStream().map( user -> new AngularUser(user)).collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public AngularUser getUser(@PathVariable("id") Long id) {
		System.out.println("Got a request for user " + id);
		return new AngularUser(userRepository.findById(id).get());
	}
	
	@PutMapping()
	public AngularUser updateUser(@RequestBody AngularUser updatedUser) throws InterruptedException {
//		throw new RuntimeException("something went wrong");
		User originalUser = userRepository.findById(updatedUser.getId()).get();
		originalUser.setName(updatedUser.getName());
		return new AngularUser(userRepository.save(originalUser));
	}
	
	@PostMapping()
	public AngularUser newUser(@RequestBody User user) {
		return new AngularUser(userRepository.save(user));
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userRepository.deleteById(id);
	}
	
	@GetMapping("/resetPassword/{id}")
	public void resetPassword(@PathVariable("id") Long id) {
		User user = userRepository.findById(id).get();
		user.setPassword("secret");
		userRepository.save(user);
	}
}
