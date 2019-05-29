package com.ls.webMod.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ls.businessMod.service.UserService;
import com.ls.businessMod.service.UserServiceImpl;
import com.ls.dataMod.model.CustomUserDetails;
import com.ls.dataMod.model.user.User;

@RestController
//@CrossOrigin(origins="http://localhost:4200")
public class LoginRestController {
	
	@Autowired
	private UserService userService;
	
	
	
	//@PreAuthorize("hasAnyRole('ADMIN','USER')") // Authorize this method to be called only when the user has he role admin
	@GetMapping("/loginUser")
	//public CustomUserDetails securedHello(Principal principal, User user){
	public User validUser(@RequestParam("email") String email, @RequestParam("password") String password){
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();*/
		
		//CustomUserDetails CustomUserDetails = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();;
		//CustomUserDetails CustomUserDetails = (CustomUserDetails) userService.loadUserByUsername(user.getUserName());
		User user = userService.loadUser(email, password);
		return user;
	}

	@GetMapping("/userByEmail")
	public User getUserByEmail(@RequestParam("email") String email){
		System.out.println("inside getUserByName:"+email);
		User user = null;
		try {
			user = (User) userService.loadUserByEmail(email);
			System.out.println("inside getUserByName2:"+user);
		}catch(UsernameNotFoundException e) {
			System.out.println("exception");
			return user;
		}
		return user;
	}

	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public User addUser(@RequestBody User user){
		System.out.println(user.getUserName());
		return userService.addUser(user);
	}
	
	@PutMapping("/updateUserDetails")
	public User updateUserDetails(@RequestBody User user){
		return userService.updateUserDetails(user);
	}
	
	@DeleteMapping("/deleteUser")
	public String deleteUser(@RequestBody User user){
		userService.deleteUser(user);
		return "deleted";
	}
}
